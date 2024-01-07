package fr.epsi.string.util;

/**
 * Classe utilitaire permettant d'obtenir, à partir d'une chaine de caractères, une nouvelle chaine
 * de caractères avec un caractère choisi inséré entre chaque caractères de la chaine d'origine
 */
public class StringUtil {

    // Cet attribut représentant le caractère à insérer est privé 
    // afin de ne pas pouvoir le modifier en dehors de cette classe
    private char caractere;
    
    // Ce constructeur permet de choisir le caractère séparateur
    // le choix de passer ce paramètre via constructeur versus un 'setter'
    // permet de s'assurer qu'il ne pourra pas être modifié une fois l'instance créée
    public StringUtil(char car) {
        caractere = car;
    }

    // Le constructer par défaut (sans paramètre) doit être déclaré spécifiquement 
    // il construit ici une instance avec le caractère seeparateur '+'
    public StringUtil(){
        this('+');
    }

    public String insert(String chaine) {

        // On crée un buffer dans lequel on va au fur et à mesure ajouter (append) les caractères
        StringBuffer sb = new StringBuffer();
        // On itère sur chaque caractère de la chaîne passée en paramètre de la fonction
        for(char c : chaine.toCharArray()) {
            // On ajoute au buffer le caractère courant
            sb.append(c);
            // puis le caractère de séparation
            sb.append(caractere);
        }
        // Le StringBuffer est "applati" en une chaîne de caractères
        String result = sb.toString();
        // on retourne cette chaîne sans le dernier caractère "en trop"
        return result.substring(0, result.length()-1);
    }
}
