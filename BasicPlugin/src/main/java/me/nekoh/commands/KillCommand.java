package me.nekoh.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        boolean Hide = true;
        if (commandSender instanceof ConsoleCommandSender) {
            System.out.println("Questo comando può essere eseguito solo dai giocatori");
        } else {
            Player p = (Player) commandSender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.BLUE + "Il comando dev'essere utilizzato su altri giocatori, se desideri eseguirlo su te stesso [:c], prova il comando /die");
            } else {
                String nomePlayer = args[0];
                Player target = Bukkit.getServer().getPlayerExact(nomePlayer);
                if (args.length == 1) {
                    Hide = false;
                } else {
                    Hide = Boolean.parseBoolean(args[1]);
                }
                if (target == null){
                    p.sendMessage(ChatColor.RED + "Il giocatore " + nomePlayer + " non esiste, oppure è offline");
                } else {
                    target.setHealth(0.0);
                    if (Hide){
                        target.sendMessage(ChatColor.RED + "Non sei stato molto simpatico o qualcuno... e ne hai pagato le conseguenze");
                    } else if (Hide == false) {
                        target.sendMessage(ChatColor.RED + "Non sei stato molto simpatico a " + p.getDisplayName() + " e ne hai pagato le conseguenze");
                    } else {
                        target.sendMessage("Errore imprevisto");
                        p.sendMessage("Errore imprevisto");
                        System.out.println("Errore imprevisto");
                    }
                }
            }
        }

    return true;
    }
}
