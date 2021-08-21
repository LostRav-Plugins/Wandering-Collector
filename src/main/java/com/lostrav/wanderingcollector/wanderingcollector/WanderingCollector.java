package com.lostrav.wanderingcollector.wanderingcollector;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.lostrav.wanderingcollector.wanderingcollector.onPlayerDeath;
import com.lostrav.wanderingcollector.wanderingcollector.onItemDestroy;

import java.util.logging.Level;


public final class WanderingCollector extends JavaPlugin {

    //START OF PLUGIN
    @Override
    public void onEnable() {
        // Save the plugin configuration file
        this.saveDefaultConfig();

        // Set the classes as event executors
        Bukkit.getPluginManager().registerEvents(new onPlayerDeath(this), this);
        Bukkit.getPluginManager().registerEvents(new onItemDestroy(this), this);

        //Confirmation in console of correct enabling of the plugin
        Bukkit.getLogger().log(Level.INFO, "Wandering Collector Successfully Enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().log(Level.INFO, "Thanks For Using Wandering Collector!");
    }
}
