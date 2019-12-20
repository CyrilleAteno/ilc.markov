package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


/**
 * The markov class do :
 * 
 */
public class Markov {
        // Attribute
	HashMap<Couple, List<String>> couples;

        // constructor
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        /**
         * 
         * @param <E> type of the Collection
         * @param c is a generical Collection
         * @return a random element of c
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
         * 
         * @param v is a list of String
         * @return an element of the param, selected randomly
         */
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}
        
        /**
         * read a file choose by his path and "learn" the word who are inside that file
         * @param path of the file we want to read
         */
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
        
        /**
         * generate a sentencies 
         * @param p Couple of word
         * @param words number of word
         * @return a String contains : a generated sentence
         */
	public String generateText(Couple p, int words) {
            String res = p.getFirst() + " " + p.getSecond() + " ";
	    words -= 2; // soustract two because in the String res you added the two words of the couple param p
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
