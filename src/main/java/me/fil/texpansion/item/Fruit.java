package me.fil.texpansion.item;

import me.fil.texpansion.Manager;
import me.fil.texpansion.TExpansion;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Fruit extends ItemFood
{
	public Fruit()
	{
		super(4, 8, false);
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
}
