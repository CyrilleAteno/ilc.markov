package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void identEqualsTrue(){
		Couple expected = new Couple("Bonjour","�");
		Couple value = new Couple("Bonjour","�");
		assertEquals(expected, value);
	}

	@Test
	public void notIdentEqualsFalse(){
		Couple expected = new Couple("Bonjour","�");
		Couple value = new Couple("tata","toto");
		assertNotEquals(expected, value);
	}

}

