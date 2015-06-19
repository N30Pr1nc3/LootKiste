package com.midgardjourney.LootKiste;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Boss{
	private LivingEntity boss;
	private HashMap<Player,Float> damager;
	
	private static HashMap<LivingEntity,Boss> bosse;
	
	Boss(LivingEntity entity){
		this.boss = entity;
	}
	
	public void addDamage(Player player,Float damage){
		if(this.damager.containsKey(player)){
			damage += this.damager.get(player);
		}
		this.damager.put(player, damage);
	}
	
	public void kill() {
		//neue kiste erstellen
		Kiste kiste = new Kiste();
		Location location = this.boss.getLocation();
		
		kiste.aufstellen(location.getBlock());
		
		for(Entry<Player, Float> entry : this.damager.entrySet()) {
		    Player player = entry.getKey();
		    Float damage = entry.getValue();
		    
		    Inventory inventory = new LootKistenInventar();
		    
		    kiste.addInventorry(player, inventory);
		    
		}
	}


	public static Boss get(LivingEntity entity) {
		if(Boss.bosse.containsKey(entity)){
			return Boss.bosse.get(entity);
		}
		return null;
	}

	
}
