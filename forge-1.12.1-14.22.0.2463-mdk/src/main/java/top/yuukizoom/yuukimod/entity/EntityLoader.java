package top.yuukizoom.yuukimod.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.yuukizoom.yuukimod.YuukiMod;
import top.yuukizoom.yuukimod.entity.render.RenderGoldenChicken;

/**
 * Created by realdata on 2017/8/31.
 */
public class EntityLoader {

    private static int nextId = 0;

    public EntityLoader()
    {
        registerEntity(EntityGoldenChicken.class,"GoldenChicken",80,3,true);
        registerEgg("GoldenChicken", 0xffff66, 0x660000);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
                                       int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(YuukiMod.ModId,name),entityClass,name,nextId++,YuukiMod.instance,trackingRange,updateFrequency,sendsVelocityUpdates);
    }

    private static void registerEgg(String name, int eggPrimary, int eggSecondary)
    {
        EntityRegistry.registerEgg(new ResourceLocation(YuukiMod.ModId,name),eggPrimary,eggSecondary);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerEntityRender(EntityGoldenChicken.class, RenderGoldenChicken.class);
    }

    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render)
    {

        RenderingRegistry.registerEntityRenderingHandler(entityClass,new EntityRenderFactory<T>(render));
    }

}
