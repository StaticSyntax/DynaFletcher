package com.staticsyntax.dynafletcher.tasks.actions;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.managers.WidgetActionTaskManager;
import org.osbot.rs07.script.MethodProvider;

import java.awt.*;

public class TwiddleMouse extends TwiddleAction {

    public TwiddleMouse(DynaFletcher script, WidgetActionTaskManager widgetActionTaskManager) {
        super(script, widgetActionTaskManager);
        initTwiddleTimeout();
    }

    @Override
    public boolean canProcess() {
        return ((WidgetActionTaskManager) actionTaskManager).canMakeAll()
                && !api.getInventory().isItemSelected()
                && api.getMouse().isOnScreen()
                && canTwiddle();
    }

    @Override
    public void process() {
        int rand = MethodProvider.random(100);

        if(rand >= MethodProvider.random(90, 95)) {
            mouseToRandInvSlot();
        } else if(rand >= MethodProvider.random(70, 85)){
            api.getMouse().move(MethodProvider.random(0, api.getDisplay().getScreenWidth()), MethodProvider.random(0, api.getDisplay().getScreenHeight()));
        } else {
            api.getMouse().moveOutsideScreen();
        }

        lastTwiddleTime = System.currentTimeMillis();
        initTwiddleTimeout();
    }

    private void mouseToRandInvSlot() {
        Rectangle invSlotRect = api.getInventory().getSlotBoundingBox(MethodProvider.random(0, 27));
        int invSlotX = invSlotRect.getLocation().x + MethodProvider.random(0, (int) invSlotRect.getWidth());
        int invSlotY = invSlotRect.getLocation().y + MethodProvider.random(0, (int) invSlotRect.getHeight());
        api.getMouse().move(invSlotX, invSlotY);
    }
}
