package com.x32pc.github.treechopper.event;

import com.x32pc.github.treechopper.TreeChopper;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import java.util.UUID;

public class ConstructionCheckEvent implements Listener {

    //VARIABLES
    private int logsBrokenCount = 0;
    static UUID placed;
    public Block placedBlock;

    //RUN FUNCTION ON 'BlockPlaceEvent'
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        placedBlock = event.getBlockPlaced();
        Block blockBelow = placedBlock.getLocation().subtract(0, 1, 0).getBlock();
        if (treeChopper.startMovement.getActive()) {
            if (placedBlock.getType() == Material.CHEST) {
                if (blockBelow.getType() == Material.DIAMOND_BLOCK || blockBelow.getType() == Material.GOLD_BLOCK || blockBelow.getType() == Material.EMERALD_BLOCK) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage("" + ChatColor.RED + ChatColor.BOLD + "One machine is already running.");
                }
            } //<------------ UP TO HERE - CHECKING IF THERE IS ALREADY ONE MACHINE RUNNING, IF NOT START ONE
        } else {
            if (placedBlock.getType() == Material.CHEST) {
                if (blockBelow.getType() == Material.DIAMOND_BLOCK) {
                    start(event);
                } else if (blockBelow.getType() == Material.GOLD_BLOCK) {
                    start(event);
                    treeChopper.startMovement.setType(Material.GOLD_BLOCK);

                } else if (blockBelow.getType() == Material.EMERALD_BLOCK) {
                    start(event);
                    treeChopper.startMovement.setType(Material.EMERALD_BLOCK);
                }
            }
        }
    }

    //FUNCTION 'start'
    public void start(BlockPlaceEvent event) {
        placed = event.getPlayer().getUniqueId();
        event.getPlayer().sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "Machine Activated");
        treeChopper.startMovement.startMachine(placedBlock);
        treeChopper.startMovement.setActive();
    }


    public int getLogsCount() {
        return logsBrokenCount;
    }

    public void setLogsCount(int amount) {
        logsBrokenCount = amount;
    }

    public void addLogsCount() {
        logsBrokenCount++;
    }

    public UUID getWhoPlaced() {
        return placed;
    }

    public Block getPlacedChest() {
        return placedBlock;
    }

    private TreeChopper treeChopper;
    public ConstructionCheckEvent(TreeChopper main) {
        this.treeChopper = main;
    }
}
