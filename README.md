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
#####Test
- Fonction equals
##### Ignore
- Fonction hascode car inutilisée

### Classe Markov
#### function
##### Test
- Fonction readfile 
- Fonction generateText
- Fonction randomElement , on peut la tester sur une liste assez grande afin de voir si elle renvoit bien
	quelque chose d'aléatoire, et de vérifier qu'elle renvoit rien sur une liste vide

## Tricks & tips

- Never test auto generate code
- Never test creator (its a design problem)
- Use @Test before each testFunction !
- When you test a void function of the class Markov, then test the markov instance's state
> Markov m=new Markov();
> int actual = m.couples.size();
- You can test a function than throws an exception with the argument: expected
> @Test(expected=Exception.class)