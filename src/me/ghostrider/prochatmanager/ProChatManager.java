package me.ghostrider.prochatmanager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.ghostrider.prochatmanager.commands.ClearChatCMD;
import me.ghostrider.prochatmanager.listeners.JoinMessageListener;
import me.ghostrider.prochatmanager.listeners.WordBlockListener;

public class ProChatManager extends JavaPlugin {

	FileConfiguration config = getConfig();

	private static Plugin plugin;

	@Override
	public void onEnable() {

		plugin = this;

		getServer().getPluginManager().registerEvents(new JoinMessageListener(), this);
		getServer().getPluginManager().registerEvents(new WordBlockListener(), this);

		this.getCommand("clearchat").setExecutor(new ClearChatCMD());

		config.options().copyDefaults(true);
		saveConfig();

	}

	@Override
	public void onDisable() {

		plugin = null;

	}

	public static Plugin getPlugin() {

		return plugin;

	}
}
