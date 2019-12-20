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
            
            assertEquals("Il fait très", res);
        }
        
        //Test readFile with test1.txt. Hashmap should be null
        @Test
        public void readFile_test1_Null(){
            Markov m = new Markov();
            m.readFile("test1.txt");
            
            assertEquals(0,m.couples.size());
        }
        
        //Test readFile with test2.txt Hashmap's length should be 1
        @Test
        public void readFile_test2_0(){
            Markov m = new Markov();
            m.readFile("test2.txt");
            
            assertEquals(1, m.couples.size());
        }
        
        //Test readFile with test3.txt
        @Test
        public void readFile_test3_2Couples(){
            Markov m = new Markov();
            m.readFile("test3.txt");
            
            assertEquals(2, m.couples.size());
        }
        
        //Test readFile with test4.txt
        @Test
        public void readFile_test4_3Couples(){
            Markov m = new Markov();
            m.readFile("test4.txt");
            
            assertEquals(3, m.couples.size());
        }
        
        @Test
        public void generateText_1Couple(){
            Markov m = new Markov();
            m.readFile("cosette.txt");
            
            Couple c = new Couple("Java", "Tests");
            String res = m.generateText(c, 2);
            
            
            
        }
}
