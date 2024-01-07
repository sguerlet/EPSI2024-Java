package fr.epsi.polygone;

// QuadrilatereRectangle est une classe abstraite, c'est à dire qu'on ne peut en créer une instance diractement, il faudra tout d'abord créer une classe qui en hérite
// QuadrilatereRectangle implémente deux interfaces:
// - Polygone, qui demande l'implémentation de getSurface
// - Comparable, qui permet de la comparer à une instance de même classe, utile par exemple si on souhaite trier une liste d'objets de ce type
public abstract class QuadrilatereRectangle implements Polygone, Comparable<QuadrilatereRectangle> {

    // On définit deux attributs largeur et longueur dont vont hériter toute classe qui étend QuadrilatereRectangle
    // le fait qu'ils soient de visibilité protected permet de protéger leur accès (uniquement depuis les classes qui en héritent)
    protected double largeur;

    protected double longueur;

    // On fournit une implémentation de la méthode getSurface, qui est imposée par l'implémentation de l'interface Polygone
    @Override
    public Double getSurface() {

        return Double.valueOf(largeur * longueur);
    }

    // On fournit une implémentation de la méthode compareTo, qui est imposée par l'implémentation de l'interface Comparable
    @Override
    public int compareTo(QuadrilatereRectangle other) {
        
        // Le choix arbitraire de comparaison se fait ici sur la surface
        return this.getSurface().compareTo(other.getSurface());
    }

    // On implémente un constructeur avec les 2 attributs, dont hériteront toutes les classes filles
    protected QuadrilatereRectangle(double largeur, double longueur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }


}