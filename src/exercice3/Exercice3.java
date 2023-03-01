package exercice3;
/** Author : N'zo lagou
 *
 *  Exercice 3 : Opération SELECT
 * Instructions
 * Dans cet exercice, vous allez récupérer et afficher les enregistrements de notre table COMPANY de l'exercice précédent à l'aide de PostgreSQL JDBC
 *
 * Créez une connexion de base de données au serveur PostgreSQL.
 *
 * Créez un objet Statement.
 *
 * Exécuter une instruction pour récupérer des données
 *
 * SELECT * FROM COMPANY;
 * Fermez la connexion à la base de données.

*/

import database.Connexion;
import models.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Exercice3 {
    public static List<Company> getALlCompany() {
        List<Company> companies = new ArrayList<>();
        final String SQL = "SELECT * FROM company";

        try {
            Connection connection = new Connexion().getConnecion();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("address"),
                        resultSet.getDouble("salary")
                );
                companies.add(company);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return companies;
    }
}
