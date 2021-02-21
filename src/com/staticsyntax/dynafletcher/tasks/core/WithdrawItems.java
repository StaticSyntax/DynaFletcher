package com.staticsyntax.dynafletcher.tasks.core;

import com.staticsyntax.dynafletcher.DynaFletcher;
import com.staticsyntax.dynafletcher.items.Items;
import com.staticsyntax.dynafletcher.tasks.Task;
import com.staticsyntax.dynafletcher.utils.Sleep;
import com.staticsyntax.dynafletcher.utils.Utils;
import org.osbot.rs07.script.MethodProvider;

import java.util.stream.Stream;

public class WithdrawItems extends Task {

    public WithdrawItems(DynaFletcher script, String name) {
        super(script, name);
    }

    @Override
    public boolean canProcess() {
        return api.getBank().isOpen()
                && !Utils.inventoryContainsAll(api, script.getTargetItem().getItemsRequired())
                && !api.getInventory().contains(script.getTargetItem().getName())
                && !api.getInventory().isFull();
    }

    @Override
    public void process() {
        if(bankContainsMaterials()) {
            if(script.getTargetItem().requiresTool()) {
                withdrawTool();
            } else {
                withdrawMaterials();
            }
        } else {
            api.log("DynaFletcher was unable to find required materials - stopping script...");
            script.stop(true);
        }
    }

    private void withdrawTool() {
        if(!api.getInventory().contains(script.getTargetItem().getToolRequired().getName())) {
            api.getBank().withdraw(script.getTargetItem().getToolRequired().getName(), 1);
            Sleep.waitCondition(() -> api.getInventory().contains(script.getTargetItem().getToolRequired().getName()), MethodProvider.random(2500, 5000));
        } else {
            withdrawMaterials();
        }
    }

    private void withdrawMaterials() {
        if(script.getTargetItem().getAcquisitionMethod() != Items.AcquisitionMethod.STRING) {
            for(Items item : script.getTargetItem().getItemsRequired()) {
                if(!api.getInventory().contains(item.getName())) {
                    api.getBank().withdrawAll(item.getName());
                    Sleep.waitCondition(() -> api.getInventory().contains(item.getName()), MethodProvider.random(2500, 5000));
                }
            }
        } else {
            for(Items item : script.getTargetItem().getItemsRequired()) {
                if(!api.getInventory().contains(item.getName())) {
                    api.getBank().withdraw(item.getName(), 14);
                    Sleep.waitCondition(() -> api.getInventory().contains(item.getName()), MethodProvider.random(2500, 5000));
                }
            }
        }
    }

    private boolean bankContainsMaterials() {
        return Stream.of(script.getTargetItem().getItemsRequired()).filter(i -> i.getCategory() != Items.Category.TOOL).map(i -> i.getName()).allMatch(api.getBank()::contains);
    }
}
