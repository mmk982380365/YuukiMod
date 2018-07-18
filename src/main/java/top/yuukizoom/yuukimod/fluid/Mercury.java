package top.yuukizoom.yuukimod.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import top.yuukizoom.yuukimod.YuukiMod;

/**
 * Created by realdata on 2017/8/30.
 */
public class Mercury extends Fluid implements YFluid{

    public static final ResourceLocation still = new ResourceLocation(YuukiMod.ModId+":"+"mercury_still");
    public static final ResourceLocation flowing = new ResourceLocation(YuukiMod.ModId+":"+"mercury_flow");

    public Mercury()
    {
        super("yuuki_mod.mercury",still,flowing);
        setDensity(13600);
        setViscosity(700);
        setLuminosity(0);
        setTemperature(300);
    }

    @Override
    public void registerFluid() {
        if (FluidRegistry.isFluidRegistered(this))
        {
            YuukiMod.mercury = (Mercury) FluidRegistry.getFluid(this.getName());
        } else {
            FluidRegistry.registerFluid(this);
        }
    }
}
