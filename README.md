# ilc.markov
TP NOTE 4A ILC 2019

## Questions
v- Fork this github repository
v- Run the project
v- Comment the 2 classes
v- Complete the next section : functions to be tested
v- Commit your changes (commit README.md)
- Make tests (call your test functions using the rule: GIVEN_WHEN_THEN) 
- Commit your changes
- On github, make a pull request 
- that ends

## Functions to be tested
Hereafter, for each classes give function to be tested 

### Classe Couple
#### functions
public Couple(String w1, String w2)
int hashCodeEclipse()
public boolean equals(Object obj)

### Classe Markov
#### functions
public Markov()
static <E> E randomElement(Collection<E> c)
private String randomElement(List<String> v)
public void readFile(String path) throws FileNotFoundException
private String randomElement(List<String> v)

## Tricks & tips

- Never test auto generate code
- Never test creator (its a design problem)
- Use @Test before each testFunction !
- When you test a void function of the class Markov, then test the markov instance's state
> Markov m=new Markov();
> int actual = m.couples.size();
- You can test a function than throws an exception with the argument: expected
> @Test(expected=Exception.class)