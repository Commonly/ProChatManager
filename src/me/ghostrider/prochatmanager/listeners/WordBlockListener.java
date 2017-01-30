package me.ghostrider.prochatmanager.listeners;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import me.ghostrider.prochatmanager.ProChatManager;

public class WordBlockListener implements Listener {

	Plugin plugin = ProChatManager.getPlugin();
	FileConfiguration config = plugin.getConfig();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		for (String word : e.getMessage().split(" ")) {
			if (config.getStringList("settings.blocked-words").contains(word)) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.word-blocked")));
			}
		}
	}

}
