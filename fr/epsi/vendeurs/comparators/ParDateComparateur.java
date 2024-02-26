package fr.epsi.vendeurs.comparators;

import java.util.Comparator;

import fr.epsi.vendeurs.Vendeur;

/*
 * Comparateur pour comparer deux objets Vendeur selon leur date de dernière vente
 */
public class ParDateComparateur implements Comparator<Vendeur>{

    @Override
    public int compare(Vendeur o1, Vendeur o2) {
        
        return o1.getDateDerniereVente().compareTo(o2.getDateDerniereVente());
    }

}
