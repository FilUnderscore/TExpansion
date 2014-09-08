package me.fil.texpansion.item;

import java.util.List;

import me.fil.texpansion.Manager;
import me.fil.texpansion.TExpansion;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Fruit extends ItemFood
{
	public static Icon[] icons;
	
	public Fruit(int id)
	{
		super(id, 4, 8, false);
		setHasSubtypes(true);
		setCreativeTab(TExpansion.tab);
		Manager.Names.item_unlocalized_names.put(this, new String[]{"fruitApple", "fruitBanana", "fruitMango", "fruitBlackberry", "fruitStrawberry", "fruitBlueberry", "fruitGrape", "fruitLemon", "fruitOrange"});
		Manager.Names.item_names.put(this, new String[]{"Apple", "Banana", "Mango", "Blackberry", "Strawberry", "Blueberry", "Grape", "Lemon", "Orange"});
		Manager.Icons.item_icons.put(this, new String[]{"fruitApple", "fruitBanana", "fruitMango", "fruitBlackberry", "fruitStrawberry", "fruitBlueberry", "fruitGrape", "fruitLemon", "fruitOrange"});
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		return Manager.Names.item_unlocalized_names.get(this)[stack.getItemDamage()];
	}
	
	public Icon getIconFromDanage(int damage)
	{
		return icons[damage];
	}
	
	public void registerIcons(IconRegister icon)
	{
		icons = new Icon[Manager.Icons.item_icons.get(this).length];
		
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon("texpansion:" + Manager.Icons.item_icons.get(this)[i]);
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
