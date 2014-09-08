package me.fil.texpansion;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.LanguageRegistry;
import me.fil.texpansion.item.Paintbrush;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy 
{
	public void registerRenderers()
	{
		
	}
	
	public static void registerOreDictionary()
	{
		OreDictionary.registerOre("blockDust", TExpansion.blockDust);
		OreDictionary.registerOre("logWood", TExpansion.logFermented);
		OreDictionary.registerOre("plankWood", TExpansion.woodFermented);
		OreDictionary.registerOre("raddishHorse", TExpansion.raddishHorse);
    	//for(int i = 0; i < Paintbrush.unlocalized_names.length; i++)
    	for(int i = 0; i < Manager.Names.item_unlocalized_names.get(TExpansion.brush).length; i++)
    	{
    		ItemStack stack = new ItemStack(TExpansion.brush, 1, i);
    		OreDictionary.registerOre(Manager.Names.item_unlocalized_names.get(TExpansion.brush)[i], stack);
    	}
    	for(int i = 0; i < Manager.Names.item_unlocalized_names.get(TExpansion.fruit).length; i++)
    	{
    		ItemStack stack = new ItemStack(TExpansion.fruit, 1, i);
    		OreDictionary.registerOre(Manager.Names.item_unlocalized_names.get(TExpansion.fruit)[i], stack);
    	}
	}
	
	public void disableRecipes()
	{
		removeRecipe(new ItemStack(Block.torchWood, 0));
	}
	
	public void addCustomRecipes()
	{
		
	}
	
	public static void removeRecipe(ItemStack resultItem)
	{
		ItemStack recipeResult = null;
		ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
		for (int scan = 0; scan < recipes.size(); scan++)
		{
			 IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
			 if (tmpRecipe instanceof ShapedRecipes)
			 {
				 ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
				 recipeResult = recipe.getRecipeOutput();
			 }
			 if (tmpRecipe instanceof ShapelessRecipes)
			 {
				 ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
				 recipeResult = recipe.getRecipeOutput();
			 }
			 if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
			 {
				 System.out.println("[Hardcore Expansion] Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
				 recipes.remove(scan);
			 }
		}
	}
}
