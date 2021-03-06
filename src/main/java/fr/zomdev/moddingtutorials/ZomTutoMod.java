/*
 * Copyright (c) 2017. ZomDev
 */

package fr.zomdev.moddingtutorials;

import fr.zomdev.moddingtutorials.ct.CreativeTabLFTTutoMod;
import fr.zomdev.moddingtutorials.events.EventOnSteelOreBreak;
import fr.zomdev.moddingtutorials.handlers.LFTTutoFuelHandler;
import fr.zomdev.moddingtutorials.proxy.CommonProxy;
import fr.zomdev.moddingtutorials.utils.LFTTutoModUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ZomTutoMod.MODID, name = ZomTutoMod.NAME, version = ZomTutoMod.VERSION, acceptedMinecraftVersions = "[1.11, 1.11.2]")
public class ZomTutoMod
{

	public static final String MODID = "zomtutomod";
	public static final String NAME = "Zom Tuto Mod";
	public static final String VERSION = "1.0";

	public static final String CLIENT_PROXY = "fr.zomdev.moddingtutorials.proxy.ClientProxy";
	public static final String SERVER_PROXY = "fr.zomdev.moddingtutorials.proxy.ServerProxy";

	public static final CreativeTabs modTab = new CreativeTabLFTTutoMod("zomtutomodTab");

	@Mod.Instance(MODID)
	public static ZomTutoMod instance;

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init();
		LFTTutoModUtils.GenUtils.registerWorldGenerations();
		MinecraftForge.EVENT_BUS.register(new EventOnSteelOreBreak());
		GameRegistry.registerFuelHandler(new LFTTutoFuelHandler());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit();
	}
}
