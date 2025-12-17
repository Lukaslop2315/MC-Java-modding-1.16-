package com.mastery.masterymod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mastery.masterymod.masteryRegistration.BlockRegistration;
import com.mastery.masterymod.masteryRegistration.ItemRegistration;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("masterymod")  //match modId in mods.toml
public class Startup {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "masterymod";

    // Constructor - Forge calls this to initialize your mod
    public Startup() {
        BlockRegistration.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemRegistration.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    
    }

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        String playerName = player.getDisplayName().getString();
        // Fixed to include the player's name in the welcome message
        String welcomeMessage = "Welcome to MasteryMod, " + playerName + "! Made by Lukas";
        player.sendMessage(new StringTextComponent(welcomeMessage), player.getUUID());

        // Log to console/server - FIXED the formatting
        LOGGER.info("Player {} has logged in", playerName);
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (!event.isEndConquered()) {
            PlayerEntity player = event.getPlayer();
            player.sendMessage(new StringTextComponent("Welcome back to MasteryMod!"), player.getUUID());
        }
    }
}