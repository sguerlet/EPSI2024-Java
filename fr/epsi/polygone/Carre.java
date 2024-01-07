package fr.epsi.polygone;

// Un Carre étend QuadrilatereRectangle, bénéficiant ainsi de ses méthodes et attributs
// par transitivité, il implémente implicitement les interfaces Polygone et Comparable
public class Carre extends QuadrilatereRectangle {

    // Le seul constructeur hérité de QuadrilatereRectangle étant protected, il faut explicitement fournir au moins un constructeur public
    // on choisit ici d'ajouter un consructeur qui impose la bonne construction pour un carré, c'est à dire ne fournir qu'un coté
    // un tel choix (constructeur protected pour QuadrilatereRectangle) permet d'empêcher de construire un carré ayant sa longueur différente de sa largeur !
    public Carre(double cote) {
        // on fait appel au constructeur de la classe parente (cote = largeur = longueur)
        super(cote, cote);
    }

    // La méthode toString fait partie de la classe Object dont hérite implicitement toute classe en Java
    // On peut la surcharger comme ici pour fournir une implémentation plus utile
    @Override
    public String toString() {
        
        return "Je suis un carré de côté " + largeur;
    }
}
