package fr.epsi.polygone;

// Un Rectangle étend QuadrilatereRectangle, bénéficiant ainsi de ses méthodes et attributs
// par transitivité, il implémente implicitement les interfaces Polygone et Comparable
public class Rectangle extends QuadrilatereRectangle {
    
    // Le seul constructeur hérité de QuadrilatereRectangle étant protected, il faut explicitement fournir au moins un constructeur public
    // on fait ici simplement un appel au constructeur parent en reprenant les paramètres
    public Rectangle(double longueur, double largeur) {
        super(longueur, largeur);
    }

    // La méthode toString fait partie de la classe Object dont hérite implicitement toute classe en Java
    // On peut la surcharger comme ici pour fournir une implémentation plus utile
    @Override
    public String toString() {
        
        return String.format("Je suis un rectangle de largeur %.1f et de longueur %.1f",largeur,longueur);
    }
}
