package com.staticsyntax.dynafletcher.tasks;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.managers.ActionTaskManager;

public abstract class ActionTask extends Task {

    protected ActionTaskManager actionTaskManager;

    public ActionTask(DynaFletcher script, ActionTaskManager actionTaskManager) {
        super(script);
        this.actionTaskManager = actionTaskManager;
    }
}
