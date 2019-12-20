package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	Couple c1 = new Couple("test", "toto"),
		   c2 = new Couple("test", "toto"),
		   c3 = new Couple("test", "tata");

	@Test
	public void equals_MemeObjet_True(){
		assertTrue(c1.equals(c1));
	}

	@Test
	public void equals_Identique_True(){
		assertTrue(c1.equals(c2));
	}

	@Test
	public void equals_Null_False(){
		assertFalse(c1.equals(null));
	}

	@Test
	public void equals_ClasseDiff_False(){
		assertFalse(c1.equals("toto"));
	}

	@Test
	public void equals_Different_False(){
		assertFalse(c1.equals(c3));
	}

	@Test
	public void hashCodeEclipse_MemeObjet_Equals(){
		assertEquals(c1.hashCodeEclipse(), c1.hashCodeEclipse());
	}

	@Test
	public void hashCodeEclipse_Identique_Equals(){
		assertEquals(c1.hashCodeEclipse(), c2.hashCodeEclipse());
	}

	@Test
	public void hashCodeEclipse_Different_NotEquals(){
		assertNotEquals(c1.hashCodeEclipse(), c3.hashCodeEclipse());
	}




}
