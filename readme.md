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
