package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void equalsTestWhenObjEquals() {
            fail("Not yet implemented");
            //test equals
            String w1 = "hello";
            String w2 ="World";
            Couple c1 = new Couple(w1, w2);
            Couple c2 = new Couple(w1, w2);
            boolean expected = true;
            boolean actual = c1.equals(c2);
            assertEquals(expected, actual);
	}

}
