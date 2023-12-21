package gregtech.common.tileentities.machines.multiblock;

import static com.google.common.primitives.Ints.saturatedCast;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static gregtech.api.multitileentity.multiblock.base.MultiBlockPart.ENERGY_IN;
import static gregtech.api.multitileentity.multiblock.base.MultiBlockPart.FLUID_IN;
import static gregtech.api.multitileentity.multiblock.base.MultiBlockPart.FLUID_OUT;
import static gregtech.api.multitileentity.multiblock.base.MultiBlockPart.ITEM_IN;
import static gregtech.api.multitileentity.multiblock.base.MultiBlockPart.ITEM_OUT;
import static gregtech.api.multitileentity.multiblock.base.MultiBlockPart.NOTHING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;

import org.apache.commons.lang3.ArrayUtils;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.gtnewhorizon.structurelib.util.Vec3Impl;
import com.gtnewhorizons.modularui.api.forge.ItemStackHandler;
import com.gtnewhorizons.modularui.api.math.Alignment;
import com.gtnewhorizons.modularui.api.screen.ModularWindow;
import com.gtnewhorizons.modularui.api.screen.UIBuildContext;
import com.gtnewhorizons.modularui.api.widget.IWidgetBuilder;
import com.gtnewhorizons.modularui.common.widget.ButtonWidget;
import com.gtnewhorizons.modularui.common.widget.MultiChildWidget;
import com.gtnewhorizons.modularui.common.widget.SlotGroup;
import com.gtnewhorizons.modularui.common.widget.TextWidget;

import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.fluid.FluidTankGT;
import gregtech.api.gui.modularui.GT_UITextures;
import gregtech.api.logic.ComplexParallelProcessingLogic;
import gregtech.api.multitileentity.enums.GT_MultiTileCasing;
import gregtech.api.multitileentity.multiblock.base.ComplexParallelController;
import gregtech.api.multitileentity.multiblock.casing.Glasses;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_StructureUtility;
import gregtech.common.tileentities.casings.upgrade.Inventory;

public class AdvChemicalReactor extends ComplexParallelController<AdvChemicalReactor> {

    private static IStructureDefinition<AdvChemicalReactor> STRUCTURE_DEFINITION = null;
    protected static final String STRUCTURE_PIECE_T1 = "T1";
    protected static final Vec3Impl STRUCTURE_OFFSET = new Vec3Impl(3, 1, 0);
    protected static final int PROCESS_WINDOW_BASE_ID = 100;
    protected static final int ITEM_WHITELIST_SLOTS = 8;
    protected static final int FLUID_WHITELIST_SLOTS = 8;
    protected static final int MAX_PROCESSES = 4;
    protected int numberOfProcessors = MAX_PROCESSES; // TODO: Set this value depending on structure
    protected HeatingCoilLevel coilTier;
    protected final ArrayList<HashSet<String>> processWhitelists = new ArrayList<>(MAX_PROCESSES);
    protected final ArrayList<ItemStackHandler> processWhitelistInventoryHandlers = new ArrayList<>(MAX_PROCESSES);
    protected final ArrayList<ArrayList<IFluidTank>> processFluidWhiteLists = new ArrayList<>(MAX_PROCESSES);
    protected boolean wasWhitelistOpened = false;

    public AdvChemicalReactor() {
        super();
        for (int i = 0; i < MAX_PROCESSES; i++) {
            processWhitelists.add(null);
            processWhitelistInventoryHandlers.add(new ItemStackHandler(ITEM_WHITELIST_SLOTS));
            ArrayList<IFluidTank> processFluidTanks = new ArrayList<>(FLUID_WHITELIST_SLOTS);
            for (int j = 0; j < FLUID_WHITELIST_SLOTS; j++) {
                processFluidTanks.add(new FluidTankGT());
            }
            processFluidWhiteLists.add(processFluidTanks);
        }
        processingLogic = new ComplexParallelProcessingLogic(getRecipeMap(), MAX_PROCESSES);
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeMaps.chemicalReactorRecipes;
    }

