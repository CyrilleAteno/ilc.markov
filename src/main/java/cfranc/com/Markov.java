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
	// Selectionne une variable al�atoirement dans une collection de Type E � d�finir
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;
			}
		return null;
	}

	// Selectionne une chaine de caractere al�atoirement
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

	/* lit un fichier
	* @path d�finit le fichier source en utilisant l'exception de fichier non trouv�
	* */
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
				prev = new Couple(w1, w2);  //Si il y a deux mots, on les enregistres dans un couple
				while (sc.hasNext()) {
					String w3 = sc.next(); //On enregistre le mot suivant dans w3
					List<String> l = this.couples.get(prev); //On enregistre w3 dans la liste l
					if(l == null) {	// si l n'existe pas
						l = new ArrayList<String>();   // on cr�er l
						this.couples.put(prev, l);     //on cr�er l'association entre le couple et la liste
					}
					l.add(w3);   // on ajoute w3 � la liste
					Couple e = new Couple(prev.getSecond(), w3);  //on cr�er un nouveau couple avec w2 et w3
					prev = e;	//on remplace prev
				}
			}
		}
		sc.close(); // on ferme le fichier
	}


	/*
	* G�n�re du texte � partir d'un couple d'une taille words
	*/
	public String generateText(Couple p, int words) {
		String res = p.getFirst() + " " + p.getSecond() + " ";
	    words -= 2;
	    while (words-- > 0) {				//on d�cr�mente 0 et tant que words >0
	      List<String> l = this.couples.get(p);		//on r�cupere un �l�ment P
	      if (l == null) {					// Si la liste est vide on arrete
	    	  break;
	      }
	      String s = randomElement(l);      // Sinon on r�cup�re un �l�ment
	      res += s + " ";					// On l'ajoute suivis d'un espace
	      p = new Couple(p.getSecond(), s); // on cr�er un couple avec le 2eme �l�ment du couple et le mot suivant
	    }

		return res;							// Renvoie la liste de mots
	}
}
