package me.fil.texpansion.block;

import me.fil.texpansion.tileentity.TileEntityFermentator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Fermentator extends BlockContainer
{
	public Fermentator(Material mat)
	{
		super(mat);
	}
	
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityFermentator();
	}
}
