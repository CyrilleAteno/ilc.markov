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

    /*
        randomElement permet d'obtenir un couple aleatoire dans ua collection
        la premiere est un fonction et renvoi un collection
        la seconde est une éthode et renvoi une String
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

    private String randomElement(List<String> v) {
        int n = (int) (Math.random() * v.size());
        return v.get(n);
    }

    public void readFile(String path) throws FileNotFoundException{
        Scanner sc;
        sc = new Scanner(new File(path)); //permet de lire un fichier

        String w1 = null;
        String w2 = null;
        Couple prev = new Couple(w1, w2);
        if (sc.hasNext()) { //si il y a un mot
                w1 = sc.next(); //
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
