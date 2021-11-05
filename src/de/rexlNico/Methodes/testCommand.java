package de.rexlNico.Methodes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class testCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command arg1, String arg2, String[] arg3) {
		Inventory inv = Bukkit.createInventory(null, 9, "§8» §6Profil");
		inv.addItem(new ItemStack(Material.FIREWORK));
		
		Player p = (Player)s;
		p.openInventory(inv);
		return false;
	}

}
