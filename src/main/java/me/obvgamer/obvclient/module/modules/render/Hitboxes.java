package me.obvgamer.obvclient.module.modules.render;

import me.obvgamer.obvclient.module.Category;
import me.obvgamer.obvclient.module.Module;
import me.obvgamer.obvclient.utils.MathsUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glEnable;

public class Hitboxes extends Module {


    public Hitboxes() {
        super("Hitboxes", "Render's entity hitboxes", Category.RENDER, Keyboard.KEY_X);
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e){
        if (nullCheck()) return; //returns if the player or world don't exist

        //loops through the list of loaded entities and checks each of them
        for (Entity en : mc.theWorld.getLoadedEntityList()){
            if (!(en instanceof EntityLivingBase)) continue;
            if (en instanceof EntityAmbientCreature) continue;
            if (en instanceof EntityAnimal) continue;
            if (en.equals(mc.thePlayer)) continue;

            // if the entity doesnt get filtered out, it renders this hitbox
            entityHitbox(en, e.partialTicks);
        }
    }


    //renders a box around the entity using its hitbox
    public void entityHitbox(Entity entity, double partialTicks) {
        GL11.glBlendFunc(770, 771);
        glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(5.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);


        GL11.glColor4d(1, 0, 0, 0.5F);


        RenderGlobal.drawSelectionBoundingBox(getAxisAlignedBB(entity, partialTicks));

        glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);

    }


    //essentials gets the hitbox of the entity using the entity coordinates
    public AxisAlignedBB getAxisAlignedBB(Entity entity, double partialTicks){
        double[] entityPos = MathsUtil.interpolateEntity(entity, partialTicks);

        double x = entityPos[0];
        double y = entityPos[1];
        double z = entityPos[2];
        RenderManager rm = Minecraft.getMinecraft().getRenderManager();
        AxisAlignedBB bb = new AxisAlignedBB(x - entity.width/2, y, z - entity.width/2,
                x + entity.width/2, y + entity.height, z + entity.width/2)
                .offset(-rm.viewerPosX, -rm.viewerPosY, -rm.viewerPosZ);

        return bb;

    }
}
