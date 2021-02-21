package com.staticsyntax.dynafletcher.tasks.actions;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.ActionTask;
import com.staticsyntax.dynafletcher.tasks.managers.WidgetActionTaskManager;
import com.staticsyntax.dynafletcher.utils.Sleep;
import com.staticsyntax.dynafletcher.utils.Utils;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.MethodProvider;

public class WidgetAction extends ActionTask {

    private RS2Widget optionWidget;

    public WidgetAction(DynaFletcher script, WidgetActionTaskManager widgetActionTaskManager) {
        super(script, widgetActionTaskManager);
    }

    @Override
    public boolean canProcess() {
        optionWidget = Utils.getOptionWidget(script);
        if(optionWidget == null) {
            return false;
        } else {
            return optionWidget.isVisible();
        }
    }

    @Override
    public void process() {
        checkMakeAllAvailability();
        optionWidget.interact();
        Sleep.waitCondition(() -> Utils.getOptionWidget(script) == null, MethodProvider.random(1000, 2000));
        int lastExp = api.getExperienceTracker().getSkills().getExperience(Skill.FLETCHING);
        Sleep.waitCondition(() -> api.getExperienceTracker().getSkills().getExperience(Skill.FLETCHING) > lastExp, MethodProvider.random(2500, 3500));
    }

    private void checkMakeAllAvailability() {
        RS2Widget makeAllWidget = api.getWidgets().getWidgetContainingText("All");
        if(makeAllWidget != null) {
            ((WidgetActionTaskManager) actionTaskManager).setCanMakeAll(makeAllWidget.isVisible());
        }
    }
}
