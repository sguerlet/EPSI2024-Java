package fr.epsi.vendeurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.epsi.vendeurs.comparators.ParDateComparateur;
import fr.epsi.vendeurs.comparators.ParVenteComparateur;

/*
 * Classe utilitaire permettant de charger une liste d'objets Vendeur à partir d'un fichier
 * ses méthodes permettent également de trier les vendeurs selon 2 critères 
 */
public class Utilitaire {

    // Méthode pour charger la liste des vendeurs depuis un fichier
    public static List<Vendeur> lireVendeursDepuisFichier(Path path) throws IOException {

        List<Vendeur> vendeurList = new ArrayList<>();

        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {

            try {
                // pour chaque ligne, on va faire appel à une méthode privée
                // cette méthode va parser la ligne et retourner l'objet Vendeur correspondant
                // (ou une instance de sa classe dérivée SeniorVendeur)
                // il peut également se produire une VendeurParsingException en cas de format de
                // la ligne incorrect
                vendeurList.add(lireVendeur(line));
            } catch (VendeurParsingException e) {
                // si on rencontre une telle exception, on en informe l'utilisateur en reprenant
                // la valeur de la ligne et la cause de l'erreur incluse dans l'Exception
                // en traitant l'exception à ce niveau, on s'assure de pouvoir poursuivre le
                // traitement avec la prochaine ligne
                System.err
                        .println("Impossible de parser la ligne [" + line + "] cause de l'erreur : " + e.getMessage());
            }

        }
        return vendeurList;
    }

    public static void trierParDate(List<Vendeur> vendeurs) {

        Collections.sort(vendeurs, new ParDateComparateur());
        Collections.reverse(vendeurs);
    }

    public static void trierParVente(List<Vendeur> vendeurs) {
        Collections.sort(vendeurs, new ParVenteComparateur());
        Collections.reverse(vendeurs);
    }

    // Le parsing d'une ligne du fichier, cette méthode lève potentiellement une
    // Exception lors du parsing (3 cas d'erreur distincts)
    private static Vendeur lireVendeur(String line) throws VendeurParsingException {

        String[] lineSplitted = line.split(":");
        // si la ligne ne comporte pas 4 éléments séparés par ':' comme attendu,
        // on lève une exception avec un message adapté, qui interrompt le traitement de cette méthode
        if (lineSplitted.length != 4) {
            throw new VendeurParsingException("Le format 4 champs séparés par des ':' n'est pas respecté");
        }

        String nom = lineSplitted[0];
        String ageAsString = lineSplitted[1];
        String dateAsString = lineSplitted[2];
        String ventesAsString = lineSplitted[3];

        int age = Integer.parseInt(ageAsString);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.now();
        try {
            date = LocalDate.parse(dateAsString, dtf);
        } catch (DateTimeParseException dtpe) {
            throw new VendeurParsingException("La date est mal formatée : " + dateAsString);
        }
        // une fois que les données du vendeur (en dehors du montant de ses ventes) sont
        // parsées correctement, on peut créer notre instance
        Vendeur vendeur = instancieVendeur(nom, age, date);

        // reste à ajouter le montant de ses ventes au fur et à mesure du parsing du
        // dernier élément de la ligne
        // là encore, une erreur de parsing peut lever une exception et l'objet Vendeur
        // ne sera pas retourné
        for (String venteAsString : ventesAsString.split(";")) {
            Integer vente = null;
            try {
                vente = Integer.parseInt(venteAsString);
            } catch (NumberFormatException nfe) {
                throw new VendeurParsingException(
                        "Le montant de la vente doit être au format numérique : " + venteAsString);
            }
            vendeur.addVente(vente);
        }
        return vendeur;
    }

    // Cette méthode interne (privée) permet d'instancier l'objet vendeur selon le
    // bon Type, en fonction de son age
    private static Vendeur instancieVendeur(String nom, int age, LocalDate date) {
        if (age > 40) {
            return new SeniorVendeur(nom, age, date);
        } else {
            return new Vendeur(nom, age, date);
        }
    }

}
