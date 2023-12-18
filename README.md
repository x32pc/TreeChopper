TreeChopper - minecraft plugin coded for Minecraft version 1.20.2 for the purpose of testing the developer's skill and knowledge in Minecraft Java plugin development

Upwork client created the plugin's idea, 'Develop an Auto Tree Chopper plugin for Spigot Minecraft servers. This plugin introduces a mechanized tree-chopping machine with unique behaviors and interactions

Plugin is designed, to start the machine by placing one of three bits blocks on the ground (DIAMOND_BLOCK, GOLD_BLOCK, and EMERALD_BLOCK) and on top of its chest. The only requirement is that the player has no machines already running, otherwise plugin will cancel machine creation and give chest back to player.

After placing chest, armor_stand spawns holding stone_axe and moves ONLY along X axe and recognizes if collides with OAK_LOG ---> represents a tree. Armor_stand isn't effected by gravity and it moves thru blocks with few exceptions:

- Fern
- Brown_mushroom

In case of colliding with these, armor_stand disappears, the machine is stopped and the player gets notified of this in chat in red bolded color.

Water doesn't affect armor_stand and it's work.

In case that armor_stand is standing on:

ICE - plugin gives player SPEED effect.
SPONGE - plugin gives player a SLOW effect.

There are 3 Bit's blocks. (DIAMOND_BLOCK, EMERALD_ORE, GOLD_ORE)
DIAMOND_BLOCK - Armor_stand will move infinitely until it collides with 2 of selected plants (Fern and Brown_mushroom) or chest gets full. 
GOLD_BLOCK - Armor_stand will move 20 seconds on X axe or rather 20 blocks, as all variants of machine travel 1 block per second. After 20 seconds machine will stop with armor_stand dispawning.
EMERALD_BLOCK - It is the same as DIAMOND_BLOCK with one huge tweak. For every OAK_LOG broken, it will multiply by 2. That means players will get x2 times the output with this variant.

In case that chest gets full, player will be notified in chat, and machine will stop working.

Time to complete the challenge: nearly 5 hours

Expectations and challenges:

- Honestly, I expected to create this much faster. One main thing that led to this was my inexperience. By this I mean I never created a plugin like this, so-called block-manipulation which I will explain in 'challenges' down here.
- One main thing that led to 5 hours of work was my decision to switch from a wanted variation of machine to another. I imagined creating machine in which after starting, 'BIT' block with chest will travel along the X axe, rather than armor_stand with the axe in hand. This proved to be crucial and this was where I spent the majority of my time, trying to make this function.

To simplify, only OAK_LOGS are registered as trees, and armor_stand goes thru blocks. This is intentional, but can be easily added with one !if function if client requests, as I don't have too much time <-- school break in 4 days.
