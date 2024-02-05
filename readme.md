# Cours DEVE514 Développement Java

## Contenu
Vous trouverez ici au fur et à mesure du cours [le support](Java%20-%20les%20fondamentaux%202023-2024.pdf) ainsi que le code source des TP, documenté _a posteriori_

Pour récupérer le code et les ressources, je vous conseille de cloner ce repository avec la commande suivante

```
git clone https://github.com/sguerlet/EPSI2024-Java.git
``` 

## Cours introductif - classe _Application_ avec sa méthode _main_

La première mise en pratique consiste à comprendre comment la JVM va exécuter un programme, en sollicitant la méthode _main_ d'une classe passé en paramètre. Cette méthode particulière est donc le point d'entrée du programme.

### Classe concernée
- [fr.epsi.Application](fr/epsi/Application.java)

###  Procédure de compilation et exécution
Depuis la racine du repository, on compile le fichier source puis on exécute l'application en lui passant 2 entiers en paramètre de ligne de commande.

Notez que le compilateur cible un fichier source `.java` (et donc un chemin complet répertoire + fichier) tandis que l'interpréteur de le JVM cible un nom complet de classe (donc nom de package + nom de classe).
```
javac fr/epsi/Application.java
java fr.epsi.Application 29 13
```
Vous devriez obtenir évidemment comme résultat :

```
42
```

## TP : créer une classe avec méthode utilitaire

Cette mise en pratique consiste à créer une seconde classe, différente de celle où le programme s'exécute (contenant la méthode `main`) et qui se trouve dans un package différent.

On utilise également le principe d'encapsultaion pour "protéger" l'attribut représentant le caractère à inseerer afin d'éviter une modification hasardeuse de celui-ci et donc assurer une bonne utilisation de notre classe utilitaire.

On obtient ce comportement en fixant sa visibilité à `private` et en ne permettant son renseignement que via le constructeur de la classe.

### Classes concernées
- [fr.epsi.string.TestStringUtil](fr/epsi/string/TestStringUtil.java)
- [fr.epsi.string.util.StringUtil](fr/epsi/string/util/StringUtil.java)

###  Procédure de compilation et exécution

Puisque la classe `TestStringUtil` dépend de la classe `StringUtil`, celle-ci doit être compilée en premier. Ensuite, il suffit d'exécuter le programme en passant une chaine de caractères en paramètre de la ligne de commande

```
javac fr/epsi/string/util/StringUtil.java
javac fr/epsi/string/TestStringUtil.java
java fr.epsi.string.TestStringUtil coucou
```

qui devrait donner le résultat

```
Chaine modifiée avec '+' :c+o+u+c+o+u
Chaine modifiée avec '_' :c_o_u_c_o_u
```

## TP : Polygones - travail sur l'implémentation d'interface et héritage

Cette mise en pratique des interfaces et héritage permet de se rendre compte qu'on peut manipuler des objets comme étant des type de leur classe parente ou bien leurs classes implémentées (rappel : on ne peut hériter que d'une autre classe en Java, tandis qu'on peut implémenter plusieurs interfaces)

Le fait d'implémenter une interface peut s'apparenter à un _contrat de service_ (si ma classe implémente telle interface, alors je sais que je peut la solliciter via les méthodes définies dans cette interface)

Dans le TP, ceci est illustré par les appels directs à `getSurface` ou bien indirect (via le tri de la liste) à `compareTo` de l'interface `Comparable`.

### Classes concernées
- [fr.epsi.polygone.Polygone](fr/epsi/polygone/Polygone.java) (l'interface)
- [fr.epsi.polygone.QuadrilatereRectangle](fr/epsi/polygone/QuadrilatereRectangle.java) (la classe parente abstraite)
- [fr.epsi.polygone.Carre](fr/epsi/polygone/Carre.java)
- [fr.epsi.polygone.Rectangle](fr/epsi/polygone/Rectangle.java)
- [fr.epsi.polygone.TestPolygone](fr/epsi/polygone/TestPolygone.java)

###  Procédure de compilation et exécution

Une compilation dans l'ordre est nécessaire (sauf pour Carre et Rectangle qu'on pourrait intervertir)

