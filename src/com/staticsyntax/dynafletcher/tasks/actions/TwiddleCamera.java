package com.staticsyntax.dynafletcher.tasks.actions;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.managers.WidgetActionTaskManager;
import org.osbot.rs07.api.Camera;
import org.osbot.rs07.script.MethodProvider;

public class TwiddleCamera extends TwiddleAction {

    public TwiddleCamera(DynaFletcher script, WidgetActionTaskManager widgetActionTaskManager) {
        super(script, widgetActionTaskManager);
    }

    @Override
    public boolean canProcess() {
        return actionTaskManager.isFletching()
                && api.getMouse().isOnScreen()
                && canTwiddle();
    }

    @Override
    public void process() {
        int rand = MethodProvider.random(100);
        Camera camera = api.getCamera();

        if(rand >= MethodProvider.random(86, 95)) {
            camera.movePitch(MethodProvider.random(camera.getLowestPitchAngle(), 67));
            camera.moveYaw(MethodProvider.random(0, 360));

        } else if(rand >= MethodProvider.random(76, 85)) {
            camera.moveYaw(MethodProvider.random(0, 360));

        } else if(rand >= MethodProvider.random(65, 75)) {
            camera.movePitch(MethodProvider.random(camera.getLowestPitchAngle(), 180));
        }

        lastTwiddleTime = System.currentTimeMillis();
        initTwiddleTimeout();
    }
}
