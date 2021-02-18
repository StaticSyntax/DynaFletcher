package com.staticsyntax.dynafletcher.items;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public enum Items {
    KNIFE("Knife", Category.TOOL),
    CHISEL("Chisel", Category.TOOL),

    BOW_STRING("Bow string", Category.MATERIAL),
    FEATHER("Feather", Category.MATERIAL),

    REGULAR_LOGS("Logs", Category.MATERIAL),
    OAK_LOGS("Oak logs", Category.MATERIAL),
    WILLOW_LOGS("Willow logs", Category.MATERIAL),
    MAPLE_LOGS("Maple logs", Category.MATERIAL),
    YEW_LOGS("Yew logs", Category.MATERIAL),
    MAGIC_LOGS("Magic logs", Category.MATERIAL),
    REDWOOD_LOGS("Redwood logs", Category.MATERIAL),

    OPAL("Opal", Category.MATERIAL),
    JADE("Jade", Category.MATERIAL),
    OYSTER_PEARL("Oyster pearl", Category.MATERIAL),
    RED_TOPAZ("Red topaz", Category.MATERIAL),
    SAPPHIRE("Sapphire", Category.MATERIAL),
    EMERALD("Emerald", Category.MATERIAL),
    RUBY("Ruby", Category.MATERIAL),
    DIAMOND("Diamond", Category.MATERIAL),
    DRAGONSTONE("Dragonstone", Category.MATERIAL),
    ONYX("Onyx", Category.MATERIAL),
    AMETHYST("Amethyst", Category.MATERIAL),

    BRONZE_ARROW_TIPS("Bronze arrowtips", Category.MATERIAL),
    IRON_ARROW_TIPS("Iron arrowtips", Category.MATERIAL),
    STEEL_ARROW_TIPS("Steel arrowtips", Category.MATERIAL),
    MITHRIL_ARROW_TIPS("Mithril arrowtips", Category.MATERIAL),
    BROAD_ARROW_TIPS("Broad arrowtips", Category.MATERIAL),
    ADAMANT_ARROW_TIPS("Adamant arrowtips", Category.MATERIAL),
    RUNE_ARROW_TIPS("Rune arrowtips", Category.MATERIAL),
    AMETHYST_ARROW_TIPS("Amethyst arrowtips", Category.MATERIAL),
    DRAGON_ARROW_TIPS("Dragon arrowtips", Category.MATERIAL),

    BRONZE_BOLTS_UNF("Bronze bolts (unf)", Category.MATERIAL),
    IRON_BOLTS_UNF("Iron bolts (unf)", Category.MATERIAL),
    SILVER_BOLTS_UNF("Silver bolts (unf)", Category.MATERIAL),
    STEEL_BOLTS_UNF("Steel bolts (unf)", Category.MATERIAL),
    MITHRIL_BOLTS_UNF("Mithril bolts (unf)", Category.MATERIAL),
    BROAD_BOLTS_UNF("Unfinished broad bolts", Category.MATERIAL),
    ADAMANT_BOLTS_UNF("Adamant bolts(unf)", Category.MATERIAL),
    RUNITE_BOLTS_UNF("Runite bolts (unf)", Category.MATERIAL),
    DRAGON_BOLTS_UNF("Dragon bolts (unf)", Category.MATERIAL),

    BRONZE_DART_TIP("Bronze dart tip", Category.MATERIAL),
    IRON_DART_TIP("Iron dart tip", Category.MATERIAL),
    STEEL_DART_TIP("Steel dart tip", Category.MATERIAL),
    MITHRIL_DART_TIP("Mithril dart tip", Category.MATERIAL),
    ADAMANT_DART_TIP("Adamant dart tip", Category.MATERIAL),
    RUNE_DART_TIP("Rune dart tip", Category.MATERIAL),
    DRAGON_DART_TIP("Dragon dart tip", Category.MATERIAL),

    BRONZE_JAVELIN_HEADS("Bronze javelin heads", Category.MATERIAL),
    IRON_JAVELIN_HEADS("Iron javelin heads", Category.MATERIAL),
    STEEL_JAVELIN_HEADS("Steel javelin heads", Category.MATERIAL),
    MITHRIL_JAVELIN_HEADS("Mithril javelin heads", Category.MATERIAL),
    ADAMANT_JAVELIN_HEADS("Adamant javelin heads", Category.MATERIAL),
    RUNE_JAVELIN_HEADS("Rune javelin heads", Category.MATERIAL),
    AMETHYST_JAVELIN_HEADS("Amethyst javelin heads", Category.MATERIAL),
    DRAGON_JAVELIN_HEADS("Dragon javelin heads", Category.MATERIAL),

    REGULAR_SHORTBOW_U("Shortbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, REGULAR_LOGS),
    REGULAR_LONGBOW_U("Longbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, REGULAR_LOGS),
    OAK_SHORTBOW_U("Oak shortbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, OAK_LOGS),
    OAK_LONGBOW_U("Oak longbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, OAK_LOGS),
    WILLOW_SHORTBOW_U("Willow shortbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, WILLOW_LOGS),
    WILLOW_LONGBOW_U("Willow longbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, WILLOW_LOGS),
    MAPLE_SHORTBOW_U("Maple shortbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, MAPLE_LOGS),
    MAPLE_LONGBOW_U("Maple longbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, MAPLE_LOGS),
    YEW_SHORTBOW_U("Yew shortbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, YEW_LOGS),
    YEW_LONGBOW_U("Yew longbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, YEW_LOGS),
    MAGIC_SHORTBOW_U("Magic shortbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, MAGIC_LOGS),
    MAGIC_LONGBOW_U("Magic longbow (u)", Category.BOW, AcquisitionMethod.CUT, KNIFE, MAGIC_LOGS),

    REGULAR_SHORTBOW("Shortbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, REGULAR_SHORTBOW_U),
    REGULAR_LONGBOW("Longbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, REGULAR_LONGBOW_U),
    OAK_SHORTBOW("Oak shortbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, OAK_SHORTBOW_U),
    OAK_LONGBOW("Oak longbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, OAK_LONGBOW_U),
    WILLOW_SHORTBOW("Willow shortbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, WILLOW_SHORTBOW_U),
    WILLOW_LONGBOW("Willow longbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, WILLOW_LONGBOW_U),
    MAPLE_SHORTBOW("Maple shortbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, MAPLE_SHORTBOW_U),
    MAPLE_LONGBOW("Maple longbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, MAPLE_LONGBOW_U),
    YEW_SHORTBOW("Yew shortbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, YEW_SHORTBOW_U),
    YEW_LONGBOW("Yew longbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, YEW_LONGBOW_U),
    MAGIC_SHORTBOW("Magic shortbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, MAGIC_SHORTBOW_U),
    MAGIC_LONGBOW("Magic longbow", Category.BOW, AcquisitionMethod.STRING, BOW_STRING, MAGIC_LONGBOW_U),

    ARROW_SHAFT("Arrow shaft", Category.ARROW, AcquisitionMethod.CUT, KNIFE, REGULAR_LOGS),
    HEADLESS_ARROW("Headless arrow", Category.ARROW, AcquisitionMethod.FLIGHT, FEATHER, ARROW_SHAFT),
    BRONZE_ARROW("Bronze arrow", Category.ARROW, AcquisitionMethod.TIP, BRONZE_ARROW_TIPS, HEADLESS_ARROW),
    IRON_ARROW("Iron arrow", Category.ARROW, AcquisitionMethod.TIP, IRON_ARROW_TIPS, HEADLESS_ARROW),
    STEEL_ARROW("Steel arrow", Category.ARROW, AcquisitionMethod.TIP, STEEL_ARROW_TIPS, HEADLESS_ARROW),
    MITHRIL_ARROW("Mithril arrow", Category.ARROW, AcquisitionMethod.TIP, MITHRIL_ARROW_TIPS, HEADLESS_ARROW),
    BROAD_ARROW("Broad arrow", Category.ARROW, AcquisitionMethod.TIP, BROAD_ARROW_TIPS, HEADLESS_ARROW),
    ADAMANT_ARROW("Adamant arrow", Category.ARROW, AcquisitionMethod.TIP, ADAMANT_ARROW_TIPS, HEADLESS_ARROW),
    RUNE_ARROW("Rune arrow", Category.ARROW, AcquisitionMethod.TIP, RUNE_ARROW_TIPS, HEADLESS_ARROW),
    AMETHYST_ARROW("Amethyst arrow", Category.ARROW, AcquisitionMethod.TIP, AMETHYST_ARROW_TIPS, HEADLESS_ARROW),
    DRAGON_ARROW("Dragon arrow", Category.ARROW, AcquisitionMethod.TIP, DRAGON_ARROW_TIPS, HEADLESS_ARROW),

    OPAL_BOLT_TIPS("Opal bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, OPAL),
    JADE_BOLT_TIPS("Jade bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, JADE),
    PEARL_BOLT_TIPS("Jade bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, OYSTER_PEARL),
    TOPAZ_BOLT_TIPS("Topaz bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, RED_TOPAZ),
    SAPPHIRE_BOLT_TIPS("Sapphire bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, SAPPHIRE),
    EMERALD_BOLT_TIPS("Emerald bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, EMERALD),
    RUBY_BOLT_TIPS("Ruby bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, RUBY),
    DIAMOND_BOLT_TIPS("Diamond bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, DIAMOND),
    DRAGONSTONE_BOLT_TIPS("Dragonstone bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, DRAGONSTONE),
    ONYX_BOLT_TIPS("Onyx bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, ONYX),
    AMETHYST_BOLT_TIPS("Amethyst bolt tips", Category.BOLT, AcquisitionMethod.CUT, CHISEL, AMETHYST),

    BRONZE_BOLTS("Bronze bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, BRONZE_BOLTS_UNF),
    IRON_BOLTS("Iron bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, IRON_BOLTS_UNF),
    SILVER_BOLTS("Silver bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, SILVER_BOLTS_UNF),
    STEEL_BOLTS("Steel bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, STEEL_BOLTS_UNF),
    MITHRIL_BOLTS("Mithril bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, MITHRIL_BOLTS_UNF),
    BROAD_BOLTS("Broad bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, BROAD_BOLTS_UNF),
    ADAMANT_BOLTS("Adamant bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, ADAMANT_BOLTS_UNF),
    RUNITE_BOLTS("Runite bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, RUNITE_BOLTS_UNF),
    DRAGON_BOLTS("Dragon bolts", Category.BOLT, AcquisitionMethod.FLIGHT, FEATHER, DRAGON_BOLTS_UNF),

    OPAL_BOLTS("Opal bolts", Category.BOLT, AcquisitionMethod.TIP, OPAL_BOLT_TIPS, BRONZE_BOLTS),
    PEARL_BOLTS("Pearl bolts", Category.BOLT, AcquisitionMethod.TIP, PEARL_BOLT_TIPS, IRON_BOLTS),
    TOPAZ_BOLTS("Topaz bolts", Category.BOLT, AcquisitionMethod.TIP, TOPAZ_BOLT_TIPS, STEEL_BOLTS),
    SAPPHIRE_BOLTS("Sapphire bolts", Category.BOLT, AcquisitionMethod.TIP, SAPPHIRE_BOLT_TIPS, MITHRIL_BOLTS),
    EMERALD_BOLTS("Emerald bolts", Category.BOLT, AcquisitionMethod.TIP, EMERALD_BOLT_TIPS, MITHRIL_BOLTS),
    RUBY_BOLTS("Ruby bolts", Category.BOLT, AcquisitionMethod.TIP, RUBY_BOLT_TIPS, ADAMANT_BOLTS),
    DIAMOND_BOLTS("Diamond bolts", Category.BOLT, AcquisitionMethod.TIP, DIAMOND_BOLT_TIPS, ADAMANT_BOLTS),
    DRAGONSTONE_BOLTS("Dragonstone bolts", Category.BOLT, AcquisitionMethod.TIP, DRAGONSTONE_BOLT_TIPS, RUNITE_BOLTS),
    ONYX_BOLTS("Onyx bolts", Category.BOLT, AcquisitionMethod.TIP, ONYX_BOLT_TIPS, RUNITE_BOLTS),
    AMETHYST_BROAD_BOLTS("Amethyst broad bolts", Category.BOLT, AcquisitionMethod.TIP, AMETHYST_BOLT_TIPS, BROAD_BOLTS),

    OPAL_DRAGON_BOLTS("Opal dragon bolts", Category.BOLT, AcquisitionMethod.TIP, OPAL_BOLT_TIPS, DRAGON_BOLTS),
    JADE_DRAGON_BOLTS("Jade dragon bolts", Category.BOLT, AcquisitionMethod.TIP, JADE_BOLT_TIPS, DRAGON_BOLTS),
    PEARL_DRAGON_BOLTS("Pearl dragon bolts", Category.BOLT, AcquisitionMethod.TIP, PEARL_BOLT_TIPS, DRAGON_BOLTS),
    TOPAZ_DRAGON_BOLTS("Topaz dragon bolts", Category.BOLT, AcquisitionMethod.TIP, TOPAZ_BOLT_TIPS, DRAGON_BOLTS),
    SAPPHIRE_DRAGON_BOLTS("Sapphire dragon bolts", Category.BOLT, AcquisitionMethod.TIP, SAPPHIRE_BOLT_TIPS, DRAGON_BOLTS),
    EMERALD_DRAGON_BOLTS("Emerald dragon bolts", Category.BOLT, AcquisitionMethod.TIP, EMERALD_BOLT_TIPS, DRAGON_BOLTS),
    RUBY_DRAGON_BOLTS("Ruby dragon bolts", Category.BOLT, AcquisitionMethod.TIP, RUBY_BOLT_TIPS, DRAGON_BOLTS),
    DIAMOND_DRAGON_BOLTS("Diamond dragon bolts", Category.BOLT, AcquisitionMethod.TIP, DIAMOND_BOLT_TIPS, DRAGON_BOLTS),
    DRAGONSTONE_DRAGON_BOLTS("Diamond dragon bolts", Category.BOLT, AcquisitionMethod.TIP, DRAGONSTONE_BOLT_TIPS, DRAGON_BOLTS),
    ONYX_DRAGON_BOLTS("Onyx dragon bolts", Category.BOLT, AcquisitionMethod.TIP, ONYX_BOLT_TIPS, DRAGON_BOLTS),

    BRONZE_DART("Bronze dart", Category.DART, AcquisitionMethod.FLIGHT, FEATHER, BRONZE_DART_TIP),
    IRON_DART("Iron dart", Category.DART, AcquisitionMethod.FLIGHT, FEATHER, IRON_DART_TIP),
    STEEL_DART("Steel dart", Category.DART, AcquisitionMethod.FLIGHT, FEATHER, STEEL_DART_TIP),
    MITHRIL_DART("Mithril dart", Category.DART, AcquisitionMethod.FLIGHT, FEATHER, MITHRIL_DART_TIP),
    ADAMANT_DART("Adamant dart", Category.DART, AcquisitionMethod.FLIGHT, FEATHER, ADAMANT_DART_TIP),
    RUNE_DART("Rune dart", Category.DART, AcquisitionMethod.FLIGHT, FEATHER, RUNE_DART_TIP),
    DRAGON_DART("Dragon dart", Category.DART, AcquisitionMethod.FLIGHT, FEATHER, DRAGON_DART_TIP),

    JAVELIN_SHAFT("Javelin shaft", Category.JAVELIN, AcquisitionMethod.CUT, KNIFE, REGULAR_LOGS),
    BRONZE_JAVELIN("Bronze javelin", Category.JAVELIN, AcquisitionMethod.TIP, BRONZE_JAVELIN_HEADS, JAVELIN_SHAFT),
    IRON_JAVELIN("Iron javelin", Category.JAVELIN, AcquisitionMethod.TIP, IRON_JAVELIN_HEADS, JAVELIN_SHAFT),
    STEEL_JAVELIN("Steel javelin", Category.JAVELIN, AcquisitionMethod.TIP, STEEL_JAVELIN_HEADS, JAVELIN_SHAFT),
    MITHRIL_JAVELIN("Mithril javelin", Category.JAVELIN, AcquisitionMethod.TIP, MITHRIL_JAVELIN_HEADS, JAVELIN_SHAFT),
    ADAMANT_JAVELIN("Adamant javelin", Category.JAVELIN, AcquisitionMethod.TIP, ADAMANT_JAVELIN_HEADS, JAVELIN_SHAFT),
    RUNE_JAVELIN("Rune javelin", Category.JAVELIN, AcquisitionMethod.TIP, RUNE_JAVELIN_HEADS, JAVELIN_SHAFT),
    AMETHYST_JAVELIN("Amethyst javelin", Category.JAVELIN, AcquisitionMethod.TIP, AMETHYST_JAVELIN_HEADS, JAVELIN_SHAFT),
    DRAGON_JAVELIN("Dragon javelin", Category.JAVELIN, AcquisitionMethod.TIP, DRAGON_JAVELIN_HEADS, JAVELIN_SHAFT),

    OAK_SHIELD("Oak shield", Category.SHIELD, AcquisitionMethod.CUT, KNIFE, OAK_LOGS),
    WILLOW_SHIELD("Willow shield", Category.SHIELD, AcquisitionMethod.CUT, KNIFE, WILLOW_LOGS),
    MAPLE_SHIELD("Maple shield", Category.SHIELD, AcquisitionMethod.CUT, KNIFE, MAPLE_LOGS),
    YEW_SHIELD("Yew shield", Category.SHIELD, AcquisitionMethod.CUT, KNIFE, YEW_LOGS),
    MAGIC_SHIELD("Magic shield", Category.SHIELD, AcquisitionMethod.CUT, KNIFE, MAGIC_LOGS),
    REDWOOD_SHIELD("Redwood shield", Category.SHIELD, AcquisitionMethod.CUT, KNIFE, REDWOOD_LOGS);

    public enum Category {
        TOOL,
        MATERIAL,
        BOW,
        ARROW,
        BOLT,
        DART,
        JAVELIN,
        SHIELD;

        public static Category[] getAmmoCategories() {
            return new Category[] {ARROW, BOLT, DART, JAVELIN};
        }
    }

    public enum AcquisitionMethod {
        CUT,
        STRING,
        FLIGHT,
        TIP,
        OTHER;

        public static AcquisitionMethod[] getBowMethods() {
            return new AcquisitionMethod[] {CUT, STRING};
        }

        public static AcquisitionMethod[] getAmmoMethods() {
            return new AcquisitionMethod[] {CUT, FLIGHT, TIP};
        }

        public static AcquisitionMethod[] getMethodsFor(Category category) {
            LinkedHashSet<AcquisitionMethod> acquisitionMethods = new LinkedHashSet<>();
            for(Items item : Items.getAll(category)) {
                acquisitionMethods.add(item.getAcquisitionMethod());
            }
            return acquisitionMethods.toArray(new AcquisitionMethod[0]);
        }
    }

    private String name;
    private Category category;
    private AcquisitionMethod acquisitionMethod;
    private Items[] itemsRequired;

    Items(String name, Category category, AcquisitionMethod acquisitionMethod, Items...itemsRequired) {
        this.name = name;
        this.category = category;
        this.acquisitionMethod = acquisitionMethod;
        this.itemsRequired = itemsRequired;
    }

    Items(String name, Category category) {
        this(name, category, AcquisitionMethod.OTHER);
    }

    public static Items[] getAll(Category category) {
        ArrayList<Items> itemsArrayList = new ArrayList<>();
        for(Items item : Items.values()) {
            if(item.getCategory() == category) {
                itemsArrayList.add(item);
            }
        }
        return itemsArrayList.toArray(new Items[0]);
    }

    public static Items[] getAll(Category category, AcquisitionMethod acquisitionMethod) {
        ArrayList<Items> itemsArrayList = new ArrayList<>();
        for(Items item : getAll(category)) {
            if(item.getAcquisitionMethod() == acquisitionMethod) {
                itemsArrayList.add(item);
            }
        }
        return itemsArrayList.toArray(new Items[0]);
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public AcquisitionMethod getAcquisitionMethod() {
        return acquisitionMethod;
    }

    public Items[] getItemsRequired() {
        return itemsRequired;
    }

    public boolean requiresTool() {
        return getToolRequired() != null;
    }

    public Items getToolRequired() {
        for(Items item : itemsRequired) {
            if(item.category == Category.TOOL) return item;
        }
        return null;
    }

    public int getWidgetRootId() {
        return 270;
    }

    public int getWidgetChildId() {
        switch(category) {
            case BOW:
                if(acquisitionMethod == AcquisitionMethod.CUT) {
                    if(name.toLowerCase().contains("shortbow")) {
                        if(this == REGULAR_SHORTBOW_U) {
                            return 16;
                        } else {
                            return 15;
                        }
                    } else if(name.toLowerCase().contains("longbow")){
                        if(this == REGULAR_LONGBOW_U) {
                            return 17;
                        } else {
                            return 16;
                        }
                    }
                }
                break;
            case JAVELIN:
                if(acquisitionMethod == AcquisitionMethod.CUT) {
                    return 15;
                }
                break;
            case SHIELD:
                if(this != REDWOOD_SHIELD) {
                    return 18;
                } else {
                    return 15;
                }
        }
        return 14;
    }
}
