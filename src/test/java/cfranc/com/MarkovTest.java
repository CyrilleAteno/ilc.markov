package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void generateText_afterFileCosetteRead_textReturnedNotNull() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        
        @Test
        public void readFile_0word_sizeCoupleEquals0() throws FileNotFoundException {
                Markov m = new Markov();
                m.readFile("0word.txt");
                int expected = 0;
                int actual = m.couples.size();
                assertEquals(expected, actual);
        }
        
        @Test
        public void readFile_1word_sizeCoupleEquals0() throws FileNotFoundException {
                Markov m = new Markov();
                m.readFile("1word.txt");
                int expected = 0;
                int actual = m.couples.size();
                assertEquals(expected, actual);
        }
        
        @Test
        public void readFile_2words_sizeCoupleEquals0() throws FileNotFoundException {
                Markov m = new Markov();
                m.readFile("2words.txt");
                int expected = 0;
                int actual = m.couples.size();
                assertEquals(expected, actual);
        }
        
        @Test
        public void readFile_3words_sizeCoupleEquals1() throws FileNotFoundException {
                Markov m = new Markov();
                m.readFile("3words.txt");
                int expected = 1;
                int actual = m.couples.size();
                assertEquals(expected, actual);
        }
        
        @Test
        public void readFile_3wordsRepeted_sizeListFirstCoupleEquals2() throws FileNotFoundException {
                Markov m = new Markov();
                m.readFile("3words_repeted.txt");
                int expected = 2;
                int actual = m.couples.get(new Couple("Il", "fait")).size();
                assertEquals(expected, actual);
        }
        
        @Test
        public void generateText_3words_IlFaitTres() throws FileNotFoundException {
                Markov m = new Markov();
                m.readFile("3words.txt");
                String expected = "Il fait tres ";
                Couple p = Markov.randomElement(m.couples.keySet());
		String actual = m.generateText(p, 3);
                assertEquals(expected, actual);
        }
}