    @Override
    public void readMultiTileNBT(NBTTagCompound nbt) {
        super.readMultiTileNBT(nbt);
        final NBTTagCompound processWhiteLists = nbt.getCompoundTag("whiteLists");
        long capacity = 1000;
        if (nbt.hasKey(GT_Values.NBT.TANK_CAPACITY)) {
            capacity = saturatedCast(nbt.getLong(GT_Values.NBT.TANK_CAPACITY));
        }
        for (int i = 0; i < MAX_PROCESSES; i++) {
            registerInventory("processInventory" + i, "processInventory" + i, 8, Inventory.INPUT);
            registerFluidInventory(
                "processInventory" + i,
                "processInventory" + i,
                8,
                capacity,
                maxParallel * 2L,
                Inventory.INPUT);
            if (processWhiteLists != null) {
                final NBTTagCompound itemList = processWhiteLists.getCompoundTag("items" + i);
                if (itemList != null) {
                    processWhitelistInventoryHandlers.get(i)
                        .deserializeNBT(itemList);
                }
                final NBTTagList fluidList = processWhiteLists.getTagList("fluids" + i, Constants.NBT.TAG_COMPOUND);
                if (fluidList != null) {
                    for (int j = 0; j < fluidList.tagCount(); j++) {
                        final NBTTagCompound fluid = fluidList.getCompoundTagAt(j);
                        if (fluid != null) {
                            short index = fluid.getShort("s");
                            FluidStack fluidStack = FluidStack.loadFluidStackFromNBT(fluid);
                            if (fluidStack != null) {
                                processFluidWhiteLists.get(i)
                                    .get(index)
                                    .fill(fluidStack, true);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void writeMultiTileNBT(NBTTagCompound nbt) {
        super.writeMultiTileNBT(nbt);
        final NBTTagCompound processWhiteLists = new NBTTagCompound();
        for (int i = 0; i < MAX_PROCESSES; i++) {
            processWhiteLists.setTag(
                "items" + i,
                processWhitelistInventoryHandlers.get(i)
                    .serializeNBT());
            final NBTTagList fluidList = new NBTTagList();
            for (int j = 0; j < FLUID_WHITELIST_SLOTS; j++) {
                final FluidStack fluidStack = processFluidWhiteLists.get(i)
                    .get(j)
                    .getFluid();
                if (fluidStack != null) {
                    final NBTTagCompound tag = new NBTTagCompound();
                    tag.setByte("s", (byte) j);
                    fluidStack.writeToNBT(tag);
                    fluidList.appendTag(tag);
                }
            }
            processWhiteLists.setTag("fluids" + i, fluidList);
        }
        nbt.setTag("whiteLists", processWhiteLists);
    }

    @Override
    public short getCasingRegistryID() {
        return 0;
    }

    @Override
    public int getCasingMeta() {
        return GT_MultiTileCasing.Chemical.getId();
    }

    @Override
    public GT_Multiblock_Tooltip_Builder createTooltip() {
        final GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType("Chemical Reactor")
            .addInfo("Controller block for the Advanced Chemical Reactor")
            .addInfo("Does not lose efficiency when overclocked")
            .addInfo("Accepts fluids instead of fluid cells")
            .addInfo("Can do multiple different recipes at once")
            .addInfo("By using the whitelist filter a recipe can push its output")
            .addInfo("to a different recipes input to chain them")
            .addInfo(GT_Values.Authorminecraft7771)
            .addSeparator()
            .beginStructureBlock(5, 3, 3, false)
            .addController("Front center")
            .addCasingInfoExactly("PTFE Pipe Machine Casing", 8, false)
            .addCasingInfoExactly("Heating Coils", 3, true)
            .addCasingInfoExactly("EV+ Glass", 3, true)
            .addCasingInfoExactly("Motor Casing", 3, true)
            .addCasingInfoExactly("Chemical Casing", 27, false)
            .toolTipFinisher("Gregtech");
        return tt;
    }

    @Override
    public Vec3Impl getStartingStructureOffset() {
        return STRUCTURE_OFFSET;
    }

    @Override
    public boolean checkMachine() {
        setCoilTier(HeatingCoilLevel.None);
        setMaxComplexParallels(MAX_PROCESSES);
        buildState.startBuilding(getStartingStructureOffset());
        boolean result = checkPiece(STRUCTURE_PIECE_T1, buildState.stopBuilding());
        return result && super.checkMachine();
    }

    @Override
    public void construct(ItemStack trigger, boolean hintsOnly) {
        buildState.startBuilding(getStartingStructureOffset());
        buildPiece(STRUCTURE_PIECE_T1, trigger, hintsOnly, buildState.stopBuilding());
    }

    @Override
    public IStructureDefinition<AdvChemicalReactor> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<AdvChemicalReactor>builder()
                .addShape(
                    STRUCTURE_PIECE_T1,
                    transpose(
                        new String[][] { { "CPCPC", "CCCCC", "CPCPC" }, { "CGC~C", "GWWWC", "CGCCC" },
                            { "CPCPC", "CTTTC", "CPCPC" } }))
                .addElement(
                    'C',
                    addMultiTileCasing(
                        "gt.multitileentity.casings",
                        getCasingMeta(),
                        FLUID_IN | ITEM_IN | FLUID_OUT | ITEM_OUT | ENERGY_IN))
                .addElement('P', ofBlock(GregTech_API.sBlockCasings8, 1))
                .addElement('T', addMotorCasings(NOTHING))
                .addElement(
                    'W',
                    GT_StructureUtility.ofCoil(AdvChemicalReactor::setCoilTier, AdvChemicalReactor::getCoilTier))
                .addElement('G', Glasses.chainAllGlasses())
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    protected FluidStack[] getInputFluids(int index) {
        if (index < 0 || index >= MAX_PROCESSES) {
            return null;
        }
        if (separateInputs) {
            return ArrayUtils.addAll(
                getFluidInputsForTankArray("processInventory" + index),
                FluidTankGT.getFluidsFromTanks(inputTanks));
        } else {
            return super.getInputFluids(index);
        }
    }

    @Override
    protected ItemStack[] getInputItems(int index) {
        if (index < 0 || index >= MAX_PROCESSES) {
            return null;
        }
        if (separateInputs) {
            return ArrayUtils.addAll(
                getItemInputsForInventory("processInventory" + index),
                inputInventory.getStacks()
                    .toArray(new ItemStack[0]));
        } else {
            return super.getInputItems(index);
        }
    }

    @Override
    protected void outputItems(int index) {
        ComplexParallelProcessingLogic processingLogic = getComplexProcessingLogic();
        if (processingLogic != null && index >= 0 && index < maxComplexParallels) {
            for (int i = 0; i < MAX_PROCESSES; i++) {
                // Regenerate whitelist, if it has been reset
                if (processWhitelists.get(i) == null) {
                    generateWhitelist(i);
                }
                int outputIndex = i;
                // Output items that are on the whitelist of this process
                outputItems(
                    multiBlockInputInventory.get("processInventory" + i),
                    Arrays.stream(processingLogic.getOutputItems(index))
                        .filter(
                            itemStack -> processWhitelists.get(outputIndex)
                                .contains(getWhitelistString(itemStack)))
                        .toArray(ItemStack[]::new));
            }
            // Output remaining items
            if (processingLogic.getOutputItems(index) != null && processingLogic.getOutputItems(index).length > 0) {
                outputItems(processingLogic.getOutputItems(index));
            }
        }
    }

    @Override
    protected void outputFluids(int index) {
        ComplexParallelProcessingLogic processingLogic = getComplexProcessingLogic();
        if (processingLogic != null && index >= 0 && index < maxComplexParallels) {
            for (int i = 0; i < MAX_PROCESSES; i++) {
                // Regenerate whitelist, if it has been reset
                if (processWhitelists.get(i) == null) {
                    generateWhitelist(i);
                }
                int outputIndex = i;
                // Output fluids that are on the whitelist of this process
                outputFluids(
                    multiBlockInputTank.get("processInventory" + i),
                    Arrays.stream(processingLogic.getOutputFluids(index))
                        .filter(
                            fluidStack -> processWhitelists.get(outputIndex)
                                .contains(getWhitelistString(fluidStack)))
                        .toArray(FluidStack[]::new));
            }
            // Output remaining fluids
            if (processingLogic.getOutputFluids(index) != null && processingLogic.getOutputFluids(index).length > 0) {
                outputFluids(processingLogic.getOutputFluids(index));
            }
        }
    }

    @Override
    protected MultiChildWidget createMainPage(IWidgetBuilder<?> builder) {
        MultiChildWidget child = super.createMainPage(builder);
        for (int i = 0; i < MAX_PROCESSES; i++) {
            final int processIndex = i;
            child.addChild(
                new ButtonWidget().setPlayClickSound(true)
                    .setOnClick(
                        (clickData, widget) -> {
                            if (!widget.isClient()) widget.getContext()
                                .openSyncedWindow(PROCESS_WINDOW_BASE_ID + processIndex);
                        })
                    .setBackground(GT_UITextures.BUTTON_STANDARD, GT_UITextures.OVERLAY_BUTTON_WHITELIST)
                    .setSize(18, 18)
                    .setPos(20 * i + 18, 18));
        }
        return child;
    }

    @Override
    public void addUIWidgets(ModularWindow.Builder builder, UIBuildContext buildContext) {
        super.addUIWidgets(builder, buildContext);
        for (int i = 0; i < MAX_PROCESSES; i++) {
            final int processIndex = i;
            buildContext.addSyncedWindow(
                PROCESS_WINDOW_BASE_ID + i,
                (player) -> createProcessConfigWindow(player, processIndex));
        }
        buildContext.addCloseListener(() -> {
            // Reset HashSet, we will let it re-generate on next item output
            if (wasWhitelistOpened) {
                for (int i = 0; i < MAX_PROCESSES; i++) {
                    processWhitelists.set(i, null);
                }
                wasWhitelistOpened = false;
            }
        });
    }

    protected ModularWindow createProcessConfigWindow(final EntityPlayer player, final int processIndex) {
        wasWhitelistOpened = true;
        ModularWindow.Builder builder = ModularWindow.builder(86, 100);
        builder.widget(
            new TextWidget("Process " + processIndex).setTextAlignment(Alignment.Center)
                .setPos(13, 7));
        builder.setBackground(GT_UITextures.BACKGROUND_SINGLEBLOCK_DEFAULT);
        builder.widget(
            SlotGroup.ofItemHandler(processWhitelistInventoryHandlers.get(processIndex), 4)
                .startFromSlot(0)
                .endAtSlot(ITEM_WHITELIST_SLOTS - 1)
                .phantom(true)
                .background(getGUITextureSet().getItemSlot())
                .build()
                .setPos(7, 19));
        builder.widget(
            SlotGroup.ofFluidTanks(processFluidWhiteLists.get(processIndex), 4)
                .startFromSlot(0)
                .endAtSlot(FLUID_WHITELIST_SLOTS - 1)
                .phantom(true)
                .build()
                .setPos(7, 55));
        return builder.build();
    }

    @Override
    public String getTileEntityName() {
        return "gt.multitileentity.multiblock.advchemicalreactor";
    }

    @Override
    public String getLocalName() {
        return "Advanced Chemical Reactor";
    }

    public void setCoilTier(HeatingCoilLevel coilTier) {
        this.coilTier = coilTier;
    }

    public HeatingCoilLevel getCoilTier() {
        return coilTier;
    }

    @Override
    protected boolean hasPerfectOverclock() {
        return true;
    }

    protected void generateWhitelist(int processIndex) {
        HashSet<String> whitelist = new HashSet<>();
        for (ItemStack itemStack : processWhitelistInventoryHandlers.get(processIndex)
            .getStacks()) {
            if (itemStack != null) {
                whitelist.add(getWhitelistString(itemStack));
            }
        }
        for (IFluidTank tank : processFluidWhiteLists.get(processIndex)) {
            if (tank.getFluid() != null) {
                whitelist.add(getWhitelistString(tank.getFluid()));
            }
        }
        processWhitelists.set(processIndex, whitelist);
    }

    protected String getWhitelistString(ItemStack itemStack) {
        if (itemStack != null) {
            return itemStack.getUnlocalizedName();
        }
        return null;
    }

    protected String getWhitelistString(FluidStack fluidStack) {
        if (fluidStack != null) {
            return fluidStack.getUnlocalizedName();
        }
        return null;
    }
}
