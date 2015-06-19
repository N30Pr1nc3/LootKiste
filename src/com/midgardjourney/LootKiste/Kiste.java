package com.midgardjourney.LootKiste;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Kiste {
	private Block block;
	private HashMap<Player,LootKistenInventar> inventare;
	private static HashMap<Block,Kiste> kisten;
	
	Kiste(){
		
	}

	public void aufstellen(Block kiste){
		this.block= block;
		kiste.setType(Material.SKULL);
		Skull skull = (Skull)kiste.getState();
		skull.setSkullType(SkullType.PLAYER);
		skull.setOwner("MHF_Chest");
		skull.setRotation(BlockFace.NORTH_NORTH_EAST);
		skull.update(true);			
	}
	
	public void addInventorry(Player player,LootKistenInventar inventory){
		this.inventare.put(player, inventory);
	}
	
	public void userInventarOeffnen(Player p) {
		if(this.inventare.containsKey(p)){
			p.openInventory(this.inventare.get(p).getInventory());
		}
	}
	
	public static void inventarOeffnen(Block b, Player p) {
		if(Kiste.kisten.containsKey(b)){
			Kiste.kisten.get(b).userInventarOeffnen(p);
		}
	}

	
}
