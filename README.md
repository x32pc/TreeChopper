# TreeChopper

TreeChopper is a Minecraft plugin developed for Minecraft version 1.20.2. It serves as a test of the developer's skills and knowledge in Minecraft Java plugin development.

The idea for this plugin was proposed by an Upwork client: "Develop an Auto Tree Chopper plugin for Spigot Minecraft servers." This plugin introduces a mechanized tree-chopping machine with unique behaviors and interactions.

## Functionality

- To activate the machine, place one of three 'Bit' blocks (DIAMOND_BLOCK, GOLD_BLOCK, or EMERALD_BLOCK) on the ground and on top of the machine's chest. If the player already has a running machine, the plugin will cancel the creation and return the chest to the player.

- Once the chest is placed, an armor_stand spawns holding a stone_axe and moves exclusively along the X-axis. It identifies OAK_LOG blocks, representing trees. The armor_stand is unaffected by gravity and passes through most blocks, with exceptions: Fern and Brown_mushroom.

- If the armor_stand collides with these exceptions, it disappears, the machine stops, and the player is notified in red bolded text in the chat.

- Water does not affect the armor_stand or its work.

- Specific effects occur if the armor_stand is standing on ICE (SPEED effect) or SPONGE (SLOW effect).

## Bit Blocks

- **DIAMOND_BLOCK**: Armor_stand moves until it collides with 2 of the selected plants (Fern and Brown_mushroom) or until the chest is full.

- **GOLD_BLOCK**: Armor_stand moves for 20 seconds or 20 blocks along the X-axis. After this time, the machine stops, and the armor_stand disappears.

- **EMERALD_BLOCK**: Similar to DIAMOND_BLOCK, but for every OAK_LOG broken, the output is doubled.

If the chest becomes full, the player receives a notification in the chat, and the machine stops working.

## Future Upgrades

In future iterations, the plugin can be upgraded and recoded by implementing an NPC that selects a radius zone and identifies all trees within that area. Subsequently, it could transport the obtained wood to a nearby chest.

## Time and Challenges

Time taken to complete the challenge: nearly 5 hours.

### Expectations and Challenges

- **Experience**: Inexperience with this type of plugin creation led to slower progress.

- **Design Decision**: Changing the machine variation significantly impacted development time. The initial concept involved the 'BIT' block with the chest traveling along the X-axis, which proved challenging to implement.

To simplify, only OAK_LOGS are registered as trees, and the armor_stand moves through blocks intentionally. Additional functionalities, such as registering other blocks as trees, can be added upon request but may take longer due to limited time (school break in 4 days).
