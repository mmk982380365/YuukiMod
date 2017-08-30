package top.yuukizoom.yuukimod.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * Created by realdata on 2017/8/29.
 */
public class MyMaterial extends Material {
    public MyMaterial ()
    {
        super(MapColor.PURPLE);
        setRequiresTool();
    }
}
