package fr.epsi.vendeurs;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/*
 * La classe principale doit être la plus concise possible
 * Après avoir fait les contrôles de l'argument passé en ligne de commande,
 * on appelle les méthodes de la classe Utilitaire pour charger les vendeurs à partir du fichier, puis pour manipuler cette liste
 */
public class Programme {

    public static void main(String[] args) throws IOException {

        // Si le paramètre en ligne de commande est manquant, on en informe
        // l'utilisateur et on quitte le programme
        if (args.length < 1) {
            System.out.println("Un chemin vers un fichier doit être renseigné en paramètre");
            System.exit(1);
        }
        // Si le paramètre ne correspond pas à un chemin vers un fichier existant, on en
        // informe l'utilisateur et on quitte le programme
        Path path = Path.of(args[0]);
        if (!path.toFile().exists()) {
            System.out.println("Le fichier [" + path + "] est introuvable");
            System.exit(1);
        }

        // Lire les vendeurs depuis le fichier
        System.out.println("\n - Traitement du fichier");
        List<Vendeur> vendeurs = Utilitaire.lireVendeursDepuisFichier(path);
        // Trier selon le montant des ventes
        System.out.println("\n - Tri par montant de ventes");
        Utilitaire.trierParVente(vendeurs);
        afficher(vendeurs);
        // Trier selon la date
        System.out.println("\n - Tri par date");
        Utilitaire.trierParDate(vendeurs);
        afficher(vendeurs);
    }

    // méthode utilitaire pour afficher les vendeurs
    private static void afficher(List<Vendeur> vendeurs) {
        for (Vendeur vendeur : vendeurs) {
            System.out.println(vendeur);
        }
    }
}
