package me.fil.texpansion;

import java.util.HashMap;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public final class EnumManager 
{
	public static final class Tools
	{
		private static HashMap<String, ToolMaterial> toolMaterials = new HashMap<String, ToolMaterial>();
		
		public static ToolMaterial addToolMaterial(String NAME, ToolMaterial MATERIAL)
		{
			return toolMaterials.put(NAME, MATERIAL);
		}
		
		public static ToolMaterial removeToolMaterial(String NAME)
		{
			return toolMaterials.remove(NAME);
		}
		
		public static ToolMaterial getMaterial(String NAME)
		{
			return toolMaterials.get(NAME);
		}
	}
	
	public static final class Armor
	{
		private static HashMap<String, ArmorMaterial> armorMaterials = new HashMap<String, ArmorMaterial>();
		
		public static ArmorMaterial addArmorMaterial(String NAME, ArmorMaterial MATERIAL)
		{
			return armorMaterials.put(NAME, MATERIAL);
		}
		
		public static ArmorMaterial removeArmorMaterial(String NAME)
		{
			return armorMaterials.remove(NAME);
		}
		
		public static ArmorMaterial getMaterial(String NAME)
		{
			return armorMaterials.get(NAME);
		}
	}
}
