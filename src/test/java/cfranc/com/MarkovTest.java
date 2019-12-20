package cfranc.com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MarkovTest {

	Markov m = new Markov();

	@Test
	public void test() {
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}

	@Test(expected = NullPointerException.class)
	public void should_return_exception_when_p_isNull() {
		m.generateText(null, 10);
	}

	@Test
	public void should_null_when_text1() {
		m.readFile("test1.txt");
		assertTrue(m.couples.size() == 0);

	}

	@Test
	public void should_null_when_text2() {
		m.readFile("test2.txt");
		assertTrue(m.couples.size() == 0);
	}

	@Test
	public void should_not_null_when_text3() {
		m.readFile("test3.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}

	@Test
	public void should_not_null_when_text4() {
		m.readFile("test4.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
}
