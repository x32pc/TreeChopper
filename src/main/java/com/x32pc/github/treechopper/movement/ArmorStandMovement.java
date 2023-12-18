package com.x32pc.github.treechopper.movement;

import com.x32pc.github.treechopper.TreeChopper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class ArmorStandMovement {

    //CREATING ARMOR_STAND AND GIVING IT AXE
    public void setupArmorStand(ArmorStand armorStand) {
        ItemStack stoneAxe = new ItemStack(Material.STONE_AXE);
        armorStand.setGravity(false);
        armorStand.setSmall(false);
        armorStand.setVisible(true);
        armorStand.setCollidable(false);
        armorStand.setMarker(true);
        Objects.requireNonNull(armorStand.getEquipment()).setItemInMainHand(stoneAxe);
        armorStand.setArms(true);
    }

    //FUNCTION TO TELEPORT ARMOR_STAND TO NEW LOCATION
    public void moveArmorStand(ArmorStand armorStand, Location location) {
        location.setYaw(-90);
        armorStand.teleport(location.add(0.5, 0, 0.5));
    }

    private TreeChopper treeChopper;

    public ArmorStandMovement(TreeChopper main) {
        this.treeChopper = main;
    }
}
