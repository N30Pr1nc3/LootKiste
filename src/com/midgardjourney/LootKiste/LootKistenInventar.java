package com.midgardjourney.LootKiste;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class LootKistenInventar {
	private Inventory inventory;
	private Player player;
	
	public LootKistenInventar(Player player) {
		this.player = player;
	}
	
	public LootKistenInventar() {
	}

	public Inventory getInventory() {
		return this.inventory;
	}

}
