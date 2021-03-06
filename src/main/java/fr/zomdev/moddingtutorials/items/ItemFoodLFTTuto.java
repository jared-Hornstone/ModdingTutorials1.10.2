/*
 * Copyright (c) 2017. ZomDev
 */

package fr.zomdev.moddingtutorials.items;

import fr.zomdev.moddingtutorials.ZomTutoMod;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemFoodLFTTuto extends ItemFood
{
	private boolean isDrinkable;

	public ItemFoodLFTTuto(String name, int amount, float saturation, boolean isWolfFood, boolean isDrinkable)
	{
		super(amount, saturation, isWolfFood);

		this.setRegistryName(name);
		this.setUnlocalizedName(name);

		this.setCreativeTab(ZomTutoMod.modTab);

		this.isDrinkable = isDrinkable;
	}

	public ItemFoodLFTTuto(String name, int amount, boolean isWolfFood, boolean isDrinkable)
	{
		super(amount, isWolfFood);

		this.setRegistryName(name);
		this.setUnlocalizedName(name);

		this.setCreativeTab(ZomTutoMod.modTab);

		this.isDrinkable = isDrinkable;
	}

	// Fonction Optionnelle
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return this.isDrinkable ? EnumAction.DRINK : EnumAction.EAT;
	}

}
