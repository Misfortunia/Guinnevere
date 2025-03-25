package guinnevere.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class nickyblock {
    //#INFINICKY
    //BLOCKS IS A DeferredRegister.Blocks

    //Creating DeferredRegister.Blocks
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("guinnevere");

    public static final DeferredBlock<Block> INFINICKY = BLOCKS.register("infinicky", //Registering the block "Infinicky"
    //FUNCTIONS OF INFINICKY- SIMPLE - MIGHT WANT TO CHANGE THIS
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName)) //Sets ID of the block
                    .destroyTime(5.0f) // Sets the destroy time
                    .explosionResistance(10.0f) // Sets the explosion resistance
                    .sound(SoundType.AMETHYST) // Sets the soundtype into [Amethyst]
                    .lightLevel(state -> 5) // Sets the lightlevel to 5
            )
    );

//    public static final DeferredBlock<Block> INFINICKY = BLOCKS.registerBlock("infinicky",
//            Block::new,
//            BlockBehaviour.Properties.of()
//    );
}
