package me.fil.texpansion.item;

import java.util.List;

import me.fil.texpansion.TExpansion;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Paintbrush extends Item
{
	public static String[] unlocalized_names = {"brushRed", "brushLime", "brushBlue", "brushYellow"};
	public static String[] names = {"Red Paintbrush", "Lime Paintbrush", "Blue Paintbrush", "Yellow Paintbrush"};
	
	public static Icon[] icons;
	
	public static String[] ICON = {"brushRed", "brushLime", "brushBlue", "brushYellow"};
	
	public Paintbrush(int id)
	{
		super(id);
		setHasSubtypes(true);
		setCreativeTab(TExpansion.tab);
		maxStackSize = 1;
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		return names[stack.getItemDamage()];
	}
	
	public Icon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	
	public void registerIcons(IconRegister icon)
	{
		icons = new Icon[ICON.length];
	
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon("texpansion:" + ICON[i]);
		}
	}
	
	public void getSubItems(int id, CreativeTabs tab, List list)
	{
		for(int i = 0; i < icons.length; i++)
		{
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
}
