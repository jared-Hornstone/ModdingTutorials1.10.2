/*
 * Copyright (c) 2017. ZomDev
 */

package fr.zomdev.moddingtutorials.handlers;

import fr.zomdev.moddingtutorials.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class LFTTutoFuelHandler implements IFuelHandler
{

	private int itemsToBurn = 20;

	@Override
	public int getBurnTime(ItemStack fuel)
	{
		return fuel.getItem() == ModItems.bolts ? 200 * itemsToBurn : 0;
	}
}
