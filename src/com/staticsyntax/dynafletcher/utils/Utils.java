package com.staticsyntax.dynafletcher.utils;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.items.Items;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.script.MethodProvider;

import java.util.stream.Stream;

public class Utils {

    public static boolean inventoryContainsAll(MethodProvider api, Items[] items) {
        return Stream.of(items).map(i -> i.getName()).allMatch(api.getInventory()::contains);
    }

    public static RS2Widget getOptionWidget(DynaFletcher script) {
        return script.getApi().getWidgets().get(script.getTargetItem().getWidgetRootId(), script.getTargetItem().getWidgetChildId());
    }
}
