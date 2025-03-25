package com.example.examplemod.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class guiblock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("examplemod");

    public static final DeferredBlock<Block> guih_block = BLOCKS.register(
            "guih_block",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(1.5f)
                    .explosionResistance(6.0f)
                    .sound(SoundType.AMETHYST)
        )
    );
}
