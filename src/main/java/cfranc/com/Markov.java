package cfranc.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Markov {
        //le dictionnaire de list de String à base de hashmap
        //le couple permet de definir la clé via un hashcode
        //car il override la fonction hashcode
	HashMap<Couple, List<String>> couples;

        //constructeur
	public Markov() {
		this.couples = new HashMap<Couple, List<String>>();
	}

        //renvoie un element au hasard d'une collection
	@SuppressWarnings("unused")
	static <E> E randomElement(Collection<E> c) {
		int n = (int) (Math.random() * c.size());
		for (E x : c)
			if (n-- == 0) {
				return x;
			}
                //retourne null s'il n'y a pas d'elements dans la collection
		return null;
	}

        //renvoie un element au hasard d'une collection
        //ATTENTION pas de test sur le nombre d'element de la collection
	private String randomElement(List<String> v) {
		int n = (int) (Math.random() * v.size());
		return v.get(n);
	}

        //lit un fichier
	public void readFile(String path) throws FileNotFoundException{
                //lecteur du fichier
		Scanner sc;
		sc = new Scanner(new File(path));
                
                //2 String constituant un couple
		String w1 = null;
		String w2 = null;
		Couple prev = new Couple(w1, w2);
                //s'il y a au moins un mot dans le texte
		if (sc.hasNext()) {
                        //w1 vaudra le prochain mot
			w1 = sc.next();
                        //s'il reste encore au moins un mot
			if (sc.hasNext()) {
                                //w2 vaudra le prochain mot
				w2 = sc.next();
                                //le couple sera donc un nouveau couple des 2 premiers mots 
				prev = new Couple(w1, w2);
                                //tant qu'il reste des mots
				while (sc.hasNext()) {
                                        //on recupere le prochain mot
					String w3 = sc.next();
                                        //on recupere la liste des mots qui sont associés au couple
                                        //prev, mais au debut cela vaudra null
					List<String> l = this.couples.get(prev);
                                        //si c'est null
					if(l == null) {
                                                //on crée une nouvelle liste vide
						l = new ArrayList<String>();
                                                //et on l'associe au couple trouve
						this.couples.put(prev, l);
					}
                                        //on ajoute à la liste le mot qui suit le couple
					l.add(w3);
                                        //enfin on crée un nouveau couple avec le deuxieme mot du
                                        //couple d'avant et le mot trouvé après ce dernier
					Couple e = new Couple(prev.getSecond(), w3);
                                        //on reitère l'operation pour ce nouveau couple
					prev = e;
				}
			}
		}
                //on ferme le fichier
		sc.close();
	}

        //permet de generer un texte
	public String generateText(Couple p, int words) {
                //on crée 2 mots de depart à partir du couple p
		String res = p.getFirst() + " " + p.getSecond() + " ";
                //on indique qu'on a enleve 2 mots
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
