package me.fil.texpansion.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RupifiedIngot extends Item
{
	public RupifiedIngot(int id)
	{
		super(id);
	}
	
	@Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
        par3List.add("§4Warning: You can make really OP things");
        par3List.add("§with this stuff, Use it wisely.");
    }
}
