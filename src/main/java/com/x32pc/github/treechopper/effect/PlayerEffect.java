package com.x32pc.github.treechopper.effect;

import com.x32pc.github.treechopper.TreeChopper;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerEffect {

    //FUNCTION TO GIVE EFFECTS
    public void giveEffect(Location l1, Player p) {
        if(l1.getBlock().getType() == Material.SPONGE) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 10));
            p.sendMessage(ChatColor.YELLOW + "You are given SLOW effect by machine.");
        }
        if(l1.getBlock().getType() == Material.ICE) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 10));
            p.sendMessage(ChatColor.YELLOW + "You are given SPEED effect by machine.");
        }
    }

    private TreeChopper treeChopper;
    public PlayerEffect(TreeChopper main) {
        this.treeChopper = main;
    }
}
