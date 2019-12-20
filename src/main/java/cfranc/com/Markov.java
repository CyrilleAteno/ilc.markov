package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Markov {

        //Attribut
	HashMap<Couple, List<String>> couples;

        //Constructeur de la classe Markov
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        //permet de trouver un élément aléatoire
        //c : une collection
        //retourne E : une collection
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;

			}
		return null;
	}

        //Permet de retourner un mot aléatoire contenu dans la liste
        //v : une liste de chaine de caractère
        //retourn une chaine de caractère
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

        //permet de lire le fichier et stocker les chaines de caractères du fichier
        //path : String, le chemin du fichier
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

        //Permet de générer un texte en fonction du couple et d'un mot passés en paramètre 
        //p : un couple
        //words : un entier
        //Retourne une chaine de caractère
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
