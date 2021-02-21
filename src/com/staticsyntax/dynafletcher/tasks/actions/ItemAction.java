package com.staticsyntax.dynafletcher.tasks.actions;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.items.Items;
import com.staticsyntax.dynafletcher.tasks.ActionTask;
import com.staticsyntax.dynafletcher.tasks.fletching.WidgetlessFletch;
import com.staticsyntax.dynafletcher.tasks.managers.ActionTaskManager;
import com.staticsyntax.dynafletcher.utils.Sleep;
import com.staticsyntax.dynafletcher.utils.Utils;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.script.MethodProvider;

public class ItemAction extends ActionTask {

    public ItemAction(DynaFletcher script, ActionTaskManager actionTaskManager) {
        super(script, actionTaskManager);
    }

    @Override
    public boolean canProcess() {
        RS2Widget optionWidget = Utils.getOptionWidget(script);
        if(optionWidget == null) {
            return WidgetlessFletch.isWidgetlessFletching(script)
                    || api.getInventory().isItemSelected()
                    || (!actionTaskManager.isFletching() || api.getDialogues().isPendingContinuation());
        } else {
            return WidgetlessFletch.isWidgetlessFletching(script)
                    || api.getInventory().isItemSelected()
                    || ((!actionTaskManager.isFletching() && !optionWidget.isVisible()) || api.getDialogues().isPendingContinuation());
        }
    }

    @Override
    public void process() {
        boolean wasItemSelected = api.getInventory().isItemSelected();

        Items[] requiredItems = script.getTargetItem().getItemsRequired();
        String itemName = !requiredItems[0].getName().equals(actionTaskManager.getLastItemInteraction()) ? requiredItems[0].getName() : requiredItems[1].getName();

        if(api.getInventory().getItem(itemName).interact()) {
            actionTaskManager.setLastItemInteraction(itemName);

            Sleep.waitCondition(() -> api.getInventory().isItemSelected() != wasItemSelected, MethodProvider.random(1000, 2000));

            if(!WidgetlessFletch.isWidgetlessFletching(script) && wasItemSelected) {
                Sleep.waitCondition(() -> Utils.getOptionWidget(script) != null, MethodProvider.random(750, 1500));
            }
        }
    }
}
