/**@author N'ZO LAGOU
 *
 *  Exercice 1 : Créer Un Tableau
 * Instructions
 * Dans cet exercice, vous allez créer une table en utilisant PostgreSQL JDBC
 *
 * Créez une connexion de base de données au serveur PostgreSQL.
 *
 * Créez une requête SQL.
 *
 * Exécuter une requête pour créer la table
 * CREATE TABLE COMPANY (
 *     ID      INT     PRIMARY KEY     NOT NULL,
 *     NAME    TEXT    NOT NULL,
 *     AGE     INT     NOT NULL,
 *     ADDRESS CHAR(50),
 *     SALARY  REAL
 * )
 * Fermez la connexion à la base de données.
* */

package exercice1;

import database.Connexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Create a database connection to the PostgreSQL server.
    Create a SQL query.
    Execute a query to create the table
*/
public class Exercice1 {
    public static void createTable() {
        final String SQL = """
                    CREATE TABLE company(
                        id SERIAL PRIMARY KEY NOT NULL,
                        name TEXT NOT NULL,
                        age INT NOT NULL,
                        address CHAR(50),
                        salary REAL
                    )
                """;

        try {
            Connection connection = new Connexion().getConnecion();
            Statement statement = connection.createStatement();

            statement.executeUpdate(SQL);
            System.out.println("Table créé avec succès");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
