package com.x32pc.github.treechopper.chest;

import com.x32pc.github.treechopper.TreeChopper;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ChestFullCheck {

    //FUNCTION TO CHECK IF CHEST IS FULL
    public boolean isChestFull(Block block) {
        if (block.getState() instanceof Chest) {
            Chest chest = (Chest) block.getState();
            Inventory Inventory = chest.getInventory();
            for (ItemStack item : Inventory.getContents()) {
                if (item == null || item.getAmount() < item.getMaxStackSize()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private TreeChopper treeChopper;
    public ChestFullCheck(TreeChopper main) {
        this.treeChopper = main;
    }
}
