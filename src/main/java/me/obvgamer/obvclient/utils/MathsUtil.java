package me.obvgamer.obvclient.utils;

import net.minecraft.entity.Entity;

public class MathsUtil {


    //the client will only check the player's position at a specific frequency so this interpolates the entity's position to make it smoother instead of jagged
    public static double[] interpolateEntity(Entity entity, double partialTicks) {
        return new double[] { entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks,
                entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks,
                entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks };
    }
}
