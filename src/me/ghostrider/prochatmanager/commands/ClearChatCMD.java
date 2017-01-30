package me.ghostrider.prochatmanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.ghostrider.prochatmanager.ProChatManager;

public class ClearChatCMD implements CommandExecutor {

	Plugin plugin = ProChatManager.getPlugin();
	FileConfiguration config = plugin.getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		String message = plugin.getConfig().getString("messages.clearchat");
		message = message.replace("%sender%", sender.getName());

		if (sender.hasPermission("prochatmanager.clearchat")) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.hasPermission("prochatmanager.bypass")) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
					return true;

				} else {

					for (int i = 0; i < 110; i++)
						player.sendMessage(" ");
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
					return true;

				}
			}
		}
		return false;
	}
}