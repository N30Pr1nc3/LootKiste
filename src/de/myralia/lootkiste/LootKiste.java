package de.myralia.lootkiste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
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

import com.mysql.jdbc.MySQLConnection;

import de.myralia.lootkiste.setitems.ItemSet;
import de.myralia.lootkiste.setitems.LootKisteItemMeta;
import de.myralia.lootkiste.setitems.SetItem;

public class LootKiste extends JavaPlugin implements Listener{
	
	public void onEnable(){ 
		getServer().getPluginManager().registerEvents(this, this);
		System.out.println("Lade Items");
		this.loadItems();
		System.out.println("Lade Lootkisten");
		
	}
	 
	public void onDisable(){ 
		System.out.println("Beende Lootkisten");
	}
	
	@EventHandler
	public void onInteractEvent(PlayerInteractEvent event) {
    } 

	
	private void calcUser(Player _player)
	{
		System.out.println("moep");
		HashMap<ItemStack,LootKisteItemMeta> items = new HashMap<ItemStack,LootKisteItemMeta>();
		
		//_player.get

		
		
		
//		ListIterator<ItemStack> it = _player.getInventory().iterator();	       
//        while(it.hasNext())
//        {
//            ItemStack is = it.next();
//            LootKisteItemMeta meta = SetItem.getMeta(is);            
//            if(meta == null){
//            	continue;
//            }
//            items.put(is,meta);
//        }
        
        
		
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
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("item")){
			if(args.length==0){
				sender.sendMessage("item [command]");
				sender.sendMessage("item list: Listet alle möglichen items auf");				
			}
			if(args.length==1){
				if(args[0].equals("info")){					
					if(sender instanceof Player ){
//						LootKisteItemMeta meta = SetItem.getMeta(((Player) sender).getInventory().getItemInHand());
//						sender.sendMessage(meta.toString());
						sender.sendMessage(SetItem.getMeta(((Player) sender).getInventory().getItemInHand()).toString());
					}
					return true;
				}				
				if(args[0].equals("list")){
					sender.sendMessage("Mögliche items");
					for (SetItem item : SetItem.items.values()) {
						sender.sendMessage(item.toString());
					}
					return true;
				}
				if(args[0].equals("reload")){
					this.loadItems();
					return true;
				}
			}
			if(args.length==2){
				if(args[0].equals("get")){
					if(!(sender instanceof Player)){
						sender.sendMessage("bitte Spielername Angeben");
					}
					if(!NumberUtils.isNumber(args[1])){
						sender.sendMessage(args[1]+" ist keine zahl");
						return true;
					}
					SetItem item = SetItem.get(Integer.parseInt(args[1]));
					if(item ==null){
						sender.sendMessage("die itemid "+args[1]+" konnte nicht gefunden werden");
						sender.sendMessage("benutze /item list um mögliche item su sehen");
						return true;
					}
					ItemStack itemStack = item.createInstance();
					if (itemStack == null){
						sender.sendMessage("beim erstellen des Items ist etwas schief gelaufen.");
						sender.sendMessage("renn schreiend zu NeoPrince und erzähl ihm was du getan hast");
						return true;
					}
					((Player) sender).getInventory().addItem(itemStack);
					return true;
				}
			}
		}
		return false;
	}

	private void loadItems() {
		System.out.println("Lade Items");
		SetItem.initiate();		
	}
		
}
