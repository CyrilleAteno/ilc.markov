package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void test() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        
        @Test
        public void readFile_0word_sizeIs0() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("test0.txt");
            int expected = 0;
            int actual = m.couples.size();
            assertEquals(expected, actual);
        }
        
        @Test
        public void readFile_1word_sizeIs0() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("test1.txt");
            int expected = 0;
            int actual = m.couples.size();
            assertEquals(expected, actual);
        }
        
        @Test
        public void readFile_2words_sizeIs0() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("test2.txt");
            int expected = 0;
            int actual = m.couples.size();
            assertEquals(expected, actual);
        }
        
        @Test
        public void readFile_3words_sizeIs1() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("test3.txt");
            int expected = 1;
            int actual = m.couples.size();
            assertEquals(expected, actual);
        }
        
        @Test
        public void readFile_4words_sizeIs2() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("test4.txt");
            int expected = 2;
            int actual = m.couples.size();
            assertEquals(expected, actual);
        }
        
        @Test
        public void generateText_2words_() throws FileNotFoundException{
            Markov m = new Markov();
            m.readFile("test2.txt");
            String expected = "Il fait ";
            Couple p = new Couple("Il","fait");
            String actual = m.generateText(p, 2);
            assertEquals(expected, actual);
        }
        
/*        @Test(expected=Exception.class)
        public void randomElement_OutOfBounds_False(){
            
        }
*/
}
