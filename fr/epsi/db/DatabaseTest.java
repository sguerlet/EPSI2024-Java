package fr.epsi.db;

import java.util.Properties;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

/* 
 * Classe pour illustrer la connection à une basse de données
 * Le détail des prérequis se trouve dans le support de cours
 * Vous avez besoin évidemment d'une base de données accessible (proposition : une image Docker de PostgreSQL)
 * Vous aurez également besoin d'un Driver JDBC, sous la forme d'un fichier .jar ajouté au classpath (configurable via IDE ou en ligne de commande)
 */
public class DatabaseTest {

    public static void main(String[] args) throws Exception {

        // L'URL de connexion JDBC contient les propriétés du serveur, à commencer par son type, ici "posgresql"
        String url = "jdbc:postgresql://localhost:5432/sakila";
        // Proprietés 
        Properties props = new Properties();
        props.setProperty("user", "sakila");
        props.setProperty("password", "p_ssW0rd");
        // À partir du DriverManager, on peut obtenir une connexion en renseignant les paramètres
        Connection conn = DriverManager.getConnection(url, props);

        // Depuis cette connexion, on crée un Statement
        Statement st = conn.createStatement();
        //  et depuis ce Statement, on peut exécuter une requête
        ResultSet rs = st.executeQuery("SELECT * FROM actor LIMIT 10");
        // Le résultat d'une requête est obtenu dans un ResultSet, surlequel on peut itérer
        while (rs.next()) {
            // pour chaque ligne de résultat, on obtient les valeurs soit par indice, soit par le nom de la colonne comme ici
            System.out.print(rs.getString("first_name") + " - ");
            System.out.println(rs.getString("last_name"));
        }
        // Statement et ResultSet doivent être correctement fermés
        rs.close();
        st.close();
    }
}
