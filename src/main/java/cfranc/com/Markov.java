package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Markov {
        
        //Attribut de type HaseMap
	HashMap<Couple, List<String>> couples;
        
        //Constructeur de Markov
	public Markov() {
            this.couples = new HashMap<Couple, List<String>>();
	}
            
        /*Création d'une methode de calsse qui récupère un element
        aléatoire dans une liste générique*/
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
            int n = (int) (Math.random() * c.size());
            for (E x : c)
                    if (n-- == 0) {
                            return x;

                    }
            return null;
	}
        
        //Retourn un mot aléatoire dans une liste de mot
	private String randomElement(List<String> v) {
            int n = (int) (Math.random() * v.size());
            return v.get(n);
	}
        
        //Remplie la HaseMap avec un fichier donner en parametre
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
        
        //Methode qui permet la generation de texte a partire d'un couple
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
