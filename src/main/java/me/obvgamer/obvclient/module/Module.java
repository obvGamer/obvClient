package me.obvgamer.obvclient.module;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;

public class Module {

    protected static Minecraft mc = Minecraft.getMinecraft();

    private String name, description;
    private int key;
    private Category category;
    private boolean toggled;
    public boolean visible = true;


    public Module(String name, String description, Category category, int keyCode) {
        super();
        this.name = name;
        this.description = description;
        this.key = keyCode;
        this.category = category;
        this.toggled = false;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;

        if (this.toggled) this.onEnable();
        else this.onDisable();
    }

    public void toggle() {
        this.toggled = !this.toggled;

        if (this.toggled) this.onEnable();
        else this.onDisable();
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("[ObvClient] " + getName() + " has been enabled"));

    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("[ObvClient] " + getName() + " has been enabled"));

    }

    public String getName() {
        return this.name;
    }

    public Category getCategory() {
        return this.category;
    }

    public boolean nullCheck(){
        if (mc.thePlayer == null) return true;
        if (mc.theWorld == null) return  true;
        return false;
    }


}
