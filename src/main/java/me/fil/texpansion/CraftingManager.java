package me.fil.texpansion;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingManager implements ICraftingHandler
{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		if(item.itemID == TExpansion.shickaxeRupified.itemID)
		{
			item.addEnchantment(Enchantment.fortune, 10);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
	}
	
}
