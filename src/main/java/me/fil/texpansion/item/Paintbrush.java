package me.fil.texpansion.item;

import me.fil.texpansion.Manager;
import me.fil.texpansion.TExpansion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Paintbrush extends Item
{
	public Paintbrush()
	{
		setHasSubtypes(true);
		setCreativeTab(TExpansion.tab);
		maxStackSize = 1;
		Manager.Names.item_unlocalized_names.put(this, new String[]{"brushRed", "brushLime", "brushBlue", "brushYellow"});
		Manager.Names.item_names.put(this, new String[]{"Red Paintbrush", "Lime Paintbrush", "Blue Paintbrush", "Yellow Paintbrush"});
		Manager.Icons.item_icons.put(this, new String[]{"brushRed", "brushLime", "brushBlue", "brushYellow"});
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		//return names[stack.getItemDamage()];
		return Manager.Names.item_unlocalized_names.get(this)[stack.getItemDamage()];
	}
}
