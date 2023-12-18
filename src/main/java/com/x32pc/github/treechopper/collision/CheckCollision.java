package com.x32pc.github.treechopper.collision;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.ArmorStand;
import com.x32pc.github.treechopper.TreeChopper;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CheckCollision {

    //FUNCTION THAT CHECKS FOR COLLISION - CHECK IF ARMOR_STAND INTERACTS WITH BLOCKS ON X axe.
    public void checkCollision(ArmorStand chestArmorStand, Location newBlockLocation, Location newChestLocation) {

        Block blockAtArmorStand = newBlockLocation.getBlock();
        Block blockAtChestArmorStand = newChestLocation.getBlock();

        //IF IT COLLIDES WITH FERN OR BROWN_MUSHROOM, DEACTIVATE
        if (blockAtArmorStand.getType() == Material.FERN || blockAtChestArmorStand.getType() == Material.FERN || blockAtArmorStand.getType() == Material.BROWN_MUSHROOM || blockAtChestArmorStand.getType() == Material.BROWN_MUSHROOM) {
            chestArmorStand.remove();
            treeChopper.startMovement.setCancelled(true);
            treeChopper.startMovement.restartMachine();
            Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "MACHINE DEACTIVATED, COLLISION OCCURRED.");

            //IF NOT, IF IT COLLIDES WITH OAK_LOG CALL FOR 'removeTreeStructure'
        } else if (blockAtArmorStand.getType() == Material.OAK_LOG || blockAtChestArmorStand.getType() == Material.OAK_LOG) {
            treeChopper.checkTree.removeTreeStructure(blockAtArmorStand.getLocation());
            int times2 = treeChopper.constructionCheckEvent.getLogsCount();
            if(treeChopper.startMovement.getTimesTwo()) { //CHECKS IF EMERALD_BLOCK WAS USED AS BIT
                times2 = treeChopper.constructionCheckEvent.getLogsCount()*2; //ENABLING OAK_LOGS GAINS BY MULTIPLYING BY 2
            }

            Bukkit.broadcastMessage(ChatColor.GOLD + "Logs broken: " + treeChopper.constructionCheckEvent.getLogsCount());
            ItemStack logsToBeAdded = new ItemStack(Material.OAK_LOG, times2);
            Block chest = treeChopper.startMovement.getChestLocation().getBlock();
            Chest chest1 = (Chest) chest.getState();
            Inventory inv = chest1.getBlockInventory();
            inv.addItem(logsToBeAdded); //OAK_LOGS ADDED TO CHEST

            treeChopper.constructionCheckEvent.setLogsCount(0); //RESETTING OAK_LOG COUNTER

        }
    }

    private TreeChopper treeChopper;
    public CheckCollision(TreeChopper main) {
        this.treeChopper = main;
    }
}
