package com.staticsyntax.dynafletcher.tasks.actions;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.ActionTask;
import com.staticsyntax.dynafletcher.tasks.managers.WidgetActionTaskManager;
import org.osbot.rs07.script.MethodProvider;

public abstract class TwiddleAction extends ActionTask {

    protected long lastTwiddleTime = 0;
    protected long twiddleTimeout;

    public TwiddleAction(DynaFletcher script, WidgetActionTaskManager widgetActionTaskManager) {
        super(script, widgetActionTaskManager);
        initTwiddleTimeout();
    }

    protected void initTwiddleTimeout() {
        twiddleTimeout = MethodProvider.random(1000, 30_000);
    }

    protected boolean canTwiddle() {
        return System.currentTimeMillis() - lastTwiddleTime >= twiddleTimeout;
    }
}
