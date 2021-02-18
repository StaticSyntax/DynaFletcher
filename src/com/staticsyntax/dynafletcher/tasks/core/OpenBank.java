package com.staticsyntax.dynafletcher.tasks.core;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.Task;
import com.staticsyntax.dynafletcher.utils.Sleep;
import com.staticsyntax.dynafletcher.utils.Utils;
import org.osbot.rs07.script.MethodProvider;

public class OpenBank extends Task {

    public OpenBank(DynaFletcher script, String name) {
        super(script, name);
    }

    @Override
    public boolean canProcess() {
        return !api.getBank().isOpen() && !Utils.inventoryContainsAll(api, script.getTargetItem().getItemsRequired());
    }

    @Override
    public void process() {
        try {
            api.getBank().open();
            Sleep.waitCondition(() -> api.getBank().isOpen(), MethodProvider.random(2500, 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
