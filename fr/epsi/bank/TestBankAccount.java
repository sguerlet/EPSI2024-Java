package fr.epsi.bank;

public class TestBankAccount {

    public static void main(String[] args) {
        
        // création d'un compte bvancaire avec 5% de retenue
        BankAccount compte = new BankAccount(0.95);
        afficheSolde(compte);
        // on dépose 1000€, on affiche ensuite la somme réellement déposée
        double sommeDeposee = compte.depot(1000);
        System.out.println("Somme déposée : "+sommeDeposee);
        afficheSolde(compte);
        // idem avec un autre dépôt de 100€
        double sommeDeposee2 = compte.depot(100);
        System.out.println("Somme déposée : "+sommeDeposee2);
        afficheSolde(compte);

        // pour un retrait de 200€, tout se passe correctement
        // à noter que même si la méthode retrait peut lever une exception, il n'est pas obligatoire de la traiter ici car elle hérite de RuntimeException (Exception de type unchecked)
        compte.retrait(200);
        afficheSolde(compte);

        // pour un retrait au-delà du solde, l'appel à la méthode lève bien une exception qui est traitée dans le block catch 
        try {
            compte.retrait(1200);
        } catch (BankAccountException e) {
            // ici en tant que traitemnent on ne fait rien d'autre qu'afficher un message à l'utilisateur
            System.out.println("Opération impossible : "+e.getMessage());
        }
        // on vérifie que le solde n'a pas été modifié puisque l'exception a arrêté le flow de traitement avant sa mise à jour
        afficheSolde(compte);
    }

    // méthode privée utilitaire pour afficher le solde du compte
    private static void afficheSolde(BankAccount compte) {
        System.out.println("solde du compte : " + compte.getSolde());
        
    }
}
