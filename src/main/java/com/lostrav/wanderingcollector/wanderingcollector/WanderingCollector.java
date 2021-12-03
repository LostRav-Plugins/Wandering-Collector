package com.lostrav.wanderingcollector.wanderingcollector;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.lostrav.wanderingcollector.wanderingcollector.onPlayerDeath;
import com.lostrav.wanderingcollector.wanderingcollector.onItemDestroy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;


public final class WanderingCollector extends JavaPlugin {

    //START OF PLUGIN
    @Override
    public void onEnable() {
        // Save the plugin configuration file
        this.saveDefaultConfig();
        this.prepareDatabase();

        // Set the classes as event executors
        Bukkit.getPluginManager().registerEvents(new onPlayerDeath(this), this);
        Bukkit.getPluginManager().registerEvents(new onItemDestroy(this), this);

        //Confirmation in console of correct enabling of the plugin
        Bukkit.getLogger().log(Level.INFO, "Wandering Collector Successfully Enabled!");

    }

    @Override
    public void onDisable() {
        this.closeConnection(conn);
        // Plugin shutdown logic
        Bukkit.getLogger().log(Level.INFO, "Wandering Collector Successfully Disabled!");
        Bukkit.getLogger().log(Level.INFO, "Thanks For Using Wandering Collector!");
    }

    //DATABASE LOGIC
    private Connection conn;
    private Connection closed;
    private String dbhost = this.getConfig().getString("Database.Host");
    private int dbport = this.getConfig().getInt("Database.Port");
    private String username = this.getConfig().getString("Database.Username");
    private String password = this.getConfig().getString("Database.Password");
    private String database = this.getConfig().getString("Database.Database");

    public Connection getConnection(){

        try {
            if (conn != null && !conn.isClosed() ) {
                return conn;
            } else {
                try {
                    if (password == null) {
                        conn = DriverManager.getConnection("jdbc:mysql://" + dbhost +":" + dbport + "/" + database, username, null);
                    } else {
                        conn = DriverManager.getConnection("jdbc:mysql://" + dbhost +":" + dbport + "/" + database, username, password); }

                    return conn;
                } catch (SQLException e) {
                    Bukkit.getLogger().log(Level.SEVERE, "Cannot connect to database");
                    e.printStackTrace();
                    Bukkit.getPluginManager().disablePlugin(this);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
        return null;
    }

    public void closeConnection(Connection closed) {

        if (closed != null) {
            try {
                closed.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void prepareDatabase() {

        try {
            //TODO Create table with correct columns
            this.preparedStatement("CREATE TABLE IF NOT EXISTS `"+database+"`.`wanderingCollector` (  ) ENGINE = InnoDB;").executeUpdate();
            return;
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    public PreparedStatement preparedStatement(String query) {
        PreparedStatement ps = null;
        Connection connect = this.getConnection();

        try {
            ps = connect.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
}
