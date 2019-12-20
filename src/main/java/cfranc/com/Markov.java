/**
 * @Potiquet Clement
 */

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

        //Constructeur de la classe
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        /**
         * Genere un nombre aleatoire int qui sera multipliee par la taille de la collection
         * @param <E>
         * @param c
         * @return 
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
         * Genere aleatoirement un indice qui servira a recuperer la valeur de la liste a cette index
         * @param v
         * @return la string
         */
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

        /**
         * Ouvre dans un premier temps un fichier
         * Cree un objet couple
         * 
         * @param path 
         */
	public void readFile(String path) {
		Scanner sc;
		try {
                    //Ouvre le fichier qui lui a ete donne
			sc = new Scanner(new File(path));

			String w1 = null;
			String w2 = null;                        
                        //Creation d'un objet couple
			Couple prev = new Couple(w1, w2);
                        //Verifie si il y a encore un mot apres
			if (sc.hasNext()) {
                        //Si c'est le cas w1 est égale au prochain mot
				w1 = sc.next();
                        //Verifie si il y a encore un mot apres
				if (sc.hasNext()) {
                        //Si c'est le cas w1 est égale au prochain mot
					w2 = sc.next();
                        //Redefinition de l'objet avec les nouvelles valeurs en parametre
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

        /**
         * Retourne une phrase aleatoire en fonction des mots qui lui ont ete rentres en parametre via l'objet 
         * @param p
         * @param words
         * @return un STRING
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
