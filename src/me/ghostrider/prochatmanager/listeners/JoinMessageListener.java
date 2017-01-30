package me.ghostrider.prochatmanager.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import me.ghostrider.prochatmanager.ProChatManager;

public class JoinMessageListener implements Listener {

	Plugin plugin = ProChatManager.getPlugin();
	FileConfiguration config = plugin.getConfig();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		if (event.getPlayer().hasPermission("prochatmanager.donatorjoin")) {

			String message_donator = plugin.getConfig().getString("messages.player-join");
			message_donator = message_donator.replace("%player%", event.getPlayer().getDisplayName());

			event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', message_donator));
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.playSound(player.getLocation(), Sound.valueOf("settings.donator-join-sound"), 20.0F, 1.0F);

			}

		} else if (event.getPlayer().hasPermission("prochatmanager.staffjoin")) {

			String message_staff = plugin.getConfig().getString("messages.staff-join");
			message_staff = message_staff.replace("%player%", event.getPlayer().getDisplayName());

			event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', message_staff));
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.playSound(player.getLocation(), Sound.valueOf(config.getString("settings.staff-join-sound")),
						20.0F, 4.0F);

			}

		} else {

			String message_player = plugin.getConfig().getString("messages.player-join");
			message_player = message_player.replace("%player%", event.getPlayer().getDisplayName());

			event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', message_player));

		}
	}
}