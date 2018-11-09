package me.fil.texpansion.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RupifiedIngot extends Item
{
	@Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
        par3List.add("\u00A74Warning: You can make really OP things");
        par3List.add("\u00A74with this stuff, Use it wisely.");
    }
}
