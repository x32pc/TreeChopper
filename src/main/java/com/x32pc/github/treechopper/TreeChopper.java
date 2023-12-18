package com.x32pc.github.treechopper;

import com.x32pc.github.treechopper.chest.ChestFullCheck;
import com.x32pc.github.treechopper.collision.CheckCollision;
import com.x32pc.github.treechopper.effect.PlayerEffect;
import com.x32pc.github.treechopper.event.ConstructionCheckEvent;
import com.x32pc.github.treechopper.movement.ArmorStandMovement;
import com.x32pc.github.treechopper.movement.StartMovement;
import com.x32pc.github.treechopper.tree.CheckTree;
import org.bukkit.plugin.java.JavaPlugin;

public final class TreeChopper extends JavaPlugin {

    //registration for instances
    public ConstructionCheckEvent constructionCheckEvent;
    public CheckCollision checkCollision;
    public ArmorStandMovement armorStandMovement;
    public StartMovement startMovement;
    public CheckTree checkTree;
    public ChestFullCheck chestFullCheck;
    public PlayerEffect playerEffect;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ConstructionCheckEvent(this), this);
        constructionCheckEvent = new ConstructionCheckEvent(this); //part of registration
        checkCollision = new CheckCollision(this);
        armorStandMovement = new ArmorStandMovement(this);
        startMovement = new StartMovement(this);
        checkTree = new CheckTree(this);
        chestFullCheck = new ChestFullCheck(this);
        playerEffect = new PlayerEffect(this);
    }

    //registration
    public static TreeChopper getInstance() {
        return getPlugin(TreeChopper.class);
    }
}
