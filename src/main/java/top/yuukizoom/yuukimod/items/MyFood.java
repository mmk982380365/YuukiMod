package top.yuukizoom.yuukimod.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.yuukizoom.yuukimod.YuukiMod;

/**
 * Created by realdata on 2017/8/30.
 */
public class MyFood extends ItemFood implements YItem {
    public MyFood()
    {
        super(8,0.7f,false);
        setAlwaysEdible();
//        PotionEffect effect = new PotionEffect(MobEffects.JUMP_BOOST,300,8);
//
//        setPotionEffect(effect,100.0f);
    }


    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote)
        {
            player.addExperience(100);
            player.addItemStackToInventory(new ItemStack(YuukiMod.myFood,1));

            PotionEffect effect = new PotionEffect(MobEffects.GLOWING,30000,12);

            player.addPotionEffect(effect);
        }
        super.onFoodEaten(stack, worldIn, player);
    }

    @Override
    public void registerItem() {
        final String itemId = "myFood";
        setUnlocalizedName(YuukiMod.ModId+"."+itemId);
        setRegistryName(YuukiMod.ModId,itemId);
        setCreativeTab(YuukiMod.myTap);
        ForgeRegistries.ITEMS.register(this);
    }

    @Override
    public void loadModel() {
        final String mId = YuukiMod.ModId;
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(mId+":"+"myfood"));
    }
}
