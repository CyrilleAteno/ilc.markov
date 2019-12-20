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

        /*Constructeur de Markov qui cr�e une HashMap faite � partir d'un
        Couple et d'une liste de String*/
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        /*R�cup�re un �l�ment al�atoire dans la collection d'�l�ments de type 
        g�n�rique pass�e en param�tre*/
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;

			}
		return null;
	}

        /*R�cup�re une chaine de caract�res al�atoire dans la liste pass�e en
        param�tre*/
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

        /*Lecture d'un fichier donn� en param�tre pour remplir la HashMap de
        l'instance. S'il y a un mot, on le stocke dans w1. S'il y a deux mots,
        on stocke aussi le deuxi�me mot dans w2. S'il y a plus de 
        deux mots, on regarde les mots suivants. S'ils ne sont pas nuls, on 
        rentre dans la hashMap ces mots*/
	public void readFile(String path) throws FileNotFoundException{
		Scanner sc;
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
	}

        /*G�n�re un texte al�atoire depuis un couple pass� en param�tre d'un        
        nombre de mots d�fini par le param�tre words*/
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
