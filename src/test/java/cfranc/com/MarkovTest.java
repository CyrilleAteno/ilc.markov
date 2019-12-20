package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void cerationTextTrue() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res, true);
		System.out.println(res);
	}
        
        @Test
        public void readFile1Mot() throws FileNotFoundException {
		Markov m = new Markov();
                int tailleOrignie = m.couples.size();
		m.readFile("textTest/text1.txt");
		
		assertEquals(tailleOrignie, m.couples.size());
	}
        
        @Test
        public void readFile2Mot() throws FileNotFoundException {
		Markov m = new Markov();
                int tailleOrignie = m.couples.size();
		m.readFile("textTest/text2.txt");
		
		assertEquals(tailleOrignie, m.couples.size());
	}
        
        @Test
        public void readFile3Mot() throws FileNotFoundException {
		Markov m = new Markov();
                int tailleOrignie = m.couples.size();
		m.readFile("textTest/text3.txt");
                

		
		assertEquals(tailleOrignie + 1, m.couples.size());
	}
        
        @Test
        public void readFile4Mot() throws FileNotFoundException {
		Markov m = new Markov();
                int tailleOrignie = m.couples.size();
		m.readFile("textTest/text4.txt");
		
		assertEquals(tailleOrignie + 2, m.couples.size());
	}
}
