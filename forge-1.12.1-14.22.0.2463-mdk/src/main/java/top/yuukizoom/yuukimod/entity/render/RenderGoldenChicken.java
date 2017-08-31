package top.yuukizoom.yuukimod.entity.render;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import top.yuukizoom.yuukimod.YuukiMod;
import top.yuukizoom.yuukimod.entity.EntityGoldenChicken;

import javax.annotation.Nullable;

/**
 * Created by realdata on 2017/8/31.
 */
public class RenderGoldenChicken extends RenderLiving<EntityGoldenChicken> {


    private static final ResourceLocation GOLDEN_CHICKEN_TEXTURE = new ResourceLocation(YuukiMod.ModId+ ":" +"textures/entity/golden_chicken.png");

    public RenderGoldenChicken(RenderManager renderManager)
    {
        super(renderManager, new ModelChicken(),0.5f);
    }

    @Override
    protected void preRenderCallback(EntityGoldenChicken entitylivingbaseIn, float partialTickTime) {
//        super.preRenderCallback(entitylivingbaseIn, partialTickTime);

        GlStateManager.scale(2.5f,2.5f,2.5f);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGoldenChicken entity) {
        return RenderGoldenChicken.GOLDEN_CHICKEN_TEXTURE;
    }

    @Override
    public void doRender(EntityGoldenChicken entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
