package gregtech.api.multitileentity.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;

import cpw.mods.fml.common.Optional;
import gregtech.api.enums.Mods;
import gregtech.api.interfaces.tileentity.IBasicEnergyContainer;
import gregtech.api.interfaces.tileentity.IColoredTileEntity;
import gregtech.api.interfaces.tileentity.ICoverable;
import gregtech.api.interfaces.tileentity.IDebugableTileEntity;
import gregtech.api.interfaces.tileentity.IEnergyConnected;
import gregtech.api.interfaces.tileentity.IHasInventory;
import gregtech.api.interfaces.tileentity.IHasWorldObjectAndCoords;
import gregtech.api.interfaces.tileentity.ITexturedTileEntity;
import gregtech.api.interfaces.tileentity.ITurnable;
import gregtech.api.multitileentity.MultiTileEntityBlockInternal;
import gregtech.api.multitileentity.MultiTileEntityItemInternal;
import gregtech.api.multitileentity.MultiTileEntityRegistry;

/*
 * Heavily inspired by GT6
 */
public interface IMultiTileEntity
    extends IHasWorldObjectAndCoords, ICoverable, ITurnable, IHasInventory, IEnergyConnected, IBasicEnergyContainer,
    IFluidHandler, ITexturedTileEntity, IDebugableTileEntity, IColoredTileEntity {

    /**
     * Those two IDs HAVE to be saved inside the NBT of the TileEntity itself. They get set by the Registry itself, when
     * the TileEntity is placed.
     */
    short getMultiTileEntityID();

    short getMultiTileEntityRegistryID();

    /**
     * Called by the Registry with the default NBT Parameters and the two IDs you have to save, when the TileEntity is
     * created. aNBT may be null, take that into account if you decide to call the regular readFromNBT Function from
     * here.
     */
    void initFromNBT(NBTTagCompound aNBT, short aMTEID, short aMTERegistry);

    /** Writes Item Data to the NBT. */
    NBTTagCompound writeItemNBT(NBTTagCompound aNBT);

    /** Sets the Item Display Name. Use null to reset it. */
    void setCustomName(String aName);

    String getCustomName();

    /** return the internal Name of this TileEntity to be registered. */
    String getTileEntityName();

    /**
     * Called when a TileEntity of this particular Class is being registered first at any MultiTileEntity Registry. So
     * basically one call per Class.
     */
    void onRegistrationFirst(MultiTileEntityRegistry aRegistry, short aID);

    /** Called after the TileEntity has been placed and set up. */
    void onTileEntityPlaced();

    /** Checks if the TileEntity is Invalid or Unloaded, should bes required for every TileEntity. */
    @Override
    boolean isDead();

    void loadTextures(String folder);

    void copyTextures();

    void issueClientUpdate();

    void sendClientData(EntityPlayerMP aPlayer);

    boolean receiveClientEvent(int aEventID, int aValue);

    void setShouldRefresh(boolean aShouldRefresh);

    void addCollisionBoxesToList(AxisAlignedBB aAABB, List<AxisAlignedBB> aList, Entity aEntity);

    AxisAlignedBB getCollisionBoundingBoxFromPool();

    AxisAlignedBB getSelectedBoundingBoxFromPool();

    void setBlockBoundsBasedOnState(Block aBlock);

    void onBlockAdded();

    boolean playerOwnsThis(EntityPlayer aPlayer, boolean aCheckPrecicely);

    boolean privateAccess();

    /** @return the amount of Time this TileEntity has been loaded. */
    @Override
    long getTimer();

    /** Sets the Owner of the Machine. Returns the set Name. */
    String setOwnerName(String aName);

    /** gets the Name of the Machines Owner or "Player" if not set. */
    String getOwnerName();

    /** Gets the UniqueID of the Machines Owner. */
    UUID getOwnerUuid();

    /** Sets the UniqueID of the Machines Owner. */
    void setOwnerUuid(UUID uuid);

    /**
     * Causes a general Texture update. Only used Client Side to mark Blocks dirty.
     */
    void issueTextureUpdate();

    /**
     * Paintable Support
     */
    boolean unpaint();

    boolean isPainted();

    boolean paint(int aRGB);

    int getPaint();

    /**
     * Sets the main facing to {side} and update as appropriately
     *
     * @return Whether the facing was changed
     */
    boolean setMainFacing(ForgeDirection side);

    boolean isFacingValid(ForgeDirection facing);

    void onFacingChange();

    @Override
    default void setFrontFacing(ForgeDirection side) {
        setMainFacing(side);
    }

    boolean shouldTriggerBlockUpdate();

    void onMachineBlockUpdate();

    boolean allowInteraction(Entity aEntity);

    default void onLeftClick(EntityPlayer aPlayer) {
        /* do nothing */
    }

    boolean onBlockActivated(EntityPlayer aPlayer, ForgeDirection side, float aX, float aY, float aZ);

    boolean onRightClick(EntityPlayer aPlayer, ForgeDirection side, float aX, float aY, float aZ);

    ArrayList<ItemStack> getDrops(int aFortune, boolean aSilkTouch);

    boolean isSideSolid(ForgeDirection side);

    float getExplosionResistance(Entity aExploder, double aExplosionX, double aExplosionY, double aExplosionZ);

    float getExplosionResistance();

    void onExploded(Explosion aExplosion);

    boolean recolourBlock(ForgeDirection side, byte aColor);

    /** Adds to the Creative Tab. return false to prevent it from being added. */
    boolean getSubItems(MultiTileEntityBlockInternal aBlock, Item aItem, CreativeTabs aTab, List<ItemStack> aList,
        short aID);

    ItemStack getPickBlock(MovingObjectPosition aTarget);

    boolean shouldSideBeRendered(ForgeDirection side);

    boolean isSurfaceOpaque(ForgeDirection side);

    boolean onPlaced(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, ForgeDirection side,
        float aHitX, float aHitY, float aHitZ);

    // ItemStack getPickBlock(MovingObjectPosition aTarget);

    /*
     * Various Sub Interfaces from GT6
     */

    interface IMTE_OnNeighborBlockChange extends IMultiTileEntity {

        void onNeighborBlockChange(World aWorld, Block aBlock);
    }

    interface IMTE_IsProvidingWeakPower extends IMultiTileEntity {

        /** Remember that it passes the opposite Side due to the way vanilla works! */
        int isProvidingWeakPower(ForgeDirection oppositeSide);
    }

    interface IMTE_IsProvidingStrongPower extends IMultiTileEntity {

        /** Remember that it passes the opposite Side due to the way vanilla works! */
        int isProvidingStrongPower(ForgeDirection oppositeSide);
    }

    interface IMTE_ShouldCheckWeakPower extends IMultiTileEntity {

        boolean shouldCheckWeakPower(ForgeDirection side);
    }

    interface IMTE_GetWeakChanges extends IMultiTileEntity {

        boolean getWeakChanges();
    }

    interface IMTE_GetComparatorInputOverride extends IMultiTileEntity {

        int getComparatorInputOverride(ForgeDirection side);
    }

    interface IMTE_BreakBlock extends IMultiTileEntity {

        /** return true to prevent the TileEntity from being removed. */
        boolean breakBlock();
    }

    interface IMTE_HasMultiBlockMachineRelevantData extends IMultiTileEntity {

        /** Return true to mark this Block as a Machine Block for Multiblocks. (Triggers machine update thread) */
        boolean hasMultiBlockMachineRelevantData();
    }

    interface IMTE_GetBlockHardness extends IMultiTileEntity {

        float getBlockHardness();
    }

    interface IMTE_GetFoodValues extends IMultiTileEntity {

        @Optional.Method(modid = Mods.Names.APPLE_CORE)
        squeek.applecore.api.food.FoodValues getFoodValues(MultiTileEntityItemInternal aItem, ItemStack aStack);
    }

    interface IMTE_OnlyPlaceableWhenSneaking extends IMultiTileEntity {

        /** Return true to prevent placing this Block without Sneaking. */
        boolean onlyPlaceableWhenSneaking();
    }

    interface IMTE_IgnoreEntityCollisionWhenPlacing extends IMultiTileEntity {

        /**
         * Return true to ignore the Player standing in the way of placing this Block; useful for things like
         * pipes/wires.
         */
        boolean ignoreEntityCollisionWhenPlacing(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY,
            int aZ, ForgeDirection side, float aHitX, float aHitY, float aHitZ);
    }

    interface IMTE_CanPlace extends IMultiTileEntity {

        /** Return false if this TileEntity cannot be placed at that Location. */
        boolean canPlace(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ,
            ForgeDirection side, float aHitX, float aHitY, float aHitZ);
    }

    interface IMTE_GetMaxStackSize extends IMultiTileEntity {

        /** Gets the Max Stacksize of this Item. */
        byte getMaxStackSize(ItemStack aStack, byte aDefault);
    }

    interface IMTE_AddToolTips extends IMultiTileEntity {

        /** Adds ToolTips to the Item. */
        void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H);
    }

    interface IMTE_HasModes extends IMultiTileEntity {

        byte getMode();

        void setMode(byte aMode);

        int getAllowedModes();

        void setAllowedModes(int aAllowedModes);
    }
}
