package com.staticsyntax.dynafletcher.tasks.fletching;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.Task;
import com.staticsyntax.dynafletcher.tasks.managers.WidgetActionTaskManager;

public class WidgetFletch extends Task {

    private WidgetActionTaskManager widgetActionTaskManager = new WidgetActionTaskManager(script);

    public WidgetFletch(DynaFletcher script) {
        super(script);
    }

    @Override
    public boolean canProcess() {
        return !WidgetlessFletch.isWidgetlessFletching(script);
    }

    @Override
    public void process() {
        widgetActionTaskManager.runTasks();
    }
}
