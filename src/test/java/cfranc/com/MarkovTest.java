package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovTest {
    
    Couple c1 = new Couple("Bonjour","Bonsoir");
    Couple c2 = new Couple("Bonjour", "Bonsoir");
    Couple c3 = new Couple("Au revoir", "Bonnes vacances");
    int w = 10;
    //oui 541654651
    
	@Test
	public void test() {
            // Exemple d'utilisation du programme
		Markov m = new Markov();
                // fichier qui lui apprend a parler comme quelqu'un
		m.readFile("cosette.txt");
                // va chercher dans l'objet Markov un debut de phrase aleatoire
		Couple p = Markov.randomElement(m.couples.keySet());
                // On prend le debut de phrase aleatoire et on cree une phrase aleatoire de 10 mots a partir de ca
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        
        @Test
        public void readFile()
        {
            // si il y a un mot on stock ce mot et on fait un deuxieme if
            // si il y a pas de mot apres le premier mot on close
            // si il y a un mot on cree un couple
            // si il y a un troisieme, on entre dans le while
            // si il 'y a jamais eu de mots associe a ce couple la 
            // on rajoute le mot comme compatible, on ajoute le troisieme comme mot qui suit les deux premiers
            // hashmap ou on cherche tout les troiième mot qui peuvent aller avec un couple de mot
            
            // 4 fichiers pour tester
        }
        

}
