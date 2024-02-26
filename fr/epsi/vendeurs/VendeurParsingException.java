package fr.epsi.vendeurs;

/*
 * Une Exception qui représente une erreur lors du parsing d'une ligne du fichier
 */
public class VendeurParsingException extends Exception {

    // On propose uniquement le constructeur permettant de renseigner un message
    // (et donc de cette manière on incite le développeur à le renseigner)
    public VendeurParsingException(String msg) {
        super(msg);
    }
}
