package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovTest {
        /*
	@Test
	public void test() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}*/

        @Test
        public void testReadFile(){
            Markov test = new Markov();
            test.readFile("1.txt");
            test.readFile("2.txt");
            test.readFile("3.txt");
            test.readFile("4.txt");
        }
}
