package gregtech.api.enums;

public enum ConfigCategories {

    fuels("Fuels"),
    ids("Reserved IDs"),
    machineconfig("Machines Statistics Configuration"),
    main("Main GregTech Configuration"),
    materials("Materials"),
    news("GregTech News"),
    recipes("Recipes"),
    specialunificationtargets("Special Unification Targets"),
    tools("Tools");

    public enum Main {
        features("Specific stack sizes"),
        general("General Configuration"),
        machines("Machines behaviors");

        public String comment;

        Main (String aComment) {
            comment = aComment;
        }

        public String getComment() {
            return comment;
        }
    }

    public enum Client {
        colormodulation("Color Modulations tints");

        public enum ColorModulation {
            CABLE_INSULATION("Cable insulation RGB tint"),
            CONSTRUCTION_FOAM("Construction foam RGB tint"),
            MACHINE_METAL("Machine metal RGB tint");

            public String comment;

            ColorModulation (String aComment) {
                comment = aComment;
            }

            public String getComment() {
                return comment;
            }
        }

        public String comment;

        Client (String aComment) {
            comment = aComment;
        }

        public String getComment() {
            return comment;
        }
    }

    public enum IDs {
        crops("Crop IDs"),
        enchantments("Enchantments IDs");

        public String comment;

        IDs (String aComment) {
            comment = aComment;
        }

        public String getComment() {
            return comment;
        }
    }

    public enum Materials {
        heatdamage("Heat damage"),
        oreprocessingoutputmultiplier("Ore processing output multiplier"),
        blastfurnacerequirements("Blast Furnace requirements"),
        blastinductionsmelter("Blast Induction Smelter");

        public String comment;

        Materials (String aComment) {
            comment = aComment;
        }

        public String getComment() {
            return comment;
        }
    }

    public enum Recipes {
        alloysmelting("Alloy Smelter recipes ticks duration"),
        amplifier("UU Amplifier recipes ticks duration"),
        arcfurnace("Arc Furnace recipes ticks duration"),
        assembling("Assembler recipes ticks duration"),
        autoclave("Autoclave recipes ticks duration"),
        bender("Plate bender recipes ticks duration"),
        blastfurnace("Blast Furnace recipes ticks duration"),
        boxing("Boxinator recipes enable switches (true=enabled)"),
        brewing("Brewer recipes enable switches (true=enabled)"),
        canning("Solid Canner recipes ticks duration"),
        centrifuge("Centrifuge recipes ticks duration"),
        chemicalbath("Chemical Bath recipes ticks duration"),
        chemicalreactor("Chemical Reactor recipes ticks duration"),
        cnc("Extruder recipes ticks duration"),
        compression("Compressor recipes enable switches (true=enabled)"),
        cutting("Cutting Machine recipes ticks duration"),
        disabledrecipes("Disassembler recipes disable switches (true=disabled)"),
        distillation("Distillation Tower recipes ticks duration"),
        distillery("Distillery recipes ticks duration"),
        electrolyzer("Electrolyzer recipes ticks duration"),
        electromagneticseparator("Electromagnetic Separator recipes ticks duration"),
        extractor("Extractor recipes enable switches (true=enabled)"),
        extruder("Extruder recipes ticks duration"),
        fermenting("Fermenter recipes ticks duration"),
        fluidcanner("Fluid Canner recipes enable switches (true=enabled)"),
        fluidextractor("Fluid Extractor recipes ticks duration"),
        fluidheater("Fluid Heater recipes ticks duration"),
        fluidsmelter("Fluid Smelter recipes ticks duration"),
        fluidsolidifier("Fluid Solidifier recipes ticks duration"),
        forgehammer("Forge Hammer recipes enable switches (true=enabled)"),
        fuel_0("Light Fuels EU/L values"),
        fuel_1("Gaz Fuels EU/L values"),
        fuel_2("Special Solid Fuels Burn-values/Material Unit"),
        fuel_3("Heavy Fuels EU/L values"),
        fuel_4("Plasma Fuels EU/L values"),
        fuel_5("Magic Fuels EU/L values"),
        gregtechrecipes("GregTech integration recipes enable switches (true=enabled)"),
        hammerdoubleplate("Double-Plate Hammering recipes enable switches (true=enabled"),
        hammermultiingot("Multi-Ingots recipes enable switches (true=enabled)"),
        hammerplating("Plate Hammering recipes enable switches (true=enabled)"),
        hammerquadrupleplate("Quadruple-Plate Hammering recipes enable switches (true=enabled)"),
        hammerquintupleplate("Quintuple-Plate Hammering recipes enable switches (true=enabled)"),
        hammertripleplate("Triple-Plate Hammering recipes enable switches (true=enabled)"),
        harderrecipes("Harder recipes enable switches (true=use harder recipe)"),
        implosion("Implosion Compressor recipes ticks duration"),
        inductionsmelter("Induction Smelter recipes enable switches (true=enabled)"),
        laserengraving("LASER Engraver recipes ticks duration"),
        lathe("Lathe recipes ticks duration"),
        liquidtransposeremptying("Liquid Transposer emptying recipes enable switches (true=enabled)"),
        liquidtransposerfilling("Liquid Transposer filling recipes enable switches (true=enabled)"),
        maceration("Macerator recipes enable switches (true=enabled)"),
        mixer("Mixer recipes ticks duration"),
        mortar("Mortar recipes enable switches (true=enabled)"),
        orewashing("Ore Washing Plant recipes enable switches (true=enabled)"),
        polarizer("Polarizer recipes ticks duration"),
        press("Forming Press recipes ticks duration"),
        printer("Printer recipes ticks duration"),
        pulveriser("Pulveriser recipes ticks duration"),
        pulverization("Pulverisation recipes enable switches (true=enabled)"),
        pyrolyse("Pyrolyse Oven recipes ticks duration"),
        rcblastfurnace("RailCraft Blast Furnace recipes enable switches (true=enabled)"),
        recipereplacements("Replacement recipes for other mods enable switches (true=replace recipe)"),
        researches("Thaumcraft Researches recipes enable switche (true=enabled)"),
        roaster("Roaster recipes ticks duration"),
        rockcrushing("RailCraft Rock Crush recipes enable switches (true=enabled)"),
        sawmill("Sawmill recipes enable switches (true=enabled)"),
        scrapboxdrops("Unboxinator recipes output chance percent"),
        sifter("Sifter recipes ticks duration"),
        slicer("Food Slicer recipes ticks duration"),
        smelting("Furnace smelting recipes enable switches (true=enabled)"),
        storageblockcrafting("Crafting Storage Blocks recipes enable switches (true=enabled)"),
        storageblockdecrafting("Un-crafting Storage Blocks recipes enable switches (true=enabled)"),
        thermalcentrifuge("Thermal Centrifuge recipes enable switches (true=enabled)"),
        unboxing("Unboxing recipes enable switches (true=enabled)"),
        vacuumfreezer("Vacuum Freezer recipes ticks duration"),
        wiremill("Wiremill recipes ticks duration"),
        worldgeneration("Handles ores and stone generation in World");

