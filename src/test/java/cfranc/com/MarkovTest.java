package cfranc.com;

import java.util.*;
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
        
        /**
         * With only 3 work in the file readed
         * the generateText will always be those 3 words in the same order
         * so we can test if the randomElement correctly work
         */
        @Test
        public void randomElementGenericVoid(){
            Markov m = new Markov();
            m.readFile("test3.txt");
            Couple p = Markov.randomElement(m.couples.keySet());
            String res = m.generateText(p, 3);
            
            assertEquals("Il fait très", res);
        }
        
        /**
         * Test the case where the list pass in parameter is empty
         */
        @Test
        public void randomElementListVoid(){
            List<String> v = new ArrayList<String>();
            Markov m = new Markov();
            String res = m.randomElement(v);
            
            // printing...
            System.out.println("res : " + res);
            assertEquals(null, res);
        }
        
        /**
         * Test readFile with test1.txt
         * as there is only one word in test1.txt hashmap should be null
         * 
         */
        @Test
        public void readFileWithTest1(){
            Markov m = new Markov();
            m.readFile("test1.txt");
            
            assertEquals(0,m.couples.size());
        }
        
        /**
         * Test readFile with test2.txt
         * Only two words in the text file, hashmap should still be at a length of 0
         */
        @Test
        public void readFileWithTest2(){
            Markov m = new Markov();
            m.readFile("test2.txt");
            
            assertEquals(0, m.couples.size());
        }
        
        /**
         * Test readFile with test3.txt
         * Now there is 3 words inside the text file. So on, our hashmap length isn't 0 anymore but 2 Couples
         */
        @Test
        public void readFileWithTest3(){
            Markov m = new Markov();
            m.readFile("test3.txt");
            
            assertEquals(2, m.couples.size());
        }
        
        /**
         * Test readFile with test4.txt
         * 4 word in the text file --> 3 Couples
         * Size of hashmap should be 3
         */
        @Test
        public void readFileWithTest4(){
            Markov m = new Markov();
            m.readFile("test4.txt");
            
            assertEquals(3, m.couples.size());
        }
        
        /**
         * Test generateText method when there is only one couple
         */
        public void generateTextOneCouple(){
            Markov m = new Markov();
            m.readFile("cosette.txt");
            
            Couple c = new Couple("ESIREM", "ECOLE");
            // work isn't finish...
            
            
        }
        

}
