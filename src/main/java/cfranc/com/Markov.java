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
	 * Permet de tirer un mot al�atoirement parmi une liste de cha�ne de caract�re donn�e
	 * @param v la liste de mot
	 * @return un mot al�atoire de la liste
	 */
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

	/**
	 * Permet d'ouvrir un fichier texte, de le lire et d'associer 2 mots qui se suivent � un troisi�me dans le dictionnaire
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
			w1 = sc.next();			//On r�cup�re le premier mot du fichier dans w1
			if (sc.hasNext()) {		//Idem avec le 2e mot et w2
				w2 = sc.next();
				prev = new Couple(w1, w2);	//� ce point, on a 2 mots, on peut cr�er un couple
				while (sc.hasNext()) {			//On boucle tant qu'il existe un mot suivant
					String w3 = sc.next();		//On r�cup�re le mot suivant dans w3
					List<String> l = this.couples.get(prev);	//On essaye de r�cup�rer la liste de mots associ�s au couple pr�c�dent
					if(l == null) {								//Si la liste est null, c'est qu'il n'y en a pas en m�moire
						l = new ArrayList<String>();			//On cr�e alors la liste
						this.couples.put(prev, l);				//On ajoute une entr�e dans le dictionnaire contenant le couple et la liste de mot
					}
					l.add(w3);									//On ajoute le mot stock� dans w3 � la liste
					Couple e = new Couple(prev.getSecond(), w3);	//On cr�e un nouveau couple contenant le second mot du couple pr�c�dent et le mot stock� en w3
					prev = e; //On �crase le couple pr�c�dent par celui qui vient d'�tre cr�� pour boucler de nouveau
				}
			}
		}
		sc.close(); //A la fin, on lib�re l'acc�s au fichier
	}

	/**
	 * Permet de g�n�rer du texte al�atoire d'une taille donn�e, � partir d'un premier couple de mot �galement donn�
	 * @param p le couple avec lequel commenc� le texte
	 * @param words le nombre de mot que l'on veut dans notre texte
	 * @return le texte g�n�rer
	 */
	public String generateText(Couple p, int words) {
		String res = p.getFirst() + " " + p.getSecond() + " ";
		words -= 2;
		while (words-- > 0) { //Tant qu'il reste des mots � ajouter
			List<String> l = this.couples.get(p);	//On r�cup�re les mots qui ont �t� trouv�s apr�s ce couple dans le texte d'entra�nement
			if (l == null) {	//S'il n'y a pas de mot, on s'arr�te puisque l'on ne peut plus continuer le texte.
				break;
			}
			String s = randomElement(l);	//On r�cup�re un mot al�atoirement parmi ceux qui peuvent suivre le dernier couple de mot plac�
			res += s + " "; //On ajoute ce mot au texte
			p = new Couple(p.getSecond(), s); //On met � jour le dernier couple plac� dans le texte
		}

		return res;
	}
}
