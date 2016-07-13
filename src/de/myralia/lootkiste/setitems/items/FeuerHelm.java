package de.myralia.lootkiste.setitems.items;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import de.myralia.lootkiste.setitems.SetItem;

public class FeuerHelm extends SetItem {

	public void BlutDuerster() {		
		this.bez="Feuer Helm ";
		this.id = 2;
	}
	
	@Override
	public ItemStack createInstance() {
		ItemStack i = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setColor(Color.RED);	
		i.setItemMeta(meta);
		this.createMeta(i);
		return i;
	}

}
