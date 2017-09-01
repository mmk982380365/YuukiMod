package top.yuukizoom.yuukimod.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemTool;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.yuukizoom.yuukimod.YuukiMod;

import java.util.HashSet;

/**
 * Created by realdata on 2017/8/29.
 */
public class MyTool extends ItemTool implements YItem{


    public static final ToolMaterial MYMATERIAL = EnumHelper.addToolMaterial("MYMATERIAL",4,2333,16,20,22);

    public MyTool()
    {


        super(100.0f,10.0f, MYMATERIAL,new HashSet<Block>());
        setHarvestLevel("pickaxe",4);
        setHarvestLevel("axe",4);


        setMaxDamage(0);
    }

    @Override
    public void registerItem() {
        final String itemId = "myTool";
        setUnlocalizedName(YuukiMod.ModId+"."+itemId);
        setRegistryName(YuukiMod.ModId,itemId);
        setCreativeTab(YuukiMod.myTap);
        ForgeRegistries.ITEMS.register(this);
    }

    @Override
    public void loadModel() {
        final String mId = YuukiMod.ModId;
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(mId+":"+"mytool"));
    }
}
