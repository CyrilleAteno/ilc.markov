package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Markov {

	HashMap<Couple, List<String>> couples;

        //constructeur de la classe 
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        //cette fct retourne un élément aléatoire dans un collection donnée en paramètre
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;

			}
		return null;
	}
        //retourne un String choisit aléatoirement dans un liste fournit en paramètre
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}
        //lit un fichier et créer des groupe de String tel que :
        // mot1 et mot2 avec mot 3 , mot2 et mot 3 avec mot 4 jusqu'a ce que le fichier soit lu en entier 
        //ensuite les couples de mots sont rentrés dans une liste 
        // la fct permet de détecter si un mot éxiste déja  , si ce n'est pas le cas alors elle l'ajoute a la liste
	public void readFile(String path) throws FileNotFoundException{
		Scanner sc;
		sc = new Scanner(new File(path));

		String w1 = null;
		String w2 = null;
		Couple prev = new Couple(w1, w2);
		if (sc.hasNext()) {
			w1 = sc.next();
			if (sc.hasNext()) {
				w2 = sc.next();
				prev = new Couple(w1, w2);
				while (sc.hasNext()) {
					String w3 = sc.next();
					List<String> l = this.couples.get(prev);
					if(l == null) {
						l = new ArrayList<String>();
						this.couples.put(prev, l);
					}
					l.add(w3);
					Couple e = new Couple(prev.getSecond(), w3);
					prev = e;
				}
			}
		}
		sc.close();
	}
        
        // permet de générer un nombre de mots aléatoire apres avoir fournit un couple de mot , la fct retourne une chaine de caratère avec le nombre de mot voulu
        // tant que le nb de mot a avoir n'est pas atteint la fct prends le couple de mot et un mot aléatoire qui est en référence avec le couple choisit
        // si il n'y a pas de mot en rapport avec le couple de mot la boucle s'arrête
	public String generateText(Couple p, int words) {
		String res = p.getFirst() + " " + p.getSecond() + " ";
	    words -= 2;
	    while (words-- > 0) {
	      List<String> l = this.couples.get(p);
	      if (l == null) {
	    	  break;
	      }
	      String s = randomElement(l);
	      res += s + " ";
	      p = new Couple(p.getSecond(), s);
	    }

		return res;
	}
}
