package top.yuukizoom.yuukimod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.yuukizoom.yuukimod.YuukiMod;

/**
 * Created by realdata on 2017/8/30.
 */
public class BlockFluidMercury extends BlockFluidClassic implements YBlock{
    public BlockFluidMercury ()
    {
        super(YuukiMod.mercury, Material.CAKE);
    }

    @Override
    public void registerItem() {
        final String itemId = "mercury";
        setUnlocalizedName(YuukiMod.ModId+"."+itemId);
        setRegistryName(YuukiMod.ModId,itemId);
        setCreativeTab(YuukiMod.myTap);
        ItemBlock block = new ItemBlock(this);
        ForgeRegistries.ITEMS.register(block);
    }

    @Override
    public void loadModel() {
        final String location = YuukiMod.ModId + ":" + "mercury";
        final Item itemFluid = Item.getItemFromBlock(this);
        ModelLoader.setCustomMeshDefinition(itemFluid, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation(location,"fluid");
            }
        });
        ModelLoader.setCustomStateMapper(this, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation(location,"fluid");
            }
        });
    }

    @Override
    public void registerBlock() {
        final String mId = YuukiMod.ModId;
        final String bId = "mercury";
        setUnlocalizedName(mId+"."+bId);
        setRegistryName(mId,bId);
        setCreativeTab(YuukiMod.myTap);
        ForgeRegistries.BLOCKS.register(this);
    }

}
