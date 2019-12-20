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
        Cette classe permet de remplir une collection à partir d'un fichier qui lui est passé en paramètre( fonction readFile)
        et de genérer un texte composé d'un nombre de mot fourni à partir d'un point d'entrée passé en paramètre.
            
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
        paramètre :
            path :type string
        
        Role : permet de lire le contenu d'un fichie rpassé en paramètre gràce à son path
               et de créer des instances de la classe Couple(classe de couple de mot)
            
        */
	public void readFile(String path) {
		Scanner sc;
		try {
			sc = new Scanner(new File(path));

			String w1 = null;
			String w2 = null;
			Couple prev = new Couple(w1, w2);
			if (sc.hasNext()) { // on vérifie si le mot suivant existe
				w1 = sc.next();// on le met dans w1
				if (sc.hasNext()) {// on vérifie à nouveau l'existance du mot suivant
					prev = new Couple(w1, w2); // on crée une instance de la classe Couple à partir des deux mots trouvés
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
          paramètres : 
                Couple p : un couple de mot
                int words : le nombre de mots que nous souhaitons avoir dans le texte géneré.
          Rôle :
            Elle permet de générer un texte composé de int words à partir d'un point d'entrée qui lui est passé en paramètre. 
        
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
