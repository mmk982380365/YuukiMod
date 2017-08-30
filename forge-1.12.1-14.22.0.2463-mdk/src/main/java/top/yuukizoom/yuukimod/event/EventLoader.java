package top.yuukizoom.yuukimod.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.*;

import java.awt.event.ItemEvent;

/**
 * Created by realdata on 2017/8/30.
 */
public class EventLoader {

    public EventLoader ()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerItemPickup (PlayerEvent.ItemPickupEvent event)
    {
//        System.out.println(event);
    }

    @SubscribeEvent
    public void onPlayerItemCrafted (PlayerEvent.ItemCraftedEvent event)
    {
//        System.out.println(event.crafting.getItem());
    }

}
