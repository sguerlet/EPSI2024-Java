package fr.epsi.vendeurs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Vendeur {

    private int age;

    private String nom;

    private List<Integer> ventes = new ArrayList<>();

    private LocalDate dateDerniereVente;

    /*
     * Unique constructeur proposé par la classe, forçant à renseigner nom, age et
     * date de dernière vente
     */
    public Vendeur(String nom, int age, LocalDate date) {
        this.nom = nom;
        this.age = age;
        this.dateDerniereVente = date;
    }

    public void addVente(Integer vente) {
        ventes.add(vente);
    }

    public void setDateDerniereVente(LocalDate date) {
        this.dateDerniereVente = date;
    }

    public LocalDate getDateDerniereVente() {
        return dateDerniereVente;
    }

    public Integer getTotalVente() {
        Integer sum = 0;
        for (Integer uneVente : ventes) {
            sum += uneVente;
        }
        return sum;
    }

    /*
     * La surcharge de la méthode toString permet de faciliter son affichage dans
     * les méthode comme System.out.println par ex.
     * A noter qu'on fait appel à la méthode locale calculateComission, celle-ci
     * sera surchargée pour un vendeu "senior"
     */
    public String toString() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRANCE);
        return nom + " a vendu pour " + getTotalVente() + "€ en date du " + dateDerniereVente.format(dtf)
                + ", sa commission est de " + calculateComission() + "€";
    }

    /*
     * Le calcul de commission pour un vendeur classique consiste à appliquer 10%
     * l'usage de BigDecimal permet de gérer la précision (ici 2 digits)
     */
    public Double calculateComission() {
        BigDecimal bd = new BigDecimal(getTotalVente() * 0.10);
        BigDecimal result = bd.setScale(2, RoundingMode.DOWN);

        return result.doubleValue();
    }
}
