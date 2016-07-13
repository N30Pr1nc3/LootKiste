package de.myralia.lootkiste.setitems.items;

import java.util.LinkedList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.myralia.lootkiste.setitems.SetItem;

public class BlutDuerster extends SetItem {	
	public BlutDuerster() {
		this.bez="Blut Duerster";
		this.id = 1;		
	}

	@Override
	public ItemStack createInstance() {
		ItemStack i;
		i = new ItemStack(Material.IRON_SWORD);	
		this.createMeta(i);
		return i;
	}


}
