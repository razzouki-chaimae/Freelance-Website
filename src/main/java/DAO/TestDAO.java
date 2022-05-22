package DAO;

import java.sql.*;

public class TestDAO {
    private static Connection connexion;
    
    private static void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Chargement du driver réussi");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/avito", "root", "");
            System.out.println("Connexion réussie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Statement statement = null;
        ResultSet resultat = null;
        
        loadDatabase();
    }

}
