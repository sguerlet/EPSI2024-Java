package fr.epsi.polygone;

// Polygone n'est pas une classe comme on réalisé jusqu'à présent mais bien une interface
// Une interface permet de définir une ou plusieurs méthodes et leur signature (type de retour, nom et paramètres)
// Les classes qui implémentent une ou plusieurs interfaces doivent implémenter leurs méthodes (équivalent à un "contrat de service")
public interface Polygone {
    
    // méthode qui impose à toute classe qui implémente Polygone 
    // de fournir une implémentation qui calcule sa propre surface
    public Double getSurface();
}
