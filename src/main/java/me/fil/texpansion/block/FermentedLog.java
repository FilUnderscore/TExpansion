package me.fil.texpansion.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class FermentedLog extends Block
{
	Icon top;
	Icon side;
	
	public FermentedLog(int par1, Material par2Material) 
	{
		super(par1, par2Material);
	}
	
	public Icon getIcon(int par1, int par2)
	{
		if(par1 != 0 && par1 != 1)
		{
			return this.side;
		}
		else
		{
			return this.top;
		}
	}
	
	public void registerIcons(IconRegister par1IconRegister)
	{
		top = par1IconRegister.registerIcon("texpansion:log_fermented_top");
		side = par1IconRegister.registerIcon("texpansion:log_fermented");
	}
}
