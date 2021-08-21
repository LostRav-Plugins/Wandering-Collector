package com.lostrav.wanderingcollector.wanderingcollector;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class SQL {

    WanderingCollector CORE;

    private Connection conn;
    private String dbhost = "";
    private String username = "";
    private String password = "";

    public SQL(WanderingCollector CORE){
        this.CORE = CORE;

        createNewDBConnection();
    }

    @SuppressWarnings("finally")
    public Connection createNewDBConnection() {
        try  {
            conn = DriverManager.getConnection(dbhost, username, password);
        } catch (SQLException e) {
            System.out.println("Cannot create database connection");
            e.printStackTrace();
        } finally {
            return conn;
        }
    }
}
