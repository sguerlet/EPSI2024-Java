package fr.epsi.bank;

// Classe repésentant une opération interdite sur un compte bancaire
// Pour que Java puisse la traiter comme une Exception, cette clase doit étendre java.lang.Exception ou une de ses classe deerivée (ici RuntimeException)
public class BankAccountException extends RuntimeException {

    // On propose comme unique constructeur celui prenant en paramètre un message, incitant ainsi le développeur à renseigner la cause de l'erreur
    public BankAccountException(String message) {
        super(message);
    }
}
