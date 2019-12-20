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

    - Couple.equals() avec :
            * x.equals(x) ;
            * x.equals(y) avec y != x ;
            * x.equals(y) avec y = x ;
            * obj = this (couple) ;
            * obj != this (couple) ;
            * obj == null ;
            * obj != null ;
            * getClass() == obj.getClass() ;
            * getClass() != obj.getClass() ;
            * this.first ==  null ; 
            * this.first !=  null ; 
            * other.first == null ; 
            * other.first != null ;
            * this.second ==  null ; 
            * this.second !=  null ; 
            * other.second == null ; 
            * other.second != null ; 
    - Couple.hashCodeEclipse() avec :
            * first = null // second = null ;
            * first = non null // second = null ;
            * first = null // second = non null ;
            * first = non null // second = non null ;
    - Couple.hashCode() avec :
            * first = null // second = null ;
            * first = non null // second = null ;
            * first = null // second = non null ;
            * first = non null // second = non null ;

### Classe Markov
#### function

    - Markov.readFile() avec :
            * path inexistant ;
            * path valide ;
            * fichier vide ;
            * fichier contenant du texte ;
    - Markov.generateText() :
            * words = 0 ;
            * couple vide ;

## Tricks & tips

- Never test auto generate code
- Never test creator (its a design problem)
