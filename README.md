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

### Classe Couple
- On peut tester un getter et un setter �tant donn� qu'il sont identique
- Il est compliqu� de tester la fonction hashCodeEclipse
- On peut test la fonction equals �tant donn�e qu'elle renvoie un boolean et a un fonctionnement assez simple
#### functions

### Classe Markov
- On test si la cr�ation de l'objet ne renvoie pas un objet null
- On ne test pas les deux fonctions random car l'une n'est m�me pas utilis� et concernant l'autre fonction, il n'est pas vraiment utile de test la reception d'une valeur al�atoire mais on observe cependant une possibilit� d'erreur �tant donn� que l'on utilise des tailles de liste, de ce fait il existe une chance non nulle d'avoir un indice qui n'est pas comprit dans la liste (Cas ou random renvoie 1)
- Il est n�cessaire de tester notre fonction readFile �tant donn�e que l'on va ouvrir un fichier et le parcourir ce qui augmente significativement le potentiel d'erreur, il sera tr�s utile de savoir si l'on arrive � ouvrir un fichier et le parcourir.
- La fonction generateText pourra �tre tester et une attention particuli�re devra lui �tre apporter bien qu'il soit parfoit difficile de pr�voir le resultat
#### function

## Tricks & tips

- Never test auto generate code
- Never test creator (its a design problem)
- Use @Test before each testFunction !
- When you test a void function of the class Markov, then test the markov instance's state
> Markov m=new Markov();
> int actual = m.couples.size();
- You can test a function than throws an exception with the argument: expected
> @Test(expected=Exception.class)