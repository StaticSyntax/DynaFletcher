package com.staticsyntax.dynafletcher.tasks;

import com.staticsyntax.dynafletcher.DynaFletcher;
import org.osbot.rs07.script.MethodProvider;

public abstract class Task {

    protected DynaFletcher script;
    protected MethodProvider api;
    protected String name;

    public Task(DynaFletcher script, String name) {
        this.script = script;
        api = script.getApi();
        this.name = name;
    }

    public Task(DynaFletcher script) {
        this(script, "Fletch");
    }

    public abstract boolean canProcess();

    public abstract void process();

    public boolean run() {
        if(canProcess()) {
            script.getPaint().setCurrentTask(name);
            process();
            return true;
        }
        return false;
    }
}
