package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


public class Markov {

	HashMap<Couple, List<String>> couples;

        //Constructeur de la classe Markov permttant d'ajouter une liste de mot après le couple
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        //Sélectionne un élément aléatoire dans la collection et retourne l'élément choisit
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size()); //n : aléatoire générer
		for (E x : c)
			if (n-- == 0) {
				return x;

			}
		return null;
	}

        //Sélectionne un élément aléatoire dans la liste et retourne l'élément choisit
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

        //Méthode permettant de lire et récupérer les mots du fichier afin de créer des couples
	public void readFile(String path) {
		Scanner sc;
		try {
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
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

        //Méthode permettant la génération d'une phrase et les concatène tous
	public String generateText(Couple p, int words) {
                //Récupére le nombre de mots du couple
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
