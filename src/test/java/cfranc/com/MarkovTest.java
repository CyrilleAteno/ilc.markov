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
	public void testReadFille1mot() {
		Markov m = new Markov();
		m.readFile("test1.txt");
		int expected=0;
                int actual=m.couples.size();
		assertEquals(expected,actual);
	}
        
        @Test
	public void testReadFille2mot() {
		Markov m = new Markov();
		m.readFile("test2.txt");
		int expected=1;
                int actual=m.couples.size();
		assertEquals(expected,actual);
	}
        @Test
	public void testReadFille3mot() {
		Markov m = new Markov();
		m.readFile("test3.txt");
		int expected=0;
                int actual=m.couples.size();
		assertEquals(expected,actual);
	}
        
        @Test
	public void testReadFille4mot() {
		Markov m = new Markov();
		m.readFile("test4.txt");
		int expected=3;
                int actual=m.couples.size();
		assertEquals(expected,actual);
                
	}
        @Test
	public void testGenerateText4mot() {
		Markov m = new Markov();
		m.readFile("test4.txt");
		
                Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 4);
		assertNotNull(res);
                System.out.println(res);
	}


}
