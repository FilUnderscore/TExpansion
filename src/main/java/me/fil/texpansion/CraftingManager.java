package me.fil.texpansion;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.enchantment.Enchantment;

public class CraftingManager
{
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) 
	{
		if(event.crafting.getItem() == TExpansion.shickaxeRupified)
		{
			event.crafting.addEnchantment(Enchantment.fortune, 10);
		}
	}
}
