package me.fil.texpansion;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

public class MultiItemTool extends ItemTool
{
	protected MultiItemTool(ToolMaterial p_i45333_2_, EnumToolType par3EnumToolType) 
	{
		super(2.0F, p_i45333_2_, Sets.newHashSet(blocksEffectiveAgainst));
		
		this.toolType = par3EnumToolType;
	}

	public static final Block[] blocksEffectiveAgainst = new Block[] {TExpansion.oreRupified, 
			Blocks.glass_pane, Blocks.glass, Blocks.cobblestone, Blocks.double_stone_slab, 
			Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, 
			Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, 
			Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice,
			Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, 
			Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, 
			Blocks.activator_rail, Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.chest, 
			Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, 
			Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium};

	protected EnumToolType toolType;
	
    
    
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    /*
	public boolean canHarvestBlock(Block par1Block)
    {
    	if(this.toolType == EnumToolType.SHICKAXE)
        	return par1Block == Blocks.glass_pane ? this.toolMaterial.getHarvestLevel() >= 1 : par1Block == Blocks.glass ? 
        			this.toolMaterial.getHarvestLevel() >= 1 : par1Block == TExpansion.oreRupified ? 
        					this.toolMaterial.getHarvestLevel() >= 10 : par1Block == Blocks.obsidian ? 
        							this.toolMaterial.getHarvestLevel() >= 3 : 
        								(par1Block != Blocks.diamond_block && par1Block != Blocks.diamond_ore ? 
        										(par1Block != Blocks.emerald_ore && par1Block != Blocks.emerald_block ? 
        												(par1Block != Blocks.gold_block && par1Block != Blocks.gold_ore ? 
        														(par1Block != Blocks.iron_block && par1Block != Blocks.iron_ore ? 
        																(par1Block != Blocks.lapis_block && par1Block != Blocks.lapis_ore ? 
        																		(par1Block != Blocks.redstone_ore && par1Block != Blocks.lit_redstone_ore ? 
        																				(par1Block.getMaterial() == Material.rock ? true : 
        																					(par1Block.getMaterial() == Material.iron ? true : par1Block.getMaterial() == Material.anvil)) : 
        																						this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : 
        																							this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : 
        																								this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    	if(this.toolType == EnumToolType.PICKAXE)
    		 return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.blockIron && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    	return false;
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    /*
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.blockMaterial == Material.iron || 
        		par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock || 
        		par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || 
        		par2Block.blockMaterial == Material.vine || par2Block == Block.snow ? true : par2Block == Block.blockSnow) ? 
        				this.efficiencyOnProperMaterial : super.get(par1ItemStack, par2Block);
    }
    */
}
