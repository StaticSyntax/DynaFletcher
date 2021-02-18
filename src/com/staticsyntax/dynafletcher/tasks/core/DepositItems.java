package com.staticsyntax.dynafletcher.tasks.core;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.Task;
import com.staticsyntax.dynafletcher.utils.Utils;

public class DepositItems extends Task {

    public DepositItems(DynaFletcher script, String name) {
        super(script, name);
    }

    @Override
    public boolean canProcess() {
        return api.getBank().isOpen()
                && !Utils.inventoryContainsAll(api, script.getTargetItem().getItemsRequired())
                && api.getInventory().contains(script.getTargetItem().getName());
    }

    @Override
    public void process() {
        api.getBank().depositAllExcept(script.getTargetItem().getItemsRequired()[0].getName(), script.getTargetItem().getItemsRequired()[1].getName());
    }
}
