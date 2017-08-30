package top.yuukizoom.yuukimod.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.yuukizoom.yuukimod.YuukiMod;

/**
 * Created by realdata on 2017/8/30.
 */
public class ItemBucketMercury extends ItemBucket implements YItem {
    public ItemBucketMercury()
    {
        super(YuukiMod.blockFluidMercury);
        setContainerItem(Items.BUCKET);
    }

    @Override
    public void registerItem() {
        final String itemId = "bucketMercury";
        setUnlocalizedName(YuukiMod.ModId+"."+itemId);
        setRegistryName(YuukiMod.ModId,itemId);
        setCreativeTab(YuukiMod.myTap);
        ForgeRegistries.ITEMS.register(this);

    }

    @Override
    public void loadModel() {
        final String mId = YuukiMod.ModId;
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(mId+":"+"bucketmercury"));
    }
}
