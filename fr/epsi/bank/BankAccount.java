package fr.epsi.bank;

// Cette classe représente un compte bancaire, en faisant attention aux principes d'encapsulation
// c'est à dire que seules les méthodes et attributs nécessaires sont expos´´(public) et celles nécessaire au fonctionnement interne non (private)
public class BankAccount {

    // repésente le pourcentage de retenue sur chaque dépot
    // ex. : 0.95 représente une retenue de 5%
    private double pourcentage;

    // Le solde du compte, celui-ci est private pour ne pas pouvoir le manipuler directement depuis l'extérieur de la classe
    private double solde;

    // Seul constructeur exposé, il impose de renseigner un pourcentage de retenue lors de la construction du compte bancaire
    public BankAccount(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    // méthode qui permet de déposer de l'argent sur le compte, avec un calcul de retenu
    // on fait le choix de retourner la valeur rélement déposée (après retenue) pour en informer l'appelant
    public double depot(double somme) {
        // on calcule la somme à déposer en otant la retenue
        double sommeADeposer = calculRetenu(somme);
        // on ajoute cette somme au solde
        solde = solde + sommeADeposer;
        // on retourne la somme qui a été réellement déposée
        return sommeADeposer;
    }

    // méthode inter (private) pour calculer la retenue sur les dépots
    private double calculRetenu(double somme) {
        return somme * pourcentage;
    }

    // la méthode permettant de retirer une certaine somme du compte
    // sa signature indique que l'appel à cette méthode peut potentiellement lever une exception de type BankAccount Exception
    // charge à lappelant de cette méthode de traiter l'exception
    public void retrait(double somme) throws BankAccountException {
        if (somme > solde) {
            // on lève une exception contenant un message indiquant sa raison, lorsqu'on tente de prélever plus que le solde disponible
            throw new BankAccountException("Interdiction de retirer une somme supérieure au solde");
            // une fois l'exception levée, le flow d'exécution s'arrête, la suite des instructions ne seront donc pas exécutées (;ise à jour du solde)
        }
        // si on arrive ici, c'est que la somme à retirer est correcte, on peut donc la soustraire de manière sécurisée au solde
        solde = solde - somme;
    }

    // Accesseur en lecture seule au solde du compte
    public double getSolde() {
        return solde;
    }
}
