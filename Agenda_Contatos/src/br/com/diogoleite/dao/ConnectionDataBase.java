/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author diogo_leite
 */
public class ConnectionDataBase {
    private static final ConnectionDataBase connectionDataBase;
    private static Connection connection;
    private final String URL = "jdbc:sqlite:/banco_de_dados/agenda.db";
    private final String DRIVER = "org.sqlite.JDBC";
    static{
        connectionDataBase = new ConnectionDataBase();
    }
    
    private ConnectionDataBase(){}
    
    public static ConnectionDataBase getInstance(){
        return connectionDataBase;
    }
    
    public Connection getConnection() throws SQLException{
        
        if(connection == null){
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }
    
    
    public void connectionClose() throws SQLException{
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }
    
}
