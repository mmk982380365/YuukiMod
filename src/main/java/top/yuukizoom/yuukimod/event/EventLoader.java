package top.yuukizoom.yuukimod.event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.EntityHasProperty;
import net.minecraft.world.storage.loot.properties.EntityOnFire;
import net.minecraft.world.storage.loot.properties.EntityProperty;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.*;
import top.yuukizoom.yuukimod.YuukiMod;


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

    @SubscribeEvent
    public void onEntityInteract (PlayerInteractEvent.EntityInteract event)
    {
        EntityPlayer player = event.getEntityPlayer();
        if (player.isServerWorld() && event.getTarget() instanceof EntityPig)
        {

            EntityPig pig = (EntityPig)event.getTarget();
            ItemStack stack = player.getHeldItemMainhand();
            if (stack!=null && (stack.getItem() == YuukiMod.myFood))
            {
                player.attackEntityFrom(new DamageSource("byPig").setDifficultyScaled().setExplosion(),10.0f);
                player.world.createExplosion(pig,pig.posX,pig.posY,pig.posZ,0.0f,false);
                pig.setDead();
            }


        }
    }

    @SubscribeEvent
    public void onLootLoad (LootTableLoadEvent event)
    {
//        System.out.println(event.getName().toString());
        if (event.getName().toString().equals("minecraft:entities/pig"))
        {

            EntityHasProperty p[] = new EntityHasProperty[] {new EntityHasProperty(new EntityProperty[] {new EntityOnFire(false)},LootContext.EntityTarget.KILLER_PLAYER)};

            LootEntry ent = new LootEntryTable(
                    new ResourceLocation(YuukiMod.ModId,"pig_reject"),100,1,p,"pig_reject_entry");
            LootPool pool = new LootPool(new LootEntry[]{ent},p,new RandomValueRange(1,3),new RandomValueRange(1,3),"pig_reject_pool");
            event.getTable().addPool(pool);


        }
    }

    @SubscribeEvent
    public void onFillBucket(FillBucketEvent event)
    {
        BlockPos blockPos = event.getTarget().getBlockPos();
        IBlockState blockState = event.getWorld().getBlockState(blockPos);
        Fluid fluid = FluidRegistry.lookupFluidForBlock(blockState.getBlock());
        if (fluid!=null && new Integer(0).equals(blockState.getValue(BlockFluidBase.LEVEL)))
        {
//            FluidStack fluidStack = new FluidStack(fluid,1);
            event.getWorld().setBlockToAir(blockPos);
            
            event.setFilledBucket(new ItemStack(YuukiMod.itemBucketMercury));
            event.getEntityPlayer().setHeldItem(EnumHand.MAIN_HAND,event.getFilledBucket());

        }
    }

}
