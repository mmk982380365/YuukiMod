package top.yuukizoom.yuukimod.entity;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import top.yuukizoom.yuukimod.YuukiMod;

/**
 * Created by realdata on 2017/8/31.
 */
public class EntityGoldenChicken extends EntityChicken {

    public EntityGoldenChicken (World worldIn)
    {
        super(worldIn);
        
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (this.rand.nextInt(10) == 0)
        {
            this.dropItem(YuukiMod.myItem,1);
        }
        super.dropFewItems(wasRecentlyHit, lootingModifier);
        System.out.println("kill a chicken");
    }

}
