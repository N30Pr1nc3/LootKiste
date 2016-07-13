package de.myralia.lootkiste.setitems;

import org.bukkit.inventory.ItemStack;

public class LootKisteItemMeta {
	
	public static LootKisteItemMeta decode(String s)
	{			
		String[] split =HiddenStringUtils.extractHiddenString(s).split("\\|");
		
		if(split.length !=2){
			return null;
		}
		LootKisteItemMeta meta = new LootKisteItemMeta();
		
		try {
			meta.id = Integer.parseInt(split[0]);
			meta.repairs = Integer.parseInt(split[1]);
		} catch (NumberFormatException e) {
			return null;
		}		
		
		return meta;
	}	
	
	public int id = 0;
	public int repairs = 0;
	
	@Override
	public String toString()
	{
		return new StringBuilder()
	    .append(this.id)
	    .append("|")
	    .append(this.repairs)
	    .toString();
	}
		
	public String encode()
	{
		return HiddenStringUtils.encodeString(this.toString());
	}
	
	public SetItem getSetItem()
	{
		return SetItem.get(this.id);		
	}

	
}
