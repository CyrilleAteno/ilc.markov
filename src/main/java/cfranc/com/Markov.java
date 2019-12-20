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
        
        //returns a random element from a collection of elements c
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;

			}
		return null;
	}
        
        //Selects a random element inside a list of String v passed in parameter.
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}
        
        //Reads a file passed in paramter 
	public void readFile(String path) throws FileNotFoundException{
            //scanner which reads files
            Scanner sc;
            //sc reads the file from the path "path"
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

        //generates text in res and returns it 
	public String generateText(Couple p, int words) {
            String res = p.getFirst() + " " + p.getSecond() + " ";
	    
            //words = words -2
            words -= 2;
	    while (words-- > 0) {
                //gets the couple p and stores is in l 
                List<String> l = this.couples.get(p);
                if (l == null) {
                    break;
                }
                //fetches a random element in l and adds it to res 
                String s = randomElement(l);
                res += s + " ";
                //creates a new couple, with the Couple first attribute being p.second and Couple second attributes is s 
                p = new Couple(p.getSecond(), s);
                }

		return res;
	}
}
