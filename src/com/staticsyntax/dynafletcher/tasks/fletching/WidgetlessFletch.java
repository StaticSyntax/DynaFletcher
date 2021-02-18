package com.staticsyntax.dynafletcher.tasks.fletching;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.items.Items;
import com.staticsyntax.dynafletcher.tasks.Task;
import com.staticsyntax.dynafletcher.tasks.managers.WidgetlessActionTaskManager;

public class WidgetlessFletch extends Task {

    private WidgetlessActionTaskManager widgetlessActionTaskManager = new WidgetlessActionTaskManager(script);

    public WidgetlessFletch(DynaFletcher script) {
        super(script);
    }

    @Override
    public boolean canProcess() {
        return isWidgetlessFletching(script);
    }

    @Override
    public void process() {
        widgetlessActionTaskManager.runTasks();
    }

    public static boolean isWidgetlessFletching(DynaFletcher script) {
        Items.Category category = script.getTargetItem().getCategory();
        Items.AcquisitionMethod acquisitionMethod = script.getTargetItem().getAcquisitionMethod();

        return (category == Items.Category.BOLT && acquisitionMethod == Items.AcquisitionMethod.FLIGHT)
                || category == Items.Category.DART;
    }
}
