
package de.myralia.setitems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SetItem {
	public static HashMap<Integer, SetItem> items;
	
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
		
		return true;
	}
	
 	public static void initiate(){
		SetItem.items = new HashMap<Integer, SetItem>();
	}
	
	public static void deleteAll() {
		SetItem.items.clear();
	}	
	
	public static SetItem get(int itemid) {
		if(!SetItem.items.containsKey(itemid)){
			System.out.println("Ein Setitem mit der id "+itemid+" konnte nicht gefunden werden");
			return null;
		}
		return SetItem.items.get(itemid);
	}
	
	private int id;
	private String bez;
	private Material material;
	private Color color;
	private ItemSet set;
	
	public SetItem(int _id, ItemSet _set, String _bez, Material _material){
		this.id = _id;
		this.bez= _bez;
		this.color = Color.BLACK;
		this.set = _set;
		this.material = _material;
		SetItem.items.put(_id, this);
	}
	
	public ItemStack createInstance() {		
		ItemStack i;
		if( this.material == Material.LEATHER_BOOTS || 
		    this.material == Material.LEATHER_CHESTPLATE || 
		    this.material == Material.LEATHER_HELMET || 
		    this.material == Material.LEATHER_LEGGINGS
		){
			i = new ItemStack(this.material);
			LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
			meta.setColor(this.color);	
			i.setItemMeta(meta);
		}else{
			System.out.println("mein material beim erstellen:");
			System.out.println(this.material.toString());
			i = new ItemStack(this.material);
		}
		ItemMeta meta =i.getItemMeta(); 
		meta.setDisplayName(this.bez);
		List<String> lore = meta.getLore();		
		if(lore == null){
			lore = new LinkedList<String>();
		}
			
		lore.add("Setitem");
		lore.add(HiddenStringUtils.encodeString("{\"itemid\": "+String.valueOf(this.id)+",\"rep\":0}"));		
		
		meta.setLore(lore);
		i.setItemMeta(meta);
		
		return i;
	}
	
	@Override
 	public String toString(){
		String ret = String.valueOf(this.id);
		ret = ret.concat(" ");
		ret = ret.concat(this.bez);
		ret = ret.concat(" ");
		ret = ret.concat(this.set.toString());
		return ret;
	}

 	 public ItemSet getSet() {
		return this.set;
	}
}
