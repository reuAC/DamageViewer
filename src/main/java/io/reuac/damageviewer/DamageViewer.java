package io.reuac.damageviewer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DamageViewer extends JavaPlugin {

    static DamageViewer main;

    @Override
    public void onEnable() {
        System.out.println("[DamageViewer] Loading plugin...");

        Bukkit.getPluginCommand("damageviewer").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new MainListener(),this);

        saveDefaultConfig();
        loadConfig();

        main = this;
    }

    private String makeColor(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public void loadConfig(){
        MainListener.message_normal = makeColor(getConfig().getString("Message.normal"));
        MainListener.message_die = makeColor(getConfig().getString("Message.die"));
        MainListener.title_normal = makeColor(getConfig().getString("Title.normal"));
        MainListener.title_normal_sub = makeColor(getConfig().getString("Title.normal_sub"));
        MainListener.title_die = makeColor(getConfig().getString("Title.die"));
        MainListener.title_die_sub = makeColor(getConfig().getString("Title.die_sub"));
        MainListener.OnlyPlayer = getConfig().getBoolean("OnlyPlayer");
        MainListener.enableTitle = getConfig().getBoolean("Title.Enable");
        MainListener.enableMessage = getConfig().getBoolean("Message.Enable");
        MainListener.titleOnShot = getConfig().getBoolean("Title.OnShot");
        MainListener.titleOnAttack = getConfig().getBoolean("Title.OnAttack");
        MainListener.messageOnShot = getConfig().getBoolean("Message.OnShot");
        MainListener.messageOnAttack = getConfig().getBoolean("Message.OnAttack");
        MainListener.decimalPlaces = getConfig().getInt("decimalPlaces");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
