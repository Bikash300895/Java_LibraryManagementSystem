/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shuvendu Bikash
 */

import java.sql.*;
import javax.swing.JOptionPane;


public class JavaConnect {
    public static Connection conn;
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String CONN_STRING = "jdbc:mysql://localhost/library";
    
    
    public static Connection ConnectDb(){
        try{
            Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            return conn;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Error to connect");
            return null;
        }
    }
    
    public static void main(String[] args){
        conn = ConnectDb();
    }
}
