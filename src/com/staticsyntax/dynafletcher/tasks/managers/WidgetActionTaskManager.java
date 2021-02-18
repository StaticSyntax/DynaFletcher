package com.staticsyntax.dynafletcher.tasks.managers;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.actions.*;

public class WidgetActionTaskManager extends ActionTaskManager {

    public WidgetActionTaskManager(DynaFletcher script) {
        super(script);
    }

    @Override
    protected void initTasks() {
        tasks.add(new ItemAction(script, this));
        tasks.add(new WidgetAction(script, this));
    }
}
