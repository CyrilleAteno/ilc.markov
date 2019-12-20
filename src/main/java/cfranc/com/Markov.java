package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

      /*
        Cette classe permet de remplir une collection � partir d'un fichier qui lui est pass� en param�tre( fonction readFile)
        et de gen�rer un texte compos� d'un nombre de mot fourni � partir d'un point d'entr�e pass� en param�tre.
            
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

	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}
        /*
        function name : readFile
        param�tre :
            path :type string
        
        Role : permet de lire le contenu d'un fichie rpass� en param�tre gr�ce � son path
               et de cr�er des instances de la classe Couple(classe de couple de mot)
            
        */
	public void readFile(String path) {
		Scanner sc;
		try {
			sc = new Scanner(new File(path));

			String w1 = null;
			String w2 = null;
			Couple prev = new Couple(w1, w2);
			if (sc.hasNext()) { // on v�rifie si le mot suivant existe
				w1 = sc.next();// on le met dans w1
				if (sc.hasNext()) {// on v�rifie � nouveau l'existance du mot suivant
					prev = new Couple(w1, w2); // on cr�e une instance de la classe Couple � partir des deux mots trouv�s
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
			sc.close(); //fermetrure du fichier
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}
        /*
          function name : generateText
          param�tres : 
                Couple p : un couple de mot
                int words : le nombre de mots que nous souhaitons avoir dans le texte g�ner�.
          R�le :
            Elle permet de g�n�rer un texte compos� de int words � partir d'un point d'entr�e qui lui est pass� en param�tre. 
        
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
