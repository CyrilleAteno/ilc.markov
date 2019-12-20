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
init()
test des getter et setter
hashCodeEclipse() 
pas hashCode() car c'est juste un return du test de hashCodeEclipse()
equals(Object obj) car c'est une réécritur ed'un fction existante

### Classe Markov
#### function
randomElement(Collection<E> c) pas de test car la fct n'est pas utilisée
readFile(String path) pas de test sur le scanner car fct inié a java
generateText(Couple p, int words)
randomElement(List<String> v) difficile a tester ou peut dire que la fonction random a été valider par java mais on test si il n'y a pas d'out of bound

## Tricks & tips

- Never test auto generate code
- Never test creator (its a design problem)
- Use @Test before each testFunction !
- When you test a void function of the class Markov, then test the markov instance's state
> Markov m=new Markov();
> int actual = m.couples.size();
- You can test a function than throws an exception with the argument: expected
> @Test(expected=Exception.class)