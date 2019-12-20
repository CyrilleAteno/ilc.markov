package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void test() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet()); //Point de départ (début de phrase)
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res); 
	}
        
        //il ne trouve pas le fichier avec chemin donné
        @Test
	public void testFileNotFound() {
		Markov m = new Markov();
		m.readFile("nonExistant.txt"); 
                int hash =  m.couples.size();
                assertNotNull(hash);
		System.out.println("File non existant\n Nombre de couple= "+hash);
	}
        
        //TEST SI le nombre de mots demandés par l'utilisateur dépasse le nombre de mots restant avant la fin du fichier
        @Test
	public void testSurplus() {
                Markov m = new Markov();
                Couple surplus = new Couple("et","il");
                String res = m.generateText(surplus, 30);
		assertNotNull(res);
		System.out.println(res);
        }

        //TEST SI le fichier donnée ne contient qu'un seul mot
        @Test
	public void test1mot() {
                Markov m = new Markov();
                m.readFile("1mot.txt");
                int hash =  m.couples.size();
                assertNotNull(hash);
		System.out.println("1MOT\n Nombre de couple= "+hash);
        }
        
        //TEST SI le fichier donnée contient uniquement 2 mots
        @Test
	public void test2mots() {
                Markov m = new Markov();
                m.readFile("2mots.txt");
                int hash =  m.couples.size();
                assertNotNull(hash);
		System.out.println("2MOTS\n Nombre de couple = "+hash);
        }
        
        //TEST SI le fichier donnée contient tout juste 3 mots
        @Test
	public void test3mots() {
                Markov m = new Markov();
                m.readFile("3mots.txt");
                int hash =  m.couples.size();
                assertNotNull(hash);
		System.out.println("3MOTS\n Nombre de couple = "+hash);
                
                Couple p = Markov.randomElement(m.couples.keySet()); //Point de départ (début de phrase)
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res); 
        }
        
}
