package me.ghostrider.prochatmanager.listeners;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import me.ghostrider.prochatmanager.ProChatManager;

public class CommandBlockListener implements Listener {

	Plugin plugin = ProChatManager.getPlugin();
	FileConfiguration config = plugin.getConfig();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommand(PlayerCommandPreprocessEvent event){
		Player sender = event.getPlayer();
		String msg = event.getMessage();
		List<String> commands = config.getStringList("settings.blocked-commands");
		for (String command : commands)
		if (msg.split(" ")[0].equalsIgnoreCase("/" + command)){
			//if(!(sender.hasPermission("prochatmanager.bypass"))){
				event.setCancelled(true);
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.command-blocked")));
				return;
			}
		}
	}