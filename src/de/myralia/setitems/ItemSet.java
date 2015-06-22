package de.myralia.setitems;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemSet {
	public static Boolean isSetItem(ItemStack i){
		if(i==null){
			return false;
		}
		ItemMeta meta = i.getItemMeta();
		if(meta == null){
			return false; 
		}
		if(!meta.hasLore()){
			return false;
		}
		List<String> lore = meta.getLore();
		String myMeta = lore.get(lore.size());
		HiddenStr
		
		return true;
	}
	
	public static ItemStack createItem(int itemid){
		Material material = Material.IRON_SWORD;
		Color color = Color.BLUE;
		String name = "Tolles Set Item";
		
		
		ItemStack i;
		if( material == Material.LEATHER_BOOTS || material == Material.LEATHER_CHESTPLATE || material == Material.LEATHER_HELMET || material == Material.LEATHER_LEGGINGS){
			i = ItemSet.createAsLeatherArmor(material,color);
		}else{
			i = ItemSet.createAsDefault(material);
		}
		ItemMeta meta =i.getItemMeta(); 
		meta.setDisplayName(name);
		List<String> lore = meta.getLore();
		
		
		lore.add("Setitem");
		lore.add(HiddenStringUtils.encodeString("{\"itemid\": "+String.valueOf(itemid)+",\"rep\":0}"));
		
		
		meta.setLore(lore);
		i.setItemMeta(meta);
		
		return i;		
	}
	
	private static ItemStack createAsLeatherArmor(Material material ,Color color){
		ItemStack i = new ItemStack(material);
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setColor(color);	
		i.setItemMeta(meta);
		return i;
	}
	
	private static ItemStack createAsDefault(Material material){
		return new ItemStack(material);
		
	}	
}