```
javac fr/epsi/polygone/Polygone.java
javac fr/epsi/polygone/QuadrilatereRectangle
javac fr/epsi/polygone/Carre
javac fr/epsi/polygone/Rectangle
javac fr/epsi/polygone/TestPolygone
java fr.epsi.polygone.TestPolygone
```

le rendu sur la console est le suivant

```
Je suis un rectangle de largeur 9.0 et de longueur 4.0 / surface = 36.0
Je suis un rectangle de largeur 5.0 et de longueur 2.0 / surface = 10.0
Je suis un carré de côté 4.0 / surface = 16.0
Je suis un carré de côté 5.0 / surface = 25.0
Je suis un carré de côté 3.0 / surface = 9.0
Liste après le tri :
Je suis un carré de côté 3.0 / surface = 9.0
Je suis un rectangle de largeur 5.0 et de longueur 2.0 / surface = 10.0
Je suis un carré de côté 4.0 / surface = 16.0
Je suis un carré de côté 5.0 / surface = 25.0
Je suis un rectangle de largeur 9.0 et de longueur 4.0 / surface = 36.0
Test de type de classe
carre instanceof Carre : true
carre instanceof QuadrilatereRectangle : true
carre instanceof Polygone : true
Polygone.class.isAssignableFrom(carre.getClass()) : true
```

## TP : Principes d'encapsulation et gestion des Exceptions

Les principes d'encapsulation sont indispensables pour **protéger** le comportement de son code, soit d'une mauvaise utilisation par le développeur, soit d'une tentative de détournement d'usage par un utilisateur mal intentionné...
Le principe général consiste à n'exposer que les attribut et méthodes strictement nécessaires, et masquer le reste (considéré comme relevant du fonctionnement interne du système). On parle habituellement d'un comportement en **boîte noire**. En Java, on utilise les _modifiers_ `public` et `private` sur les attributs et méthodes de classes pour atteindre ce comportement.

L'appel de méthodes peut potentiellement générer des erreurs qui seront gérées en dehors du flux d'exécution standard (se reporter au [support du cours](Java%20-%20les%20fondamentaux%202023-2024.pdf) pour plus de détail). Une classe d'exception spécifique à notre contexte métier a été créée pour l'occasion. Le mot clef `thows` permet de déclarer qu'une méthode lève potentiellement une `Exception`, tandis que le mot clef `throw` permet de lever une instance d'`Exception` en cas d'erreur.

### Classes concernées
- [fr.epsi.bank.BankAccount](fr/epsi/bank/BankAccount.java) : la représentation objet d'un compte bancaire et de son fonctionnement
- [fr.epsi.bank.BankAccountException](fr/epsi/bank/BankAccountException.java) : l'_Exception_ représentant une opération bancaire non valide
- [fr.epsi.bank.TestBankAccount](fr/epsi/bank/TestBankAccount.java) : La classe de test

## TP : Manipulation des fichiers

En Java, la gestion des I/O de base (y compris les fichiers) se fait en bas niveau avec le package historique [java.io](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/package-summary.html) et de manière plus moderne avec les classes du package [java.nio](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/package-summary.html) et plus particulièrement [java.nio.file](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/package-summary.html) pour la gestion des fichiers.

La classe utilitaire [java.nio.file.Files](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html) contient un ensemble de méthodes statiques (utilitaires) permettant par exemple de lire le contenu d'un fichier et de le restituer sous une liste d'objets String : [Files.readAllLines](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html#readAllLines(java.nio.file.Path))

### Classes concernées
- [fr.epsi.file.CalculMoyenne](fr/epsi/file/CalculMoyenne.java) : calcule la moyenne des élèves à partir du fichier [notes.txt](resources/notes.txt)