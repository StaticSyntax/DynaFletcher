package com.staticsyntax.dynafletcher.tasks.managers;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.fletching.WidgetFletch;
import com.staticsyntax.dynafletcher.tasks.fletching.WidgetlessFletch;

public class FletchingTaskManager extends TaskManager {

    public FletchingTaskManager(DynaFletcher script) {
        super(script);
    }

    @Override
    protected void initTasks() {
        tasks.add(new WidgetFletch(script));
        tasks.add(new WidgetlessFletch(script));
    }
}
