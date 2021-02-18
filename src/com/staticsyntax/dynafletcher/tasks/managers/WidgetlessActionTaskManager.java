package com.staticsyntax.dynafletcher.tasks.managers;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.actions.ItemAction;

public class WidgetlessActionTaskManager extends ActionTaskManager {

    public WidgetlessActionTaskManager(DynaFletcher script) {
        super(script);
    }

    @Override
    protected void initTasks() {
        tasks.add(new ItemAction(script, this));
    }
}
