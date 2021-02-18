package com.staticsyntax.dynafletcher.tasks.core;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.Task;
import com.staticsyntax.dynafletcher.tasks.managers.FletchingTaskManager;
import com.staticsyntax.dynafletcher.utils.Utils;

public class Fletch extends Task {

    private FletchingTaskManager fletchingTaskManager = new FletchingTaskManager(script);

    public Fletch(DynaFletcher script, String name) {
        super(script, name);
    }

    @Override
    public boolean canProcess() {
        return Utils.inventoryContainsAll(api, script.getTargetItem().getItemsRequired());
    }

    @Override
    public void process() {
        if(api.getBank().isOpen()) {
            api.getBank().close();
        } else {
            fletchingTaskManager.runTasks();
        }
    }
}
