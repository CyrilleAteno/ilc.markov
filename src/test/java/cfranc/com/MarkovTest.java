package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import cfranc.com.Markov;
import cfranc.com.Couple;

public class MarkovTest {

	@Test
	public void test() throws FileNotFoundException {
		cfranc.com.Markov m = new Markov();
		m.readFile("cosette.txt");
		cfranc.com.Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}

}
