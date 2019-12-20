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
	 * On déclare notre table de hashage
	 */
	HashMap<Couple, List<String>> couples;

	/**
	 * Notre constructeur créer un couple en lui attribuant une nouvelle table de hashage
	 */
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

	/**
	 * @param c Collection entrée en paramètre
	 * @param <E> Type générique, c'est à dire qu'il prendra le type des objets de la collection passé en paramètre
	 * @return null : Si aucun object de la collection n'a été renvoyé
	 * @return objet x du type de la collection : Si n - 1 = 0
	 */
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size()); // On tire une valeur random
		for (E x : c) // On parcour notre collection
			if (n-- == 0) { // Si notre valeur tirée aléatoirement est 1
				return x; // On renvoie l'objet de la collection actuel

			}
		return null; // Sinon on retourne null
	}

	/**
	 * @param v Liste de chaine de caractère
	 * @return Un objet prit aléatoirement dans la liste
	 */
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

	/**
	 * @param path Chemin d'accès du fichier à lire
	 * @throws FileNotFoundException Permet de gérer les exceptions
	 */
	public void readFile(String path) throws FileNotFoundException{
		Scanner sc;
		sc = new Scanner(new File(path)); // On lit notre fichier passé en paramètre

		String w1 = null;
		String w2 = null;
		Couple prev = new Couple(w1, w2);
		if (sc.hasNext()) { // S'il y a un mot après le mot actuel
			w1 = sc.next(); // La variable w1 prend comme valeur le mot qui vient juste après
			if (sc.hasNext()) { // S'il y a encore un mot après
				w2 = sc.next(); // On attribue ce mot à w2
				prev = new Couple(w1, w2); // On créer un couple de mots avec les 2 précédents
				while (sc.hasNext()) { // Si on arrive à en trouver un 3ème après nos 2 précédents
					String w3 = sc.next(); // On attribut ce troisième mot à w3
					List<String> l = this.couples.get(prev); // On créer une liste l et on lui attribue la valeur
					if(l == null) { // Si la liste est null
						l = new ArrayList<String>(); // On créer un tableau de String
						this.couples.put(prev, l); // On ajoute le couple de deux mot que l'on a créé à notre liste l
					}
					l.add(w3); // On ajoute enfin notre 3ème mot à la liste l
					Couple e = new Couple(prev.getSecond(), w3); // On créer enfin un couple entre le second mot de notre couple précédemment créé et notre 3ème mot
					prev = e; // On remplace notre ancien couple avec notre nouveau
				}
			}
		}
		sc.close(); // On ferme notre lecteur
	}

	/**
	 * @param p Le couple que l'on veut traiter
	 * @param words Le nombre de mot
	 * @return Le texte généré par notre fonction
	 */
	public String generateText(Couple p, int words) {
		String res = p.getFirst() + " " + p.getSecond() + " "; // On concatène notre couple dans une variable
	    words -= 2; // On décrémente de 2 notre variable words
	    while (words-- > 0) { // Tant que words - 1 est supérieur à 0
	      List<String> l = this.couples.get(p); // On attribut une liste venant de notre hashmap si on trouve notre couple passé en paramètre dans cette dennière
	      if (l == null) { // Si l'on ne trouve pas ce couple la liste est null et on sort de notre fonction
	    	  break;
	      }
	      String s = randomElement(l); // Sinon on prend un élement aléatoire de notre liste et on le stock dans une variable s
	      res += s + " "; // On ajoute ce mot à notre résultat
	      p = new Couple(p.getSecond(), s); // On créer un couple avec le second mot de notre couple passé en paramètre et notre mot aléatoire
	    }

		return res; // On renvoie notre texte généré quand il n'y a plus assez de mot afin de générer un nouveau couple.
	}
}
