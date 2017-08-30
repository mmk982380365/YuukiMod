package top.yuukizoom.yuukimod.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.yuukizoom.yuukimod.YuukiMod;

import java.util.*;

/**
 * Created by realdata on 2017/8/29.
 */
public class MyItem extends Item implements YItem{

    @Override
    public void registerItem() {
        final String itemId = "myItem";
        setUnlocalizedName(YuukiMod.ModId+"."+itemId);
        setRegistryName(YuukiMod.ModId,itemId);
        setCreativeTab(YuukiMod.myTap);
        ForgeRegistries.ITEMS.register(this);
    }

    @Override
    public void loadModel() {
        final String mId = YuukiMod.ModId;
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(mId+":"+"myitem"));
    }

}
