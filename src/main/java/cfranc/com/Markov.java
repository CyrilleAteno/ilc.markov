package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import cfranc.com.Couple;

public class Markov {

	/**
	 * On d�clare notre table de hashage
	 */
	HashMap<Couple, List<String>> couples;

	/**
	 * Notre constructeur cr�er un couple en lui attribuant une nouvelle table de hashage
	 */
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

	/**
	 * @param c Collection entr�e en param�tre
	 * @param <E> Type g�n�rique, c'est � dire qu'il prendra le type des objets de la collection pass� en param�tre
	 * @return null : Si aucun object de la collection n'a �t� renvoy�
	 * @return objet x du type de la collection : Si n - 1 = 0
	 */
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size()); // On tire une valeur random
		for (E x : c) // On parcour notre collection
			if (n-- == 0) { // Si notre valeur tir�e al�atoirement est 1
				return x; // On renvoie l'objet de la collection actuel

			}
		return null; // Sinon on retourne null
	}

	/**
	 * @param v Liste de chaine de caract�re
	 * @return Un objet prit al�atoirement dans la liste
	 */
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

	/**
	 * @param path Chemin d'acc�s du fichier � lire
	 * @throws FileNotFoundException Permet de g�rer les exceptions
	 */
	public void readFile(String path) throws FileNotFoundException{
		Scanner sc;
		sc = new Scanner(new File(path)); // On lit notre fichier pass� en param�tre

		String w1 = null;
		String w2 = null;
		Couple prev = new Couple(w1, w2);
		if (sc.hasNext()) { // S'il y a un mot apr�s le mot actuel
			w1 = sc.next(); // La variable w1 prend comme valeur le mot qui vient juste apr�s
			if (sc.hasNext()) { // S'il y a encore un mot apr�s
				w2 = sc.next(); // On attribue ce mot � w2
				prev = new Couple(w1, w2); // On cr�er un couple de mots avec les 2 pr�c�dents
				while (sc.hasNext()) { // Si on arrive � en trouver un 3�me apr�s nos 2 pr�c�dents
					String w3 = sc.next(); // On attribut ce troisi�me mot � w3
					List<String> l = this.couples.get(prev); // On cr�er une liste l et on lui attribue la valeur
					if(l == null) { // Si la liste est null
						l = new ArrayList<String>(); // On cr�er un tableau de String
						this.couples.put(prev, l); // On ajoute le couple de deux mot que l'on a cr�� � notre liste l
					}
					l.add(w3); // On ajoute enfin notre 3�me mot � la liste l
					Couple e = new Couple(prev.getSecond(), w3); // On cr�er enfin un couple entre le second mot de notre couple pr�c�demment cr�� et notre 3�me mot
					prev = e; // On remplace notre ancien couple avec notre nouveau
				}
			}
		}
		sc.close(); // On ferme notre lecteur
	}

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
