# ilc.markov
TP NOTE 4A ILC 2019

## Questions
- Fork this github repository
- Run the project
- Comment the 2 classes
- Complete the next section : functions to be tested
- Commit your changes (commit README.md)
- Make tests (call your test functions using the rule: GIVEN_WHEN_THEN) 
- Commit your changes
- On github, make a pull request 
- that ends

## Functions to be tested
Hereafter, for each classes give function to be tested 

### Classe Coulpe
#### functions
##### int hashCodeEclipse() {}
Vérifier si 
 - si le hashcode est bien > 0

##### Note
La fonction boolean equals(Object obj){} n'est pas utilisé donc ne pas test, plutôt la supprimer


### Classe Markov
#### function
##### void readFile(String path) {}
Vérifier si : 
 - il ne trouve pas le fichier avec chemin donné -> doit afficher un message et arrêter le programme
 - le fichier donnée est vide ->  doit afficher un message demandant de remplir le fichier et arrêter le programme
 - le fichier n'est pas lisible -> doit afficher un message et arrêter le programme

##### String generateText(Couple p, int words) {}
Vérifier si
 - le nombre de mots demandés par l'utilisateur dépasse le nombre de mots restant avant la fin du fichier -> fin du programme sans erreur + affichage du résultat

## Tricks & tips

- Never test auto generate code
- Never test creator (its a design problem)
