package io.reuac.damageviewer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("damageviewer.main")) {
                DamageViewer.main.reloadConfig();
                DamageViewer.main.loadConfig();
                commandSender.sendMessage("[DamageViewer] Reloaded!");
            }else {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"[DamageViewer] By reuAC"));
            }
        }else {
            DamageViewer.main.reloadConfig();
            DamageViewer.main.loadConfig();
            commandSender.sendMessage("[DamageViewer] Reloaded!");
        }
        return false;
    }
}
