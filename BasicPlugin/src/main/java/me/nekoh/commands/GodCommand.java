package me.nekoh.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            if (p.hasPermission("nekessentials.staff.god")){
                if (p.isInvulnerable()){
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "Modalità God disattivata");
                } else {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GOLD + "Modalità God attivata");
                }
            }

        }

    return true;
    }
}
