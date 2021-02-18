package com.staticsyntax.dynafletcher.ui.paint;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.utils.Sleep;
import org.osbot.rs07.api.ui.Skill;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Paint {

    private DynaFletcher script;

    private long startTime;
    private String currentTask = "Initialising";

    private BufferedImage logo;
    private Font monospaced_16;

    public Paint(DynaFletcher script) {
        this.script = script;
        startTime = System.currentTimeMillis();
        script.getApi().getExperienceTracker().start(Skill.FLETCHING);
        loadResources();
    }

    private void loadResources() {
        try {
            logo = ImageIO.read(new URL("https://i.imgur.com/UW1c4lN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        monospaced_16 = new Font("Monospaced", Font.BOLD + Font.ITALIC, 16);
    }

    public void draw(Graphics2D g) {
        if(script.isRunning()) {
            drawInfo(g);
            drawCursor(g);
        }
    }

    private void drawInfo(Graphics2D g) {
        g.drawImage(logo, 0, 25, logo.getWidth() / 2, logo.getHeight() / 2, null);
        drawStrings(g);
    }

    private void drawStrings(Graphics2D g) {
        g.setFont(monospaced_16);
        g.setColor(Color.WHITE);
        g.drawString("Runtime: " + Sleep.msToString(System.currentTimeMillis() - startTime), 10, 90);
        g.drawString("Task: " + currentTask, 10, 110);
        g.drawString("Item: " + script.getSettingsDialog().getTargetItem().getName(), 10, 130);
        g.drawString("Level: " + script.getApi().getSkills().getVirtualLevel(Skill.FLETCHING) + " (+" + script.getApi().getExperienceTracker().getGainedLevels(Skill.FLETCHING) + ")", 10, 150);
        g.drawString("Exp Gained: " + script.getApi().getExperienceTracker().getGainedXP(Skill.FLETCHING) + " (" + script.getApi().getExperienceTracker().getGainedXPPerHour(Skill.FLETCHING) + "/hr)", 10, 170);
    }

    private void drawCursor(Graphics2D g) {
        Point mousePoint = script.getApi().getMouse().getPosition();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.PINK);
        g.drawLine(mousePoint.x - 5, mousePoint.y + 5, mousePoint.x + 5, mousePoint.y - 5);
        g.setColor(Color.CYAN);
        g.drawLine(mousePoint.x + 5, mousePoint.y + 5, mousePoint.x - 5, mousePoint.y - 5);
    }

    public void setCurrentTask(String taskName) {
        currentTask = taskName;
    }
}
