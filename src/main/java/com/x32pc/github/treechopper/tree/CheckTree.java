package com.x32pc.github.treechopper.tree;

import com.x32pc.github.treechopper.TreeChopper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class CheckTree {

    public void removeTreeStructure(Location logLocation) {
        World world = logLocation.getWorld();
        if (world == null) return;
        Block block = logLocation.getBlock(); //CHECKING AND LOOKING FOR BLOCK

        //CHECKING IF TREE IS TYPE: OAK. DECIDED TO GO WITH JUST ONE TYPE
        if (block.getType() == Material.OAK_LOG || block.getType() == Material.OAK_LEAVES) {
            if (block.getType() == Material.OAK_LOG) {
                treeChopper.constructionCheckEvent.addLogsCount(); //IF BLOCK IS OAK_LOG ADD TO CHEST
            }

            block.setType(Material.AIR); //REMOVING TREE - SETTING BLOCK TO AIR

            //LOOP FOR REMOVING BLOCKS
            Location[] adjacentBlocks = {
                    logLocation.clone().add(1, 0, 0),
                    logLocation.clone().subtract(1, 0, 0),
                    logLocation.clone().add(0, 1, 0),
                    logLocation.clone().subtract(0, 1, 0),
                    logLocation.clone().add(0, 0, 1),
                    logLocation.clone().subtract(0, 0, 1)
            };

            //LOOP FOR REMOVING BLOCKS
            for (Location adjacent : adjacentBlocks) {
                removeTreeStructure(adjacent);
            }
        }
    }

    private TreeChopper treeChopper;
    public CheckTree(TreeChopper main) {
        this.treeChopper = main;
    }
}
