package cfranc.com;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MarkovTest {

	Markov markov = new Markov();

	@Test
	public void test() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}

}
