package fr.epsi.vendeurs.comparators;

import java.util.Comparator;

import fr.epsi.vendeurs.Vendeur;

/*
 * Comparateur pour comparer deux objets Vendeur selon le montant total de leurs ventes
 */
public class ParVenteComparateur implements Comparator<Vendeur>{

    public int compare(Vendeur o1, Vendeur o2) {
        
        return o1.getTotalVente().compareTo(o2.getTotalVente());
    }

}
