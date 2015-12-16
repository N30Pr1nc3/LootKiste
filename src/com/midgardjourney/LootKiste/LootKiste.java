package com.midgardjourney.LootKiste;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class LootKiste extends JavaPlugin implements Listener{
	String bossprefix = "[BOSS]";
	
	public void onEnable(){ 
		getServer().getPluginManager().registerEvents(this, this);
		System.out.println("Lade Lootkisten");
	}
	 
	public void onDisable(){ 
		System.out.println("Beende Lootkisten");
	}
	
	@EventHandler
	public void onInteractEvent(PlayerInteractEvent event) {
    } 
	
	@EventHandler
	public void onEnitiyDeathEvent(EntityDeathEvent  event) {
	}
		
	@EventHandler
	public void onEnitiyDamageEvent(EntityDamageByEntityEvent  event) {
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent b){
	}
}
