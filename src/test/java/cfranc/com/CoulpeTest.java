package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void equals_StringObject_False() {
		Couple c = new Couple("hi","hj");
                assertEquals(c.equals("f"),false);
	}
        
        @Test
        public void equals_CoupleObject_True() {
		Couple c = new Couple("hi","hj");
                assertEquals(c.equals(c),true);
	}
}
