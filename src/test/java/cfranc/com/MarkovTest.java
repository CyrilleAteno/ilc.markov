package cfranc.com;

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
        public void readFiletest4(){
                Markov m = new Markov();
                m.readFile("test4.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
        
        
        }
        
        @Test
        public void readFiletest1(){
            Markov m = new Markov();
            m.readFile("test1.txt");
            assertEquals(0, m.couples.size());
        
        }
        
           @Test
        public void readFiletest2(){
            Markov m = new Markov();
            m.readFile("test2.txt");
            assertEquals(0, m.couples.size());
        
        }
        
           @Test
        public void readFiletest3(){
            Markov m = new Markov();
            m.readFile("test3.txt");
            assertEquals(1, m.couples.size());
        
        }
        
       
        


}
