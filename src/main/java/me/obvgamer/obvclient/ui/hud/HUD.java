package me.obvgamer.obvclient.ui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUD {

    Minecraft mc = Minecraft.getMinecraft();

    FontRenderer fr = mc.fontRendererObj;

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent e){
        fr.drawString("obvClient", 4, 4, -1);
    }
}
