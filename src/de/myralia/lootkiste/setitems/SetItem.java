
package de.myralia.lootkiste.setitems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import de.myralia.lootkiste.setitems.items.BlutDuerster;
import sun.reflect.Reflection;

public abstract class SetItem {
	public static HashMap<Integer, SetItem> items;
	
	public static LootKisteItemMeta getMeta(ItemStack i){
		if(i==null){
			return null;
		}
		ItemMeta meta = i.getItemMeta();
		if(meta == null){
			return null; 
		}
		if(!meta.hasLore()){
			return null;
		}
		List<String> lore = meta.getLore();
		
		return LootKisteItemMeta.parse(lore.get(lore.size()));
	}
	
 	public static void initiate(){
 		if(SetItem.items == null){
			SetItem.items = new HashMap<Integer, SetItem>();
		}
		else{
			SetItem.items.clear();	
		}	
 		
 		SetItem.addItem(new BlutDuerster());			
	}
 	
 	private static void addItem(SetItem item){
 		if(!SetItem.items.containsKey(item.id))
 		{
 			SetItem.items.put(item.id, item);	
 		}
 				
 	}
 	
 	public static SetItem get(int itemid) {
		if(!SetItem.items.containsKey(itemid)){
			System.out.println("Ein Setitem mit der id "+itemid+" konnte nicht gefunden werden");
			return null;
		}
		return SetItem.items.get(itemid);
	}
	
	protected  int id;
	protected String bez;
	protected Material material;
	protected ItemSet set;
	
	public SetItem()
	{		
	}
	
	public abstract ItemStack createInstance();	

	protected void createMeta(ItemStack i) {
		ItemMeta meta =i.getItemMeta(); 
		meta.setDisplayName(this.bez);
		List<String> lore = meta.getLore();		
		if(lore == null){
			lore = new LinkedList<String>();
		}
			
		lore.add("Setitem");
		lore.add(HiddenStringUtils.encodeString(new LootKisteItemMeta().toString()));		
		
		meta.setLore(lore);
		i.setItemMeta(meta);
	}

	@Override
 	public String toString(){
		String ret = String.valueOf(this.id);
		ret = ret.concat(" ");
		ret = ret.concat(this.bez);
		if(this.set!=null){
			ret = ret.concat(" ");
			ret = ret.concat(this.set.toString());	
		}
		else{
			ret = ret.concat(" kein Set");
		}
		return ret;
	}

 	public ItemSet getSet() {
		return this.set;
	}
}
