package me.fil.texpansion;

import java.util.HashMap;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;

public final class EnumManager 
{
	public static final class Tools
	{
		private static HashMap<String, EnumToolMaterial> toolMaterials = new HashMap<String, EnumToolMaterial>();
		
		public static EnumToolMaterial addToolMaterial(String NAME, EnumToolMaterial MATERIAL)
		{
			return toolMaterials.put(NAME, MATERIAL);
		}
		
		public static EnumToolMaterial removeToolMaterial(String NAME)
		{
			return toolMaterials.remove(NAME);
		}
		
		public static EnumToolMaterial getMaterial(String NAME)
		{
			return toolMaterials.get(NAME);
		}
	}
	
	public static final class Armor
	{
		private static HashMap<String, EnumArmorMaterial> armorMaterials = new HashMap<String, EnumArmorMaterial>();
		
		public static EnumArmorMaterial addArmorMaterial(String NAME, EnumArmorMaterial MATERIAL)
		{
			return armorMaterials.put(NAME, MATERIAL);
		}
		
		public static EnumArmorMaterial removeArmorMaterial(String NAME)
		{
			return armorMaterials.remove(NAME);
		}
		
		public static EnumArmorMaterial getMaterial(String NAME)
		{
			return armorMaterials.get(NAME);
		}
	}
}