        public String comment;

        Recipes (String aComment) {
            comment = aComment;
        }

        public String getComment() {
            return comment;
        }
    }

    public enum Machines {
        smelting("Smelter"),
        squeezer("Squeezer"),
        liquidtransposer("Liquid canner"),
        liquidtransposerfilling("Liquid canner fill"),
        liquidtransposeremptying("Liquid canner empty"),
        extractor("Extractor"),
        sawmill("Sawmill"),
        compression("Compressor"),
        thermalcentrifuge("Thermal Centrifuge"),
        orewashing("Ore Washing Plant"),
        inductionsmelter("Induction Smelter"),
        rcblastfurnace("RailCraft Blast Furnace"),
        scrapboxdrops("Unboxinator drops"),
        massfabamplifier("Mass Fabricator amplifier"),
        maceration("Macerator"),
        rockcrushing("Crusher"),
        pulverization("Pulverizer");

        public String comment;

        Machines(String aComment) {
            comment = aComment;
        }

        public String getComment() {
            return comment;
        }
    }

    public enum Fuels {
        boilerfuels("Boiler fuels (thick fluids)");

        public String comment;

        Fuels (String aComment) {
            comment = aComment;
        }

        public String getComment() {
            return comment;
        }
    }

    public enum Tools {
        mortar("Mortar"),
        hammerplating("Hammer plate"),
        hammermultiingot("Hammer triple ingot"),
        hammerdoubleplate("Hammer double plate"),
        hammertripleplate("Hammer triple plate"),
        hammerquadrupleplate("Hammer quadruple plate"),
        hammerquintupleplate("Hammer quintuple plate");

        public String comment;

        Tools (String aComment) {
            comment = aComment;
        }

        public String getComment() {
            return comment;
        }
    }

    public String comment;

    ConfigCategories (String aComment) {
        comment = aComment;
    }

    public String getComment() {
        return comment;
    }
}