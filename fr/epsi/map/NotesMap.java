package fr.epsi.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Illustration de l'utilisation de java.util.Map pour la manipulation de structures
 */
public class NotesMap {

    public static void main(String[] args) throws IOException {

        // On crée une Map qui va associer le nom de chaque élève (Key) à une liste de
        // notes (Value)
        Map<String, List<Double>> eleves = new HashMap<>();

        List<String> lines = Files.readAllLines(Path.of("./resources/notesMap.txt"));

        for (String line : lines) {
            String[] lineSplitted = line.split(":");
            String nom = lineSplitted[0];
            String noteAsString = lineSplitted[1];
            Double note = Double.parseDouble(noteAsString);

            // Pour la ligne en cours, on teste si on a déjà une entrée correspondant au no
            // de l'élève
            if (eleves.get(nom) == null) {
                // Eleve non présent dans la Map
                // on crée une nouvelle liste de note à laquelle on ajoute la note de la ligne
                // en cours
                List<Double> notes = new ArrayList<>();
                notes.add(note);
                // On ajoute à la Map ce nouvelle élève
                eleves.put(nom, notes);
            } else {
                // Eleve déjà présent dans la Map
                // on récupère simplement sa liste de notes et on y ajoute la nouvelle lue dans
                // la ligne en cours
                List<Double> notes = eleves.get(nom);
                notes.add(note);
            }

        }

        System.out.println("- Notes de chaque élève triées");
        // On itère sur l'ensemble des clefs de la Map, donc l'ensemble des noms
        // d'élèves
        for (String nom : eleves.keySet()) {
            // On tri l'ensemble de ses notes
            Collections.sort(eleves.get(nom));
            // puis on les affiche
            List<Double> notes = eleves.get(nom);
            System.out.println("Notes pour " + nom + " : " + notes);
        }

        // On crée une nouvelle Map pour stocker les moyennes de chaque élève
        Map<String, Double> moyennesMap = new HashMap<>();
        for (String nom : eleves.keySet()) {
            // Pour chacun des élèves, on calcule sa moyenne et on renseigne la Map
            Double moyenne = (eleves.get(nom)).stream().mapToDouble(t -> t).average().getAsDouble();
            moyennesMap.put(nom, moyenne);
        }

        System.out.println("- Tri par moyenne");
        // On trie la map avec un comparateur par "Value" et on affiche chaue entrée
        moyennesMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
            .forEach(e -> System.out.printf("Moyenne de %s ; %.2f \n",e.getKey(), e.getValue()));

    }
}
