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