package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Class Markov qui fait l'encodage de markov en lui donnant un point d'entré
 * dans notre collection et le nombre de mot que l'on souhaite
 * 
 * @author cyrille
 *
 */
public class Markov {

	HashMap<Couple, List<String>> couples;

	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;

			}
		return null;
	}

	/**
	 * Fonction randomElement qui prend en paramètre un list de String et qui nous
	 * retourne un élément au hasard permet de chercher un debut de phrase
	 * 
	 * @param v
	 * @return
	 */
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

	/**
	 * fonction readFile qui prend en paramètre un nom de fichier (son chemin) puis
	 * le lit ligne par ligne en prenant soins de mettre chaque couple de mot dans
	 * un object prev de type couple et s'il y'a plus de deux mots, ajoutent les
	 * autres dans une object de type List avant de l'ajouter dans l'HashMap couples
	 * 
	 * @param path
	 */

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
						if (l == null) {
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

	/**
	 * Fonction qui genere un texte (un nombre de mot => word) à partir d'un objet
	 * Couple
	 * 
	 * @param p
	 * @param words
	 * @return texte générer
	 */

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
