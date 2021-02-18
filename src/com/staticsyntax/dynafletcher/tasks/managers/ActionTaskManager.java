package com.staticsyntax.dynafletcher.tasks.managers;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.items.Items;
import org.osbot.rs07.api.ui.Skill;

public abstract class ActionTaskManager extends TaskManager {

    private static final int FLETCHING_TIMEOUT = 1500;
    private static final int ANIMATION_TIMEOUT = 2000;

    private long lastAnimTime = 0;
    private long lastTime = 0;
    private int lastExp = 0;
    protected String lastItemInteraction;

    public ActionTaskManager(DynaFletcher script) {
        super(script);
    }

    public String getLastItemInteraction() {
        return lastItemInteraction;
    }

    public void setLastItemInteraction(String lastItemInteraction) {
        this.lastItemInteraction = lastItemInteraction;
    }

    public boolean isFletching() {
        long currentTime = System.currentTimeMillis();
        int currentExp = api.getSkills().getExperience(Skill.FLETCHING);

        if(api.myPlayer().isAnimating() && !isTippingJavelins()) {
            lastAnimTime = System.currentTimeMillis();
            return true;
        }

        if(currentTime - lastAnimTime >= ANIMATION_TIMEOUT && !isTippingJavelins()) {
            return false;
        }

        if(currentTime - lastTime >= FLETCHING_TIMEOUT) {
            lastTime = currentTime;
            if(currentExp > lastExp) {
                lastExp = currentExp;
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isTippingJavelins() {
        return script.getTargetItem().getCategory() == Items.Category.JAVELIN
                && script.getTargetItem().getAcquisitionMethod() == Items.AcquisitionMethod.TIP;
    }
}
