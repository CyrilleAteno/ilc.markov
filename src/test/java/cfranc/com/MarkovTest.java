package cfranc.com;

import static cfranc.com.Markov.randomElement;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovTest {

    HashMap<Couple, List<String>> couples;
    
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
        public void readFileTest1(){
            Markov m = new Markov();
            m.readFile("test1.txt");
            int expected = 0;
            int actual = m.couples.size();
            assertEquals(expected,actual);            
        }
        
        @Test
        public void readFileTest2(){
            Markov m = new Markov();
            m.readFile("test2.txt");
            int expected = 0;
            int actual = m.couples.size();
            assertEquals(expected,actual);            
        }
        
        @Test
        public void readFileTest3(){
            Markov m = new Markov();
            m.readFile("test3.txt");
            int expected = 1;
            int actual = m.couples.size();
            assertEquals(expected,actual);            
        }
        
        @Test
        public void readFileTest4(){
            Markov m = new Markov();
            m.readFile("test4.txt");
            int expected = 2;
            int actual = m.couples.size();
            assertEquals(expected,actual);            
        }
        
        @Test
        public void coupleTrue(){
            Markov m = new Markov();
            Couple c = new Couple("ceci","test");
            String expected = c.getFirst() + " " + c.getSecond() + " ";
            String actual = m.generateText(c, 0);            
            assertEquals(expected, actual);
        }
        
}
