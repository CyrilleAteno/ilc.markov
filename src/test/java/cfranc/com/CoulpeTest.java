package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void identEqualsTrue(){
		Couple expected = new Couple("Bonjour","à");
		Couple value = new Couple("Bonjour","à");
		assertEquals(expected, value);
	}

	@Test
	public void notIdentEqualsFalse(){
		Couple expected = new Couple("Bonjour","à");
		Couple value = new Couple("tata","toto");
		assertNotEquals(expected, value);
	}

}

