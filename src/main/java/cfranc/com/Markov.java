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

        /*Constructeur de Markov qui crée une HashMap faite à partir d'un
        Couple et d'une liste de String*/
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        /*Récupère un élément aléatoire dans la collection d'éléments de type 
        générique passée en paramètre*/
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;

			}
		return null;
	}

        /*Récupère une chaine de caractères aléatoire dans la liste passée en
        paramètre*/
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

        /*Lecture d'un fichier donné en paramètre pour remplir la HashMap de
        l'instance. S'il y a un mot, on le stocke dans w1. S'il y a deux mots,
        on stocke aussi le deuxième mot dans w2. S'il y a plus de 
        deux mots, on regarde les mots suivants. S'ils ne sont pas nuls, on 
        rentre dans la hashMap ces mots*/
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

        /*Génère un texte aléatoire depuis un couple passé en paramètre d'un        
        nombre de mots défini par le paramètre words*/
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
