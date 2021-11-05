package de.rexlNico.Main;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rexlNico.Listeners.OpenExtrasGui;
import de.rexlNico.Methodes.testCommand;

public class Main extends JavaPlugin{

	private Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("§eExtras §4geladen");
		
		pm.registerEvents(new OpenExtrasGui(), this);
		getCommand("test").setExecutor(new testCommand());
		
	}
	
	public Main getPlugin() {
		return plugin;
	}
	
}
