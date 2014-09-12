package me.fil.texpansion;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreManager implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(random, chunkX * 16, chunkZ * 16, world);
			break;
		case 0:
			generateSurface(random, chunkX * 16, chunkZ * 16, world);
			break;
		case 1:
			generateEnd(random, chunkX * 16, chunkZ * 16, world);
			break;
		case 12:
			generateFrosty(random, chunkX * 16, chunkZ * 16, world);
			break;
		default:
			break;
		}

	}
	
	private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int spawnChance) {
		for (int i = 0; i < spawnChance; i++) {
			int defaultChunkSize = 16;
			
			int xPos = posX + random.nextInt(defaultChunkSize);
			int yPos = minY + random.nextInt(maxY - minY);
			int zPos = posZ + random.nextInt(defaultChunkSize);
			
			new WorldGenMinable(block.blockID, maxVeinSize).generate(world, random, xPos, yPos, zPos);
		}
	}

	private void generateEnd(Random random, int chunkX, int chunkZ, World world) {
		// TODO Auto-generated method stub

	}

	private void generateSurface(Random rand, int chunkX, int chunkZ, World world) {
		//addOre(TExpansion.oreRupified, Block.stone, random, world, chunkX, chunkZ, 9, 18, 1, 3, 24);
		for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(64);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	(new WorldGenMinable(TExpansion.oreRupified.blockID, 13)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
	}
	
	private void generateFrosty(Random random, int chunkX, int chunkZ, World world)
	{
		
	}

	private void generateNether(Random random, int chunkX, int chunkZ, World world) {
		// TODO Auto-generated method stub

	}
}
