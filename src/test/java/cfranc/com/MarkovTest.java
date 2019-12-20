package cfranc.com;

import java.util.ArrayList;
import java.util.List;
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
        public void randomElementVoid(){
            List<String> l = new ArrayList<String>();
            Markov m = new Markov();
            String res = m.randomElement(l);
        }
        
         @Test
        public void readtext1(){
            Markov m = new Markov();
            m.readFile("text1.txt");
             assertEquals(0, m.couples.size());
           
        }
           @Test
        public void readtext2(){
            Markov m = new Markov();
            m.readFile("text2.txt");
             assertEquals(0, m.couples.size());
           
        }
           @Test
        public void readtext3(){
            Markov m = new Markov();
            m.readFile("text3.txt");
             assertEquals(2, m.couples.size());
           
        }
        
           @Test
        public void readtext4(){
            Markov m = new Markov();
            m.readFile("text4.txt");
             assertEquals(3, m.couples.size());
           
        }

}
