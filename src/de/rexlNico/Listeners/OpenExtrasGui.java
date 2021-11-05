package de.rexlNico.Listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.rexlNico.Methodes.ItemBuilder;

public class OpenExtrasGui implements Listener{

	private ArrayList<Inventory> invlist = new ArrayList<>();
	private ArrayList<Inventory> Gadgets = new ArrayList<>();
	private ArrayList<Inventory> Rüstung = new ArrayList<>();
	private ArrayList<Inventory> Köpfe = new ArrayList<>();
	private ArrayList<Inventory> Boots = new ArrayList<>();
	private ArrayList<ItemStack> ytKöpfe = new ArrayList<>();
	private ArrayList<ItemStack> ItemBoots = new ArrayList<>();
	private ArrayList<ItemStack> ItemGadgets = new ArrayList<>();
	private ArrayList<ItemStack> ItemRüstung = new ArrayList<>();
	
	private void regBoots(){
		ItemBoots.add(new ItemBuilder(Material.GOLD_BOOTS,1).setName("").build());
	}
	private void regSkulls(){
		
		ytKöpfe.add(new ItemBuilder(Material.SKULL_ITEM, 1, 3).setName("§9RexlManu").setSkullOwner("RexlManu").build());
		
	}
	
	@EventHandler
	public void on(InventoryClickEvent e){
		Player  p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§8» §6Profil")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType().equals(Material.FIREWORK)){
				
				if(invlist.size() != 1){
				
				Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§8» §aExtras");
				
				inv.setItem(3, new ItemBuilder(Material.GOLD_BOOTS, 1).setName("§8● §eBoots").build());
				inv.setItem(1, new ItemBuilder(Material.SKULL_ITEM, 1, 3).setName("§8● §5Köpfe").setSkullOwner(p.getName()).build());
				inv.setItem(2, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1).setName("§8● §3Rüstung").build());
				inv.setItem(0, new ItemBuilder(Material.CHEST, 1).setName("§8● §aGadgets").build());
					
				invlist.add(inv);
				
				}
				
				p.openInventory(invlist.get(0));
				p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
				
			}
		}else if(e.getInventory().getName().equals("§8» §aExtras")){
			if(e.getCurrentItem().getType().equals(Material.GOLD_BOOTS)){
				
				if(Boots.size() != 1){
					Inventory inv = Bukkit.createInventory(null, 9*3, "§8» §eExtras");
					regBoots();
					
					for(int i = 0; i < ItemBoots.size(); i++){
						inv.setItem(i, ItemBoots.get(i));
					}
					
					Boots.add(inv);
				}
				
				p.openInventory(Boots.get(0));
				p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
				
			}else if(e.getCurrentItem().getType().equals(Material.SKULL_ITEM)){
				
				if(Köpfe.size() != 3){
					
					regSkulls();
					
					Inventory i1 = Bukkit.createInventory(null, 9*5, "§8» §5Köpfe");
					Inventory i2 = Bukkit.createInventory(null, 9*5, "§8» §5Köpfe");
					Inventory i3 = Bukkit.createInventory(null, 9*5, "§8» §5Köpfe");
					
					for(int i = 0; i < 9*3; i++){
						for(int g = 0; g < i1.getSize(); i++){
							i1.setItem(g, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("").build());
						}
						i1.setItem(i, ytKöpfe.get(i));
						}
					for(int i = 0; i < 9*3; i++){
						for(int g = 0; g < i1.getSize(); i++){
							i2.setItem(g, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("").build());
						}
						i2.setItem(i, ytKöpfe.get(i+9*3));
						}
					for(int i = 0; i < 9*3; i++){
						for(int g = 0; g < i1.getSize(); i++){
							i3.setItem(g, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("").build());
						}
						i3.setItem(i, ytKöpfe.get(i+9*6));
						}
						
					Köpfe.add(i1);
					Köpfe.add(i2);
					Köpfe.add(i3);
					
				}
				
				p.openInventory(Köpfe.get(0));
				
			}else if(e.getCurrentItem().getType().equals(Material.CHEST)){
				
				if(Gadgets.size() != 1){
					
					ItemGadgets.add(new ItemBuilder(Material.MOB_SPAWNER, 1).setName("§4Pets").build());
					
					Inventory i1 = Bukkit.createInventory(null, 9*5, "§8» §aGadgets");
				
					i1.setItem(11, ItemGadgets.get(0));
					
					Gadgets.add(i1);
				}
				
				p.openInventory(Gadgets.get(0));
				
			}else if(e.getCurrentItem().getType().equals(Material.CHAINMAIL_CHESTPLATE)){
				

				if(Rüstung.size() != 1){
					
					ItemRüstung.add(new ItemBuilder(Material.LEATHER_HELMET, 1).setName("§4Pets").setLeatherColor(Color.RED).build());
					
					Inventory i1 = Bukkit.createInventory(null, 9*4, "§8» §aGadgets");
				
					i1.setItem(1, ItemRüstung.get(0));
					
					Rüstung.add(i1);
				}
				
				p.openInventory(Rüstung.get(0));
				
			}
		}
	}
	
}
