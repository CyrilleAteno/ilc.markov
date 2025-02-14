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

}
