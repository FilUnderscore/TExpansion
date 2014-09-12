package me.fil.texpansion;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import me.fil.texpansion.ApiManager.API;
import me.fil.texpansion.block.DeathlyTNT;
import me.fil.texpansion.block.Dust;
import me.fil.texpansion.block.Fermentator;
import me.fil.texpansion.block.FermentedLog;
import me.fil.texpansion.block.FermentedWood;
import me.fil.texpansion.block.InfectedQuartz;
import me.fil.texpansion.block.RupifiedOre;
import me.fil.texpansion.item.Fruit;
import me.fil.texpansion.item.Paintbrush;
import me.fil.texpansion.item.RupeeStick;
import me.fil.texpansion.item.RupifiedIngot;
import me.fil.texpansion.item.RupifiedItemShickaxe;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = TExpansion.MODID, name = TExpansion.MODID, version = TExpansion.VERSION /*dependencies = "required-after:TConstruct;required-after:IC2;"*/ /*dependencies = "required-after:Forge@[9.11.1.953,);"*/)
public class TExpansion
{
    public static final String MODID = "TExpansion";
    public static final String VERSION = "1.037";
    
    public static Logger logger = Logger.getLogger("TExpansion");
    
    @Instance(value = TExpansion.MODID)
    public static TExpansion instance;
    
    @SidedProxy(clientSide = "me.fil.texpansion.client.ClientProxy", serverSide = "me.fil.texpansion.CommonProxy")
    public static CommonProxy proxy;
    
    //Creative Tab
    public static final CreativeTabs tab = new CreativeTabs("tExpansionTab")
    {
    	public int getTabIconItemIndex()
        {
            return TExpansion.woodFermented.blockID;
        }
    	
    	public String getTranslatedTabLabel()
    	{
    		return "Thermomic Expansion";
    	}
    };
    
    //Tool Types
    //public static final EnumToolMaterial RUPIFIED = EnumHelper.addToolMaterial("RUPIFIED", 5, 0, 80F, 300F, 67);
    
    //Blocks
    public static Block fermentator;
    public static Block logFermented;
    public static Block woodFermented;
    public static Block quartzInfected;
    public static Block tntDeathly;
    public static Block blockDust;
    public static Block blender;
    public static Block oreRupified;
    public static Block oreRupee;
    
    //Items
    public static Item waterDirty;
    public static Item raddishHorse;
    public static Item brush;
    public static Item fruit;
    public static Item shickaxeRupified;
    public static Item ingotRupified;
    public static Item ingotRupee;
    public static Item stickRupee;
    
    //IDS (Block)
    public static int fermentatorId;
    public static int logFermentedId;
    public static int woodFermentedId;
    public static int quartzInfectedId;
    public static int tntDeathlyId;
    public static int blockDustId;
    public static int blenderId;
    public static int oreRupifiedId;
    public static int oreRupeeId;
    
    //IDS (Item)
    public static int ironRustedId;
    public static int waterDirtyId;
    public static int raddishHorseId;
    public static int brushId;
    public static int fruitId;
    public static int shickaxeRupifiedId;
    public static int ingotRupeeId;
    public static int ingotRupifiedId;
    public static int stickRupeeId;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	
    	config.load();
    	
    	fermentatorId = config.getBlock("Fermentator", 672).getInt();
    	logFermentedId = config.getBlock("FermentedLog", 800).getInt();
    	woodFermentedId = config.getBlock("FermentedWood", 801).getInt();
    	quartzInfectedId = config.getBlock("InfectedQuartz", 898).getInt();
    	tntDeathlyId = config.getBlock("DeathlyTNT", 972).getInt();
    	blockDustId = config.getBlock("DustBlock", 900).getInt();
    	blenderId = config.getBlock("Blender", 673).getInt();
    	oreRupeeId = config.getBlock("RupeeOre", 519).getInt();
    	oreRupifiedId = config.getBlock("RupifiedOre", 520).getInt();
    	
    	//ironRustedId = config.getItem("RustedIron", 31763).getInt();
    	waterDirtyId = config.getItem("DirtyWater", 31689).getInt();
    	raddishHorseId = config.getItem("HorseRaddish", 31688).getInt();
    	brushId = config.getItem("PaintBrush", 31689).getInt();
    	fruitId = config.getItem("Fruits", 31620).getInt();
    	shickaxeRupifiedId = config.getItem("RupifiedPickaxe", 31650).getInt();
    	ingotRupeeId = config.getItem("RupeeIngot", 31630).getInt();
    	ingotRupifiedId = config.getItem("RupfifiedIngot", 31631).getInt();
    	stickRupeeId = config.getItem("RupeeStick", 31629).getInt();
    	
    	config.save();
    	
    	ModMetadata meta = event.getModMetadata();
    	
