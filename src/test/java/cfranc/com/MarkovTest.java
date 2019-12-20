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
        
        public void readTextWhenTest1IsGiven() throws FileNotFoundException{
            int expected = 0;
            String path = "test1.txt";
            Markov str = new Markov();
            str.readFile(path);
            int actual = str.couples.size();
            assertEquals(expected, actual);
            
        }
        public void readTextWhenTest4IsGiven() throws FileNotFoundException{
             int expected = 1;
             String path ="test4.txt";
             Markov str = new Markov();
             str.readFile(path);
             int actual = str.couples.size();
             assertEquals(expected, actual);
         }      
}
