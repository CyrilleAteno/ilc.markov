package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void generateText_readCosettetxt_notNull() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        
        @Test
	public void readFile_noWord_couplesHaveTheSameSize() throws FileNotFoundException {
		Markov m = new Markov();
		int expected = m.couples.size();
		m.readFile("text0.txt");
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}
        
        @Test
	public void readFile_oneWord_couplesHaveTheSameSize() throws FileNotFoundException {
		Markov m = new Markov();
		int expected = m.couples.size();
		m.readFile("text1.txt");
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}
        
        @Test
	public void readFile_twoWords_couplesHaveTheSameSize() throws FileNotFoundException {
		Markov m = new Markov();
		int expected = m.couples.size();
		m.readFile("text2.txt");
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}
        
        @Test
	public void readFile_threeWords_couplesHaveoneWordMore() throws FileNotFoundException {
		Markov m = new Markov();
		int expected = m.couples.size()+1;
		m.readFile("text3.txt");
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}
        
        @Test
	public void readFile_fourWords_couplesHaveTwoWordsMore() throws FileNotFoundException {
		Markov m = new Markov();
		int expected = m.couples.size()+2;
		m.readFile("text4.txt");
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}
        
        @Test
	public void generateText_ilFait_ilfaittres() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("text3.txt");
                Couple c1 = new Couple("Il","fait");
                String expected = "Il fait tres ";
                String actual = m.generateText(c1,3);
                assertEquals(expected, actual);
	}

}
