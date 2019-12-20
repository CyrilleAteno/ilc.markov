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

	//fonction contructeur qui permet d'initialiser l'attribut de l'objet Markov
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

	//cette fonction recupère une liste de String, puis retourne un element de la liste au hasard
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

	//on donne a cette fonction un chemin de fichier.
	//on commence par créer une instance "prev" de Couple en initialisant les 2 attributs de type String par un null pour plutard affecté par les deux prémier lignes du fichier
	//ensuite, au fuir et a mesure que le fichier dont le path est donné en entré contient de mots de text, on crée de nouvelle instances de la class Couple
	//et cet nouvelle instance aura l'attribut "second" de l'instance precedemment créé comme son "first" et la ligne suivante du fichier comme sont "second"
	//a chaque fois qu'un couple existe dejà, on lui ajoute la prochaine ligne du fichier dans la liste de String lui correspondant. on crée cette liste si elle n'existe pas.
	//enfin, on pourra dire que cette fonction nous permet de créer un enchainnement des lignes du fichier en utilisant la class couple
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

	//cette fonction retourne un String de mots en commençant par le fist et le second du couple donné en paramettre
	//puis il ajoute ainsi de suite les mots en parcourant la chaine de couples qui a été fait par readFile() tout en selectionnant aleatoirement un string (mot) de la liste
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
