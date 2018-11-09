package me.fil.texpansion.block;

import java.util.ArrayList;

import me.fil.texpansion.TExpansion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RupifiedOre extends Block
{
	public RupifiedOre(Material mat)
	{
		super(mat);
	}
	
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		
		ret.add(new ItemStack(TExpansion.ingotRupified, 1));
		
		return ret;
    }
}
