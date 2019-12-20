package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Markov {

	HashMap<Couple, List<String>> couples; // Annuaire qui associe 2 mots à une liste de mot
        /**
         * Constructeur de la classe MArkov qui initialise l'attribut couples.
         */
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}
        /**
         * Modèle permettant de sélectionner un objet aléatoire dans n'importe qu'elle type de collection
         * @param <E> le type de la collection
         * @param c la collection
         * @return l'objet sélectionné aléatoirement.
         */
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
         * Récupère à élément aléatoire d'une liste de chaine de caractère
         * @param v la liste où l'on recherche l'élement aléatoire
         * @return la chaine de cacactère aléatoirement sélectionné
         */
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}
        /**
         * Permet de lire le contenu d'un fichier texte afin de remplir l'attribut couples
         * @param path le chemin d'accès au fichier
         * @throws FileNotFoundException renvoie une erreur si le chemin d'accès est faux ou n'existe pas
         */
	public void readFile(String path) throws FileNotFoundException{
		Scanner sc;
		sc = new Scanner(new File(path));

		String w1 = null;
		String w2 = null;
		Couple prev = new Couple(w1, w2);
		if (sc.hasNext()) { // Si il y a un mot
			w1 = sc.next(); // On initialise ce mot à la première chaine de caractère
			if (sc.hasNext()) { // Si il y a un deuuxième mot
				w2 = sc.next(); // On initialise ce mot à la deuxième chaine de caractère
				prev = new Couple(w1, w2); // On créé un couple avec les deux chaine de caractères
				while (sc.hasNext()) { // Tant qu'il reste des mots dans le fichier texte
					String w3 = sc.next(); // On intialise la 3eme chaine de caratcère
					List<String> l = this.couples.get(prev); // On crée un liste qui contient la liste associé à un couple de mot
					if(l == null) { // Si la liste est vide
						l = new ArrayList<String>(); // On initialise une liste vide
						this.couples.put(prev, l); // On l'associe au couple prev
					}
					l.add(w3); // Ensuite on ajoute tous les mots qui sont associés aux même couple de mot
					Couple e = new Couple(prev.getSecond(), w3); // On créé un nouveau couple avec la chaine second et la 3eme chaine obtenu
					prev = e; // on remplace prev avec le nouveau couple créé
				}
			}
		}
		sc.close();
	}
        /**
         * Génère un texte d'une taille définie à partir d'un couple de mot
         * @param p le couple à partir duquel on génère la phrase
         * @param words Nombre de mot dans la phrase
         * @return le texte généré
         */
	public String generateText(Couple p, int words) {
		String res = p.getFirst() + " " + p.getSecond() + " ";
	    words -= 2;
	    while (words-- > 0) { // On ajoute un mot tant que qu'on a pas atteint la taille voulu
	      List<String> l = this.couples.get(p);
	      if (l == null) { // si notre liste est nulle on s'arrête
	    	  break;
	      }
	      String s = randomElement(l); // On récupère un élement random parmis la liste des mots qu'on a associé
	      res += s + " "; 
	      p = new Couple(p.getSecond(), s);
	    }

		return res;
	}
}
