package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovTest {
        
	@Test
	public void test() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}

        @Test
        public void testReadFile(){
            Markov test = new Markov();
            // Fichier avec 1 mot
            test.readFile("1.txt");
            assertEquals(0, test.couples.size());
            // Fichier avec 2 mots
            test.readFile("2.txt");
            assertEquals(0, test.couples.size());
            // Fichier avec 3 mots
            test.readFile("3.txt");
            assertNotEquals(0, test.couples.size());
            // Fichier avec 4 mots
            test.readFile("4.txt");
            assertNotEquals(0, test.couples.size());
        }
}
