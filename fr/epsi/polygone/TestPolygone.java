package fr.epsi.polygone;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class TestPolygone {
    
    public static void main(String[] args) {

        // On crée des instances de Carre et Rectangle
        Rectangle rectangle1 = new Rectangle(9,4);
        Rectangle rectangle2 = new Rectangle(5,2);
        Carre carre1 = new Carre(4);
        Carre carre2 = new Carre(5);
        Carre carre3 = new Carre(3);

        // On peut créer une liste d'objets de type QuadrilatereRectangle car Carre et Rectangle héritent tout deux cette classe parente
        List<QuadrilatereRectangle> liste = new ArrayList<QuadrilatereRectangle>();
        
        liste.add(rectangle1);
        liste.add(rectangle2);
        liste.add(carre1);
        liste.add(carre2);
        liste.add(carre3);

        // Ici on peut traiter les élements de la liste comme des Polygone, car les élements qui la compose implémentent bien cette interface
        // ce choix est justifié ici car on ne va faire appel qu'à des méthodes définies par cette interface
        for(Polygone polygone : liste) {
            
            // Pour chaque élément de la liste, on peut faire appel à toString (car hérité de Object) et getSurface (car défini par Polygone)
            // A noter que l'ordre d'affichage est bien l'ordre d'ajout précédent des objets à la liste
            System.out.println(polygone.toString()+" / surface = "+polygone.getSurface());
        }

        // On trie la liste, ce qui va faire appel à la méthode compareTo de l'interface Comparable 
        // dont l'implémentation fournie par QuadrilatereRectangle se base sur une comparaison des surfaces
        Collections.sort(liste);

        // On affiche à nouveau la liste, elle doit désormais être triée par surface
        System.out.println("Liste après le tri :");
        for(Polygone polygone : liste) {
            
            System.out.println(polygone.toString()+" / surface = "+polygone.getSurface());
        }

        // On teste ici si un objet de classe Carre est bien assignable aux type dont il hérite ou qu'il implémente
        // on utilise pour cela l'opérateur instanceof qui retourne un boolean

        // L'objet 'carre' est tout à la fois 
        // - une instance de Carre (sa propre classe)
        // - une instance de Quadrilatere (sa classe parente)
        // - une instance de Polygone (l'interface qu'il implémente via sa classe parente)
        System.out.println("Test de type de classe");
        System.out.println("carre instanceof Carre : " + (carre1 instanceof Carre));
        System.out.println("carre instanceof QuadrilatereRectangle : " + (carre1 instanceof QuadrilatereRectangle));
        System.out.println("carre instanceof Polygone : " + (carre1 instanceof Polygone));
        // la méthode isAssignableFrom est aussi utilisable, mais sur la classe et non l'objet
        System.out.println("Polygone.class.isAssignableFrom(carre.getClass()) : " + Polygone.class.isAssignableFrom(carre1.getClass()));
    }
}