    	meta.name = "Thermomic Expansion";
    	meta.autogenerated = false;
    	List<String> authorList = new ArrayList<String>();
    	authorList.add("Miner_Fil");
    	authorList.add("Miner_Marx");
    	meta.authorList = authorList;
    	meta.credits = "<3 to the mod creators.";
    	meta.url = "http://github.com/TheFil/TExpansion/";
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	if(Loader.isModLoaded("TConstruct"))
    	{
    		Logger l = Logger.getLogger("TConstruct");
    		logger.info("TConstruct, What shall we be doing tonight?");
    		l.info("TExpansion, We shall take over!");
    	}
    	else if(Loader.isModLoaded("TConstruct") && Loader.isModLoaded("Natura"))
    	{
    		Logger l = Logger.getLogger("TConstruct");
    		Logger n = Logger.getLogger("Natura");
    		logger.info("TConstruct and Natura, What shall we be doing tonight?");
    		l.info("TExpansion, We shall take over!");
    		n.info("^^^^ What that guy said.");
    	}
    	else
    	{
    		logger.info("I guess tonight I might aswell take over myself!");
    	}
    	proxy = new CommonProxy();
    	
    	proxy.removeRecipe(new ItemStack(Block.torchWood, 0));
    	
    	proxy.registerRenderers();
    	
    	EnumManager.Tools.addToolMaterial("RUPIFIED", EnumHelper.addToolMaterial("RUPIFIED", 99, 0, 125F, 11.7F, 67));
    	EnumManager.Tools.addToolMaterial("RUPEE", EnumHelper.addToolMaterial("RUPEE", 5, 9000, 19F, 4.9F, 34));
    	//proxy.registerOreDictionary();
    	
    	//OreDictionary.registerOre("blockDust", blockDust);
    	
    	logFermented = new FermentedLog(logFermentedId, Material.wood).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("logFermented").setTextureName("texpansion:log_fermented").setCreativeTab(tab);
    	woodFermented = new FermentedWood(woodFermentedId, Material.wood).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("woodFermented").setTextureName("texpansion:woodFermented").setCreativeTab(tab);
    	quartzInfected = new InfectedQuartz(quartzInfectedId, Material.iron).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("quartzInfected").setTextureName("texpansion:quartzInfected").setCreativeTab(tab).setBlockUnbreakable().setResistance(0.0F);
    	tntDeathly = new DeathlyTNT(tntDeathlyId).setUnlocalizedName("tntDeathly").setTextureName("texpansion:tntDeathly").setCreativeTab(tab);
    	blockDust = new Dust(blockDustId, Material.sand).setStepSound(Block.soundSandFootstep).setUnlocalizedName("blockDust").setTextureName("texpansion:dust").setCreativeTab(tab);
    	fermentator = new Fermentator(fermentatorId, Material.iron).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("fermentator").setTextureName("texpansion:fermentator").setCreativeTab(tab);
    	oreRupified = new RupifiedOre(oreRupifiedId, Material.rock).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreRupified").setTextureName("texpansion:oreRupified").setCreativeTab(tab);
    	
    	raddishHorse = (new ItemFood(raddishHorseId, 20, 1.5F, false)).setUnlocalizedName("raddishHorse").setTextureName("texpansion:raddishHorse").setCreativeTab(tab);
    	brush = new Paintbrush(brushId);
    	fruit = new Fruit(fruitId);
    	shickaxeRupified = new RupifiedItemShickaxe(shickaxeRupifiedId, EnumManager.Tools.getMaterial("RUPIFIED"), EnumToolType.SHICKAXE).setUnlocalizedName("shickaxeRupified").setTextureName("texpansion:shickaxeRupified").setCreativeTab(tab);
    	ingotRupified = new RupifiedIngot(ingotRupifiedId).setUnlocalizedName("ingotRupified").setTextureName("texpansion:ingotRupified").setCreativeTab(tab);
    	stickRupee = new RupeeStick(stickRupeeId).setUnlocalizedName("stickRupee").setTextureName("texpansion:stickRupee").setCreativeTab(tab);
    	
    	GameRegistry.registerBlock(logFermented, logFermented.getUnlocalizedName());
    	GameRegistry.registerBlock(woodFermented, woodFermented.getUnlocalizedName());
    	GameRegistry.registerBlock(quartzInfected, quartzInfected.getUnlocalizedName());
    	GameRegistry.registerBlock(tntDeathly, tntDeathly.getUnlocalizedName());
    	GameRegistry.registerBlock(blockDust, blockDust.getUnlocalizedName());
    	GameRegistry.registerBlock(fermentator, fermentator.getUnlocalizedName());
    	GameRegistry.registerBlock(oreRupified, oreRupified.getUnlocalizedName());
    	
