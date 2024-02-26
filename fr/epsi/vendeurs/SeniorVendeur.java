package fr.epsi.vendeurs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/*
 * Cette classe représente un vendeur "sénior" dont la commission et de 15% et non 10%
 */
public class SeniorVendeur extends Vendeur {

    // Unique constructeur qui fait simplement appel à celui de la classe parente
    public SeniorVendeur(String nom, int age, LocalDate date) {
        super(nom, age, date);
    }

    // Le seul comportement qui change par rapport à un vendeur classique est le
    // calcul de sa commission, on surcharge donc cette méthode en appliquant 15%
    @Override
    public Double calculateComission() {
        BigDecimal bd = new BigDecimal(getTotalVente() * 0.15);
        BigDecimal result = bd.setScale(2, RoundingMode.DOWN);

        return result.doubleValue();
    }

}
