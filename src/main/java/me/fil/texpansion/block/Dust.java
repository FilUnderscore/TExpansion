package me.fil.texpansion.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class Dust extends Block
{
	public Dust(Material mat)
	{
		super(mat);
	}
	
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		//return HardcoreExpansion.particleDust;
		//AKA Particle of Dust / Dust Particle
		return Items.diamond_sword;
	}
}
