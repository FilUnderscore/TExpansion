package me.fil.texpansion.item;

import java.util.List;

import me.fil.texpansion.EnumToolType;
import me.fil.texpansion.MultiItemTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RupifiedItemShickaxe extends MultiItemTool
{

	public RupifiedItemShickaxe(ToolMaterial par2EnumToolMaterial, EnumToolType par3EnumToolType) 
	{
		super(par2EnumToolMaterial, par3EnumToolType);
	}
	
	@Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add("\u00A7cAll-in-one Axe/Pickaxe/Shovel");
        par3List.add("\u00A7aInfinite Uses");
    }
}
