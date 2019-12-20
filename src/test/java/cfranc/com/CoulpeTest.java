package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void createCoupleNotNull() {
		Couple c = new Couple("C1", "C2");
		assertNotNull(c);
	}

	@Test
	public void equalsObjectNullReturnFalse() {
		Couple c = new Couple("C1", "C2");
		assertEquals(c.equals(null), false);
	}

	@Test
	public void equalsObjectIsNotNullAndNotEqualFalse() {
		Couple c = new Couple("C1", "C2");
		Couple c1 = new Couple("C3", "C4");
		assertEquals(c.equals(c1), false);
	}

	@Test
	public void equalsObjectIsNotNullAndIsEqualTrue() {
		Couple c = new Couple("C1", "C2");
		Couple c1 = new Couple("C1", "C2");
		assertEquals(c.equals(c1), true);
	}

}
