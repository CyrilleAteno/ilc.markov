package cfranc.com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoulpeTest {

	String w1 = null;
	String w2 = null;
	Couple c = new Couple(w1, w2);

	@Test
	public void should_return_defaultHashcode_when_first_and_second_isNull() {
		int expected = 961;
		int actual = c.hashCodeEclipse();
		assertEquals(expected, actual);
	}

	@Test
	public void should_return_valueHashcode_when_only_first_isNotNull() {
		w2 = null;
		w1 = "au re";
		c = new Couple(w1, w2);
		int defaultValue = 961;
		int actual = c.hashCodeEclipse();
		assertTrue((defaultValue != actual));
	}

	@Test
	public void should_return_valueHashcode_when_first_and_second_isNotNull() {
		w2 = "bonjour";
		w1 = "au revoir";
		c = new Couple(w1, w2);
		int defaultValue = 961;
		int actual = c.hashCodeEclipse();
		assertTrue((defaultValue != actual));
	}

}
