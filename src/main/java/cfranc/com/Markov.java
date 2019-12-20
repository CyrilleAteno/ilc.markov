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
	 * Permet de tirer un mot aléatoirement parmi une liste de chaîne de caractère donnée
	 * @param v la liste de mot
	 * @return un mot aléatoire de la liste
	 */
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

	/**
	 * Permet d'ouvrir un fichier texte, de le lire et d'associer 2 mots qui se suivent à un troisième dans le dictionnaire
	 * @param path le chemin du fichier
	 * @throws FileNotFoundException
	 */
	public void readFile(String path) throws FileNotFoundException{
		Scanner sc;
		sc = new Scanner(new File(path));

		String w1 = null;
		String w2 = null;
		Couple prev = new Couple(w1, w2);
		if (sc.hasNext()) {			//S'il y a un mot suivant i.e. si le fichier a au moins un mot
			w1 = sc.next();			//On récupère le premier mot du fichier dans w1
			if (sc.hasNext()) {		//Idem avec le 2e mot et w2
				w2 = sc.next();
				prev = new Couple(w1, w2);	//à ce point, on a 2 mots, on peut créer un couple
				while (sc.hasNext()) {			//On boucle tant qu'il existe un mot suivant
					String w3 = sc.next();		//On récupère le mot suivant dans w3
					List<String> l = this.couples.get(prev);	//On essaye de récupérer la liste de mots associés au couple précédent
					if(l == null) {								//Si la liste est null, c'est qu'il n'y en a pas en mémoire
						l = new ArrayList<String>();			//On crée alors la liste
						this.couples.put(prev, l);				//On ajoute une entrée dans le dictionnaire contenant le couple et la liste de mot
					}
					l.add(w3);									//On ajoute le mot stocké dans w3 à la liste
					Couple e = new Couple(prev.getSecond(), w3);	//On crée un nouveau couple contenant le second mot du couple précédent et le mot stocké en w3
					prev = e; //On écrase le couple précédent par celui qui vient d'être créé pour boucler de nouveau
				}
			}
		}
		sc.close(); //A la fin, on libère l'accès au fichier
	}

	/**
	 * Permet de générer du texte aléatoire d'une taille donnée, à partir d'un premier couple de mot également donné
	 * @param p le couple avec lequel commencé le texte
	 * @param words le nombre de mot que l'on veut dans notre texte
	 * @return le texte générer
	 */
	public String generateText(Couple p, int words) {
		String res = p.getFirst() + " " + p.getSecond() + " ";
		words -= 2;
		while (words-- > 0) { //Tant qu'il reste des mots à ajouter
			List<String> l = this.couples.get(p);	//On récupère les mots qui ont été trouvés après ce couple dans le texte d'entraînement
			if (l == null) {	//S'il n'y a pas de mot, on s'arrête puisque l'on ne peut plus continuer le texte.
				break;
			}
			String s = randomElement(l);	//On récupère un mot aléatoirement parmi ceux qui peuvent suivre le dernier couple de mot placé
			res += s + " "; //On ajoute ce mot au texte
			p = new Couple(p.getSecond(), s); //On met à jour le dernier couple placé dans le texte
		}

		return res;
	}
}
