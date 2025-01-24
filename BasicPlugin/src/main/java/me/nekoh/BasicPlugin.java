package me.nekoh;

import me.nekoh.commands.GodCommand;
import me.nekoh.commands.KillCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class BasicPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("god").setExecutor(new GodCommand());
        getCommand("kill").setExecutor(new KillCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
