package com.staticsyntax.dynafletcher.tasks.managers;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.actions.*;

public class WidgetActionTaskManager extends ActionTaskManager {

    private boolean canMakeAll = false;

    public WidgetActionTaskManager(DynaFletcher script) {
        super(script);
    }

    @Override
    protected void initTasks() {
        tasks.add(new ItemAction(script, this));
        tasks.add(new WidgetAction(script, this));
        tasks.add(new TwiddleMouse(script, this));
        tasks.add(new TwiddleCamera(script, this));
    }

    public boolean canMakeAll() {
        return canMakeAll;
    }

    public void setCanMakeAll(boolean canMakeAll) {
        this.canMakeAll = canMakeAll;
    }
}
