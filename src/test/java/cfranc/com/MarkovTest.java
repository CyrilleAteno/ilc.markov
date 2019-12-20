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
        public void randomElement_3Words_True(){
            Markov m = new Markov();
            m.readFile("test3.txt");
            Couple p = Markov.randomElement(m.couples.keySet());
            String res = m.generateText(p, 3);
            
            assertEquals("It is raining", res);
        }
        
        //Test readFile with test1.txt. Hashmap should be null
        @Test
        public void readFile_1Word_Null(){
            Markov m = new Markov();
            m.readFile("test1.txt");
            
            assertEquals(null,m.couples.size());
        }
        
        //Test readFile with test2.txt
        @Test
        public void readFile_2Words_0(){
            Markov m = new Markov();
            m.readFile("test2.txt");
            
            assertEquals(0, m.couples.size());
        }
        
        //Test readFile with test3.txt
        @Test
        public void readFile_3Words_2Couples(){
            Markov m = new Markov();
            m.readFile("test3.txt");
            
            assertEquals(2, m.couples.size());
        }
        
        //Test readFile with test4.txt
        @Test
        public void readFile_4Words_3Couples(){
            Markov m = new Markov();
            m.readFile("test4.txt");
            
            assertEquals(3, m.couples.size());
        }
        
        @Test
        public void generateText_(){
            Markov m = new Markov();
        }
}
