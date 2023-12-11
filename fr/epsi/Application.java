// Le nom du package va déterminer le chemin du fichier sur le FileSystem
package fr.epsi;

/**
 * Le nom de la classe commence par convention par une majuscule 
 * Le fichier contenant cette classe doit porter le même nom
 */
public class Application {

    /** 
     * La méthode main doit avoir cette signature précise 
     * (nom de la méthode, type de retour et paramètres)
     * pour que la JVM puisse l'exécuter en tant que 
     * point d'entrée de votre programme
     */
    public static void main(String[] args) {
        // Le paramètre args a été renseigné par la JVM 
        // avec les valeurs de la ligne de commande (tableau de chaines de caractères)
        
        // on extrait du tableau les 2 paramètres
        // attention : on suppose ici que 2 paramètres sont bien renseignés, 
        // on ne traite pas de cas d'erreur qui pourrait déclencher un ArrayIndexOutOfBoundsException
        String premierParametre = args[0];
        String secondParametre = args[1];

        // on traduit ces 2 chaines de caractères en entier
        // attention : on ne traite pas ici d'erreur de format de nombre, 
        // qui résulterait comme on a pu le voir en NumberFormatException
        int premierEntier = Integer.parseInt(premierParametre);
        int secondEntier = Integer.parseInt(secondParametre);

        // on calcule la somme puis on l'affiche
        int somme = premierEntier + secondEntier;
        System.out.println(somme);
    }
    
}