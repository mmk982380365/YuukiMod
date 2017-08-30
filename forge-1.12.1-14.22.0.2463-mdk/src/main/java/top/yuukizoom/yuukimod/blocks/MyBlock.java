package top.yuukizoom.yuukimod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.yuukizoom.yuukimod.YuukiMod;

/**
 * Created by realdata on 2017/8/29.
 */
public class MyBlock extends Block implements YBlock {
    public MyBlock ()
    {
        super(Material.ROCK);

        setHardness(10.0f);
        setResistance(10.0f);
        setLightLevel(0.0f);
        setHarvestLevel("pickaxe",4);
        setSoundType(SoundType.SNOW);

    }

    @Override
    public void registerBlock() {
        final String mId = YuukiMod.ModId;
        final String bId = "myBlock";
        setUnlocalizedName(mId+"."+bId);
        setRegistryName(mId,bId);
        setCreativeTab(YuukiMod.myTap);
        ForgeRegistries.BLOCKS.register(this);
    }

    @Override
    public void registerItem() {
        final String mId = YuukiMod.ModId;
        final String bId = "myBlock";
        ItemBlock blockItem = new ItemBlock(this);
        blockItem.setRegistryName(mId,bId);
        ForgeRegistries.ITEMS.register(blockItem);
    }

    @Override
    public void loadModel() {
        final String mId = YuukiMod.ModId;
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),0, new ModelResourceLocation(mId +":"+"myblock"));
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockDestroyedByPlayer(worldIn, pos, state);

        System.out.println(pos);

    }
}
