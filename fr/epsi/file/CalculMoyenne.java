package fr.epsi.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class CalculMoyenne {

    public static void main(String[] args) throws IOException {
        
        // chemin d'accès au fichier contenant les notes
        Path filePath = Path.of("./resources/notes.txt");

        // on lit l'ensemble des lignes du fichier
        List<String> lines = Files.readAllLines(filePath);

        // on itère ensuite sur chacun des lignes du fichier
        for (String line : lines) {
            // on "split" la chaine de caractère avec le séparateur '|'
            // particularité ici : la carctère '|' est réservé pour les expressions régulières ('ou' logique)
            // il faut donc le faire précéder de '\', qui lui même est un caractère d'échapement et donc doit également être précédé par '\' !!!
            // détail des regexp ici : https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html#sum
            String[] elts = line.split("\\|");

            // le premier élément est le nom de l'étudiant
            String name = elts[0];

            // on crée une liste de double qui va contenir les notes
            List<Double> noteList = new ArrayList<Double>();
            
            // on itère sur les éléments restant (on commençant par le deuxième élément donc l'indice 1)
            for(int i = 1; i < elts.length; i++) {
                String noteAsString = elts[i];
                noteList.add(Double.parseDouble(noteAsString));
            }

            // on affiche le résultat pour la ligne en cours
            System.out.println("La moyenne pour ["+name+"] est de ["+getMoyenne(noteList)+"]");
        }
    }

    // méthode utilitaire pour calculer la moyenne d'une liste de Double
    private static double getMoyenne(List<Double> noteList) {
        Double somme = 0.0;
        for (Double note : noteList) {
            somme += note;
        }
        double moyenne = somme / noteList.size();
        return moyenne;
    }
}
