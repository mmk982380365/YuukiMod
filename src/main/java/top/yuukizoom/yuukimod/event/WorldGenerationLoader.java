package top.yuukizoom.yuukimod.event;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import top.yuukizoom.yuukimod.gen.WorldGeneration;

/**
 * Created by realdata on 2017/8/30.
 */
public class WorldGenerationLoader {

    private static WorldGenerator worldGenerator;
    private BlockPos pos;

    public WorldGenerationLoader()
    {
        MinecraftForge.ORE_GEN_BUS.register(this);
        worldGenerator = new WorldGeneration();
    }

    @SubscribeEvent
    public void onOreGenGenerateMinable (OreGenEvent.GenerateMinable e)
    {
        if (e.getType() == OreGenEvent.GenerateMinable.EventType.ANDESITE)
        {
            e.setResult(Event.Result.DENY);
        }

    }

    @SubscribeEvent
    public void inOreGenPost(OreGenEvent.Post e)
    {
        if (!e.getPos().equals(this.pos))
        {
            this.pos = e.getPos();
            worldGenerator.generate(e.getWorld(),e.getRand(),e.getPos());
        }
    }

}
