package top.yuukizoom.yuukimod;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import top.yuukizoom.yuukimod.blocks.BlockFluidMercury;
import top.yuukizoom.yuukimod.blocks.MyBlock;
import top.yuukizoom.yuukimod.command.MyCommand;
import top.yuukizoom.yuukimod.creativetap.MyTap;
import top.yuukizoom.yuukimod.event.EventLoader;
import top.yuukizoom.yuukimod.event.WorldGenerationLoader;
import top.yuukizoom.yuukimod.fluid.Mercury;
import top.yuukizoom.yuukimod.items.ItemBucketMercury;
import top.yuukizoom.yuukimod.items.MyFood;
import top.yuukizoom.yuukimod.items.MyItem;
import top.yuukizoom.yuukimod.items.MyTool;
import top.yuukizoom.yuukimod.proxy.ProxyCommon;



/**
 * Created by realdata on 2017/8/29.
 */

@Mod(modid = YuukiMod.ModId,version = YuukiMod.Version)
public class YuukiMod {

    public static final String ModId = "yuuki_mod";
    public static final String Version = "1.0";

    public static MyBlock myBlock;
    public static MyItem myItem;
    public static MyTap myTap;
    public static MyTool myTool;
    public static MyFood myFood;
    public static Mercury mercury;
    public static BlockFluidMercury blockFluidMercury;
    public static ItemBucketMercury itemBucketMercury;


    public static MyCommand myCommand;

    public static EventLoader eventLoader;
    public static WorldGenerationLoader worldGenerationLoader;

    @SidedProxy(clientSide = "top.yuukizoom.yuukimod.proxy.ProxyClient",serverSide = "top.yuukizoom.yuukimod.proxy.ProxyCommon")
    public static ProxyCommon proxy;

    @EventHandler
    public void init (FMLInitializationEvent e)
    {

    }

    @EventHandler
    public void serverStarting (FMLServerStartingEvent e)
    {
        myCommand = new MyCommand();
        e.registerServerCommand(myCommand);
    }

    @EventHandler
    public void preLoad (FMLPreInitializationEvent e)
    {




        myTap = new MyTap();


        myBlock = new MyBlock();
        myBlock.registerBlock();
        myBlock.registerItem();


        myItem = new MyItem();
        myItem.registerItem();

        myTool = new MyTool();
        myTool.registerItem();

        myFood = new MyFood();
        myFood.registerItem();

        mercury = new Mercury();
        mercury.registerFluid();

        blockFluidMercury = new BlockFluidMercury();
        blockFluidMercury.registerBlock();

        itemBucketMercury = new ItemBucketMercury();
        itemBucketMercury.registerItem();


        GameRegistry.addSmelting(myBlock,new ItemStack(myItem,1),100.0f);


        proxy.loadModel();

        eventLoader = new EventLoader();
        worldGenerationLoader = new WorldGenerationLoader();


//        LootTableList.register(new ResourceLocation(YuukiMod.ModId,"loot_table"));

    }

}
