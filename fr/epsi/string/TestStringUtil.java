package fr.epsi.string;

import fr.epsi.string.util.StringUtil;

public class TestStringUtil {
    public static void main(String[] args) {

        // On récupère le premier argument de la ligne de commande
        String chaine = args[0];

        // On crée une instance de la classe utilitaire avec son constructeur par défaut (utilisant le caractère '+')
        StringUtil utilPlus = new StringUtil();
        // On utilise cette instance sur la chaine de caractère passée en paramètre
        // notez que cette chaîne n'est pas modifiée, on en obteint une nouvelle affectée à une autre variable        
        String chaineAvecPlus = utilPlus.insert(chaine);

        // On cré une nouvelle instance de la classe utilitaire avec cette fois le constructeur permettant de choisir le caractère à insérer
        StringUtil utilUnderscore = new StringUtil('_');

        // On affiche le résultat des deux appels, on note que pour le second on se passe d'affectation du résultat à une variable intermédiare
        System.out.println("Chaine modifiée avec '+' :" + chaineAvecPlus);
        System.out.println("Chaine modifiée avec '_' :" + utilUnderscore.insert(chaine));
    }
}
