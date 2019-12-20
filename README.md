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
### Classe Couple
#### functions
	- On ne teste pas la fonction init(), ce n'est que de l'affectation basique
	- On peut tester à la limite la méthode equals() mais celle-ci n'est pas utilisée
	- La méthode hashCodeEclipse() peut être testée, deux couples sont censés avoir un hash différent s'ils ne sont pas égaux

### Classe Markov
#### functions
	- Il faut tester la méthode readFile(), on peut tester la taille de la liste des couples de mots correspond à ce qu'il devrait y avoir en testant sur des fichiers textes de test de tailles différentes
	- Plusieurs choses sont à tester dans la méthode generateText() :
		- le cas où le couple de départ est null ou incomplet
		- que le texte générer n'ait pas plus de mots que demandés
	- La méthode randomElement() peut être testée :
		- si la liste donnée est nulle ou vide
		- si le mot renvoyé est bien dans la liste

## Tricks & tips

- Never test auto generate code
- Never test creator (its a design problem)
- Use @Test before each testFunction !
- When you test a void function of the class Markov, then test the markov instance's state
> Markov m=new Markov();
> int actual = m.couples.size();
- You can test a function than throws an exception with the argument: expected
> @Test(expected=Exception.class)