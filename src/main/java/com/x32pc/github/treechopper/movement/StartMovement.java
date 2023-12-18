package com.x32pc.github.treechopper.movement;

import com.x32pc.github.treechopper.TreeChopper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;


public class StartMovement {

    //NEEDED CHECKING
    boolean check = false;
    public boolean timer;
    int count = 20;
    public boolean timesTwo;
    Location blockLocation;
    public boolean setActive;

    //FUNCTION USED TO START MACHINE - ARMOR_STAND STARTING TO MOVE
    public void startMachine(Block placedBlock) {
        blockLocation = placedBlock.getLocation();
        Location blockBelow = blockLocation.clone().subtract(0, 1, 0); //GETTING BLOCK UNDER PLACED CHEST

        //IF ARGUMENT IS TRUE (BELOW PLACED CHEST IS DIAMOND_BLOCK, EMERALD_BLOCK or GOLD_BLOCK SPAWN ARMOR_STAND
        if (placedBlock.getType() == Material.CHEST) {
            if (blockBelow.getBlock().getType() == Material.EMERALD_BLOCK || blockBelow.getBlock().getType() == Material.DIAMOND_BLOCK || blockBelow.getBlock().getType() == Material.GOLD_BLOCK) {
                ArmorStand armorStand = blockLocation.getWorld().spawn(blockLocation.clone().add(0.5, 0, 0.5), ArmorStand.class);
                treeChopper.armorStandMovement.setupArmorStand(armorStand); //CREATING ARMOR_STAND
                new BukkitRunnable() {

                    int steps = 0; //COUNTING BLOCKS

                    //USED FOR MOVING ARMOR_STAND
                    @Override
                    public void run() {
                        if (check) {
                            cancel();
                            check = false;
                        }
                        if (timer) {
                            count--;
                            if (count == 0) {
                                armorStand.remove();
                                restartMachine();
                                cancel();
                            }
                        }

                        //GETTING NEW LOCATION EACH TIME
                        Location newBlockLocation = blockLocation.clone().add(1 + steps, 0, 0);
                        Location newChestLocation = blockBelow.clone().add(1 + steps, 0, 0);

                        treeChopper.armorStandMovement.moveArmorStand(armorStand, newChestLocation); //TELEPORT ARMOR_STAND TO NEW LOCATION
                        treeChopper.checkCollision.checkCollision(armorStand, newBlockLocation, newChestLocation); //CHECK FOR COLLISION
                        Location under = newChestLocation.clone().subtract(0, 1, 0); //LOCATION UNDER BIT BLOCK
                        treeChopper.playerEffect.giveEffect(under, Bukkit.getPlayer(treeChopper.constructionCheckEvent.getWhoPlaced())); //FUNCTION TO GIVE EFFECT
                        steps++; //ADD +1 TO VARIABLE 'steps'

                        //CHECKING IF CHEST IS FULL
                        if (treeChopper.chestFullCheck.isChestFull(placedBlock)) {
                            Bukkit.getPlayer(treeChopper.constructionCheckEvent.getWhoPlaced()).sendMessage("" + ChatColor.RED + ChatColor.BOLD + "Chest is full, machine stopped.");
                            cancel();
                            armorStand.remove();
                            restartMachine();
                        }
                    }
                }.runTaskTimer(TreeChopper.getInstance(), 0L, 20L);
                resetCount();
            }
        }
    }

    public void restartMachine() {
        resetTimesTwo();
        resetCount();
        timer = false;
        resetActive();
    }

    public void setType(Material material) {
        if(material.equals(Material.GOLD_BLOCK)) {
            timer = true;
        }
        if(material.equals(Material.EMERALD_BLOCK)) {
            timesTwo = true;
        }
    }

    public void setActive() {
        setActive = true;
    }

    public void resetActive() {
        setActive = false;
    }

    public boolean getActive() {
        return setActive;
    }

    public void resetCount() {
        count = 20;
    }

    public void resetTimesTwo() {
        timesTwo = false;
    }

    public boolean getTimesTwo() {
        return timesTwo;
    }

    public Location getChestLocation() {
        return blockLocation;
    }

    public void setCancelled(boolean bol){
        if(bol) {
            check = true;
        }
    }

    private TreeChopper treeChopper;
    public StartMovement(TreeChopper main) {
        this.treeChopper = main;
    }
}
