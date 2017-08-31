package top.yuukizoom.yuukimod.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by realdata on 2017/8/31.
 */
public class EntityRenderFactory<E extends Entity> implements IRenderFactory<E> {


    private final Class<? extends Render<E>> renderClass;

    public EntityRenderFactory(Class<? extends Render<E>> renderClass)
    {
        this.renderClass = renderClass;
    }

    @Override
    public Render<? super E> createRenderFor(RenderManager manager) {
        try {
            return renderClass.getConstructor(RenderManager.class).newInstance(manager);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
