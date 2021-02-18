package com.staticsyntax.dynafletcher.tasks.managers;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.Task;
import org.osbot.rs07.script.MethodProvider;

import java.util.ArrayList;

public abstract class TaskManager {

    protected DynaFletcher script;
    protected MethodProvider api;
    protected ArrayList<Task> tasks = new ArrayList<>();

    public TaskManager(DynaFletcher script) {
        this.script = script;
        api = script.getApi();
        initTasks();
    }

    protected abstract void initTasks();

    public void runTasks() {
        if(script.isRunning()) {
            tasks.forEach(Task::run);
        }
    }
}
