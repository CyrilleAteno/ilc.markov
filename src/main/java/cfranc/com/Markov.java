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

        //Constructeur
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        //Permet de choisir un élément au hasard dans la collection passée en paramètre
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;

			}
		return null;
	}

        //Choisis un mot au hasard parmi la liste en paramètre
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}
        
        //Permet de générer des couples à partir d'un fichier
	public void readFile(String path) throws FileNotFoundException{
		Scanner sc;
		sc = new Scanner(new File(path));

		String w1 = null;
		String w2 = null;
		Couple prev = new Couple(w1, w2);
		//Si le fichier n'est pas vide
                if (sc.hasNext()) {
			w1 = sc.next();
                        //Si le fichier a plus d'un mot
			if (sc.hasNext()) {
				w2 = sc.next();
				prev = new Couple(w1, w2);
				//Tant qu'il y a au moins un mot pas encore lu
                                while (sc.hasNext()) {
					String w3 = sc.next();
					//Liste des couples
                                        List<String> l = this.couples.get(prev);
					//Cette liste est vide au début donc on l'initialise
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

        //Permet de générer un nombre words de mots à partir d'un couple
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
