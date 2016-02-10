package de.myralia.setitems;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.command.CommandSender;


public class ItemSet {

	private static HashMap<Integer,ItemSet> sets;
	
	public static ItemSet getSetById(int id) {
		if(!ItemSet.sets.containsKey(id)){
			System.out.println("fehler ein set mit der id "+id+" gibt es nicht");
			System.out.println("möglich sind:");
			for(ItemSet set : ItemSet.sets.values()){
				System.out.println(set.toString());
			}
			return null;
		}	
		return ItemSet.sets.get(id);
	}
	
	public static void instanciate(){
		ItemSet.sets = new HashMap<Integer,ItemSet>();
		SetItem.initiate();
	}

	public static void list(CommandSender sender) {
		sender.sendMessage(Color.gray +"Mögliche Sets / Items");
		sender.sendMessage("test");
		for (ItemSet set : ItemSet.sets.values()) {
			sender.sendMessage(Color.blue + set.toString());
			for (SetItem item: set.getItems()){
				sender.sendMessage(Color.green+item.toString());
			}
		}	
	}
	
	public static void deleteAll() {
		ItemSet.sets.clear();
	}

	private int id;
	private String bez;
	
	public ItemSet(int _id,String _bez){
		this.bez=_bez;
		this.id = _id;
		ItemSet.sets.put(id, this);
	}
	
	@Override
	public String toString(){
		String ret = String.valueOf(this.id);
		ret = ret.concat(" ");
		ret = ret.concat(this.bez);
		return ret;
	}
	
	private ArrayList<SetItem> getItems() {
		ArrayList<SetItem> ret = new ArrayList<SetItem>();
		for(SetItem item:SetItem.items.values()){
			if(item.getSet().equals(this)){
				ret.add(item);
			}
		}
		return ret;
	}

}
