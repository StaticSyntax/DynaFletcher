package com.staticsyntax.dynafletcher;

import com.staticsyntax.dynafletcher.items.Items;
import com.staticsyntax.dynafletcher.tasks.managers.CoreTaskManager;
import com.staticsyntax.dynafletcher.ui.paint.Paint;
import com.staticsyntax.dynafletcher.ui.settings.SettingsDialog;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.awt.*;

@ScriptManifest(logo = "https://i.imgur.com/8Vvtapg.png",
        name = "DynaFletcher",
        info = "Static Scripts",
        version = 1.01,
        author = "StaticSyntax")
public class DynaFletcher extends Script {

    private boolean running = false;
    private CoreTaskManager coreTaskManager;
    private SettingsDialog settingsDialog;
    private Paint paint;

    public void start() {
        running = true;
        coreTaskManager = new CoreTaskManager(this);
        paint = new Paint(this);
    }

    @Override
    public void onStart() {
        log(getName() + " " + getVersion());
        settingsDialog = new SettingsDialog(this);
        settingsDialog.invokeAndWait();
    }

    @Override
    public int onLoop() {
        coreTaskManager.runTasks();
        return MethodProvider.random(200, 600);
    }

    @Override
    public void onPaint(Graphics2D g) {
        paint.draw(g);
    }

    public boolean isRunning() {
        return running;
    }

    public SettingsDialog getSettingsDialog() {
        return settingsDialog;
    }

    public Items getTargetItem() {
        return settingsDialog.getTargetItem();
    }

    public Paint getPaint() {
        return paint;
    }

    public MethodProvider getApi() {
        return this;
    }
}
