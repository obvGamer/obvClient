package me.obvgamer.obvclient;

import me.obvgamer.obvclient.managers.ModuleManager;
import me.obvgamer.obvclient.module.Module;
import me.obvgamer.obvclient.ui.hud.HUD;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = "obvclient", version = "1.0")

public class Main{

    public ModuleManager moduleManager;

    @Mod.EventHandler
    public void startClient(FMLInitializationEvent e){
        MinecraftForge.EVENT_BUS.register(this);

        moduleManager = new ModuleManager();
        MinecraftForge.EVENT_BUS.register(new HUD());

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){}

    @SubscribeEvent
    public void keyPress(InputEvent.KeyInputEvent e) {
        if (Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().thePlayer == null)
            return;
        try {
            if (!(Keyboard.isCreated())) return;
            if (!Keyboard.getEventKeyState()) return;
            int keyCode = Keyboard.getEventKey();
            if (keyCode <= 0) return;
            for (Module m : moduleManager.modules) if (m.getKey() == keyCode) m.toggle();

        } catch (Exception q) {}
    }


}
