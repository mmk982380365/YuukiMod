package top.yuukizoom.yuukimod.gen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import top.yuukizoom.yuukimod.YuukiMod;

import java.util.Random;

/**
 * Created by realdata on 2017/8/30.
 */
public class WorldGeneration extends WorldGenerator {

    private final WorldGenerator gen;


    public WorldGeneration()
    {
        gen = new WorldGenMinable(YuukiMod.myBlock.getDefaultState(),16);
    }
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {

        if (TerrainGen.generateOre(worldIn,rand,this,position, OreGenEvent.GenerateMinable.EventType.CUSTOM))
        {
            for (int i = 0; i < 4; i++)
            {
                int posX = position.getX() + rand.nextInt(16);
                int posY = 16 + rand.nextInt(16);
                int posZ = position.getZ() + rand.nextInt(16);
                BlockPos blockPos = new BlockPos(posX,posY,posZ);
                gen.generate(worldIn,rand,blockPos);

            }
        }

        return true;
    }
}
