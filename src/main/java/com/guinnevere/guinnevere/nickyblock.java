package com.guinnevere.guinnevere;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredItem;


@Mod(nickyblock.MODID)
public class nickyblock {
    // #INFINICKY by NICKY #ORISARA CHAN

    public static final String MODID = "guinnevere"; // Define mod id in a common place for everything to reference
    private static final Logger LOGGER = LogUtils.getLogger(); // Directly reference a slf4j logger

    // BLOCKS IS A DeferredRegister.Blocks

    // Creating DeferredRegister.Blocks
//    public static final DeferredRegister.Blocks GUIBLOCKS = DeferredRegister.createBlocks(MODID); // I MOVE YOU HERE! IN THE MOST PRECIOUS PLACE
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID); // THIS IS ME NEXT TO YOU!
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID); // Create a Deferred register to hold Items which will all be registered under the "guinnevere" namespace

    // BTW I CHANGED SOME STUFFS AND LOCATION AND NAMES, PLEASE DON'T CHANGE THESE OR MOVE THESE IT'S VERY IMPORTANT~! 💖

    // Adds Infinicky Block
    public static final DeferredBlock<Block> INFINICKY_BLOCK = BLOCKS.register("infinicky", //Registering the block "Infinicky"
    // FUNCTIONS OF INFINICKY
            registryName -> new InfinickyBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName)) // Sets ID of the block
                    .destroyTime(5.0f) // Sets the destroy time
                    .explosionResistance(10.0f) // Sets the explosion resistance
                    .sound(SoundType.ANVIL) // Sets the sound type into [Anvil]
                    .lightLevel(state -> 5) // Sets the light level to 5
            )
    );

    //Adds Infinicky Block Item
    public static final DeferredItem<BlockItem> INFINICKY_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "infinicky",
            INFINICKY_BLOCK,
            new Item.Properties()
    );

    // HERE'S YOUR GUI_BLOCK (posm block now! ehhehe)
    // BTW I CHANGED SOME STUFFS AND LOCATION AND NAMES, PLEASE DON'T CHANGE THESE OR MOVE THESE IT'S VERY IMPORTANT~! 💖
    public static final DeferredBlock<Block> POSM_BLOCK = BLOCKS.register(
            "posm",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(1.5f)
                    .explosionResistance(6.0f)
                    .sound(SoundType.AMETHYST)
                    .mapColor(MapColor.QUARTZ) // TEMPORARY
            )
    );

    //Adds Posm Block Item
    public static final DeferredItem<BlockItem> POSM_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "posm",
            POSM_BLOCK,
            new Item.Properties()
    );

    public nickyblock(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup); // Register the commonSetup method for modloading

        BLOCKS.register(modEventBus); // Register the Deferred Register to the mod event bus so blocks get registered
        ITEMS.register(modEventBus); // Register the Deferred Register to the mod event bus so items get registered

        NeoForge.EVENT_BUS.register(this); //Register Neoforge [MIGHT BE NOT NEEDED READ EXAMPLEMOD.JAVA

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        //some common setup code
        LOGGER.info("COMMON SETUP INFINICKY");
    }

    // Add block items to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(INFINICKY_BLOCK_ITEM);
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(POSM_BLOCK_ITEM);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // Using EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