    	GameRegistry.registerItem(raddishHorse, raddishHorse.getUnlocalizedName());
    	GameRegistry.registerItem(brush, "brush");
    	GameRegistry.registerItem(fruit, "fruit");
    	GameRegistry.registerItem(shickaxeRupified, shickaxeRupified.getUnlocalizedName());
    	GameRegistry.registerItem(ingotRupified, ingotRupified.getUnlocalizedName());
    	GameRegistry.registerItem(stickRupee, stickRupee.getUnlocalizedName());
    	
    	LanguageRegistry.addName(logFermented, "Fermented Log");
    	LanguageRegistry.addName(woodFermented, "Fermented Wood Planks");
    	LanguageRegistry.addName(quartzInfected, "Infected Quartz");
    	LanguageRegistry.addName(tntDeathly, "Deathly TNT");
    	LanguageRegistry.addName(blockDust, "Dust");
    	LanguageRegistry.addName(raddishHorse, "Horse Raddish");
    	LanguageRegistry.addName(fermentator, "Fermentator");
    	LanguageRegistry.addName(shickaxeRupified, "Rupified Shickaxe");
    	LanguageRegistry.addName(oreRupified, "Rupified Ore");
    	LanguageRegistry.addName(ingotRupified, "Rupified Ingot");
    	LanguageRegistry.addName(stickRupee, "Rupee Stick");
    	
    	//for(int i = 0; i < Paintbrush.names.length; i++)
    	for(int i = 0; i < Manager.Names.item_unlocalized_names.get(brush).length; i++)
    		LanguageRegistry.addName(new ItemStack(brush, 1, i), Manager.Names.item_names.get(brush)[i]);
    	for(int i = 0; i < Manager.Names.item_unlocalized_names.get(fruit).length; i++)
    		LanguageRegistry.addName(new ItemStack(fruit, 1, i), Manager.Names.item_names.get(fruit)[i]);
    	
    	MinecraftForge.setToolClass(shickaxeRupified, "pickaxe", 99);
    	MinecraftForge.setToolClass(shickaxeRupified, "shovel", 99);
    	MinecraftForge.setToolClass(shickaxeRupified, "axe", 99);
    	
    	MinecraftForge.setBlockHarvestLevel(oreRupified, "shickaxe", 99);
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(woodFermented, 3), new ItemStack(logFermented));
    	GameRegistry.addShapelessRecipe(new ItemStack(quartzInfected, 1), new ItemStack(Block.blockNetherQuartz), new ItemStack(Item.rottenFlesh), new ItemStack(Item.rottenFlesh));
    	GameRegistry.addShapelessRecipe(new ItemStack(raddishHorse, 1), new ItemStack(Item.beefRaw), new ItemStack(Item.porkRaw), new ItemStack(Item.leather));
    	GameRegistry.addShapelessRecipe(new ItemStack(raddishHorse, 1), new ItemStack(Item.beefCooked), new ItemStack(Item.porkCooked), new ItemStack(Item.leather));
    	GameRegistry.addShapelessRecipe(new ItemStack(raddishHorse, 1), new ItemStack(Item.beefRaw), new ItemStack(Item.porkCooked), new ItemStack(Item.leather));
    	GameRegistry.addShapelessRecipe(new ItemStack(raddishHorse, 1), new ItemStack(Item.beefCooked), new ItemStack(Item.porkRaw), new ItemStack(Item.leather));
    	GameRegistry.addShapelessRecipe(new ItemStack(stickRupee, 2), new ItemStack(ingotRupified), new ItemStack(ingotRupified));
    	
    	GameRegistry.addRecipe(new ItemStack(shickaxeRupified, 1), "xxx", "dyz", " ya", 'x', new ItemStack(ingotRupified), 'y', new ItemStack(stickRupee), 'd', new ItemStack(Item.pickaxeDiamond), 'z', new ItemStack(Item.axeDiamond), 'a', new ItemStack(Item.shovelDiamond));
    	
    	GameRegistry.addSmelting(oreRupified.blockID, new ItemStack(ingotRupified, 1), 4F);
    	
    	GameRegistry.registerWorldGenerator(new OreManager());
    	
    	GameRegistry.registerCraftingHandler(new CraftingManager());
    	
    	addCapes();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.registerOreDictionary();
    }
    
	  public static void addCapes() {
	    	String apiCapeURL = "http://fil.net63.net/CapesDir/index.php" + ApiManager.getEncryptedApi(API.CAPE);
	    	String ownerCapeURL = "http://fil.net63.net/CapesDir/hardcorerpgcape.png";
	    	//String helperCapeURL = "http://fil.net63.net/hardcorerpghelpcape.png";
	    	//String contribCapeURL = "http://fil.net63.net/hardcorerpgcontribcape.png";
	    	
	    	ThreadDownloadImageData ownerImage = new ThreadDownloadImageData(ownerCapeURL, null, null);
	    	
	    	Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/Miner_Fil"), (TextureObject)ownerImage);
	    	Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/Miner_Marx"), (TextureObject) ownerImage);
	    }
}
