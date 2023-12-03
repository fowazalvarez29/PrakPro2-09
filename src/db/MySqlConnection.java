/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alvarez
 */

// Mendefinisikan kelas MySqlConnection.
public class MySqlConnection {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/pp2_membership"; // Mendefinisikan URL basis data.
    private final static String DB_USER = "root"; // Mendefinisikan nama pengguna basis data.
    private static String DB_PASS = ""; // Mendefinisikan kata sandi basis data.
    
    // Mendefinisikan variabel instance sebagai instansiasi dari kelas MySqlConnection.
    private static MySqlConnection instance; 
    
    // Mendefinisikan metode getInstance untuk mendapatkan instance dari kelas MySqlConnection.
    public static MySqlConnection getInstance() { 
        if (instance == null) { // Memeriksa apakah instance masih null.
            instance = new MySqlConnection(); // Jika instance null, maka instance baru dibuat.
        }
        return instance; // Mengembalikan instance dari kelas MySqlConnection.
    }
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}