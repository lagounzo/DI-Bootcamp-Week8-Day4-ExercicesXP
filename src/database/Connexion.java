package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private Connection connection = null;

    public Connection getConnecion() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental", "postgres", "root2022");
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données");
            ex.printStackTrace();
        }

        return connection;
    }
}
