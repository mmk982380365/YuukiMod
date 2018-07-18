package top.yuukizoom.yuukimod.creativetap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import top.yuukizoom.yuukimod.YuukiMod;

/**
 * Created by realdata on 2017/8/30.
 */
public class MyTap extends CreativeTabs {
    public MyTap () {
        super("tap");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(YuukiMod.myItem,1);
    }
}
