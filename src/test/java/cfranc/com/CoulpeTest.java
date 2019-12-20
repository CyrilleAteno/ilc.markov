package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		// ici on teste seulement la fonction hashCode
		Couple aObject = new Couple("alors", "comment");
		Couple bObject = new Couple("alors", "comment");
		Couple cObject = new Couple("redire", "chose");

		assertTrue(aObject.hashCode() == bObject.hashCode()); //true car les deux objets sont les meme
		assertFalse(aObject.hashCode() == cObject.hashCode()); //doit etre false car les deux objets sont differents

	}

}
