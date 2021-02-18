package com.staticsyntax.dynafletcher.tasks.managers;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.tasks.core.DepositItems;
import com.staticsyntax.dynafletcher.tasks.core.Fletch;
import com.staticsyntax.dynafletcher.tasks.core.OpenBank;
import com.staticsyntax.dynafletcher.tasks.core.WithdrawItems;

public class CoreTaskManager extends TaskManager {

    public CoreTaskManager(DynaFletcher script) {
        super(script);
    }

    @Override
    protected void initTasks() {
        tasks.add(new OpenBank(script, "Opening Bank"));
        tasks.add(new DepositItems(script, "Depositing Items"));
        tasks.add(new WithdrawItems(script, "Withdrawing Items"));
        tasks.add(new Fletch(script, "Fletching"));
    }
}
