package me.fil.texpansion;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Manager
{
	public static final class Names 
	{
		public static final HashMap<Block, String[]> block_unlocalized_names = new HashMap<Block, String[]>();
		public static final HashMap<Block, String[]> block_names = new HashMap<Block, String[]>();
		
		public static final HashMap<Item, String[]> item_unlocalized_names = new HashMap<Item, String[]>();
		public static final HashMap<Item, String[]> item_names = new HashMap<Item, String[]>();
		
		public static final HashMap<ItemStack, String[]> stack_unlocalized_names = new HashMap<ItemStack, String[]>();
		public static final HashMap<ItemStack, String[]> stack_names = new HashMap<ItemStack, String[]>();
	}
	
	public static final class Icons
	{
		public static final HashMap<Block, String[]> block_icons = new HashMap<Block, String[]>();
		
		public static final HashMap<Item, String[]> item_icons = new HashMap<Item, String[]>();
		
		public static final HashMap<ItemStack, String[]> stack_icons = new HashMap<ItemStack, String[]>();
	}
}