package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void testEqualsSelfTrue() {
            Couple c0 = new Couple("0", "0");
            boolean res = c0.equals(c0);
            assertEquals(res, true);
            System.out.println(res);
	}
        
        @Test
        public void testEqualsTrue() {
            Couple c0 = new Couple("0", "0");
            Couple c0Bis = new Couple("0", "0");
            boolean res = c0.equals(c0Bis);
            assertEquals(res, true);
            System.out.println(res);
	}
        
        @Test
        public void testNonEqualsTrue() {
            Couple c0 = new Couple("0", "0");
            Couple c1 = new Couple("1", "1");
            boolean res = c0.equals(c1);
            assertEquals(res, false);
            System.out.println(res);
	}

        @Test
        public void testArgNullEqualsTrue() {
            Couple c0 = new Couple("0", null);
            Couple c1 = new Couple(null, "1");
            boolean res = c0.equals(c1);
            assertEquals(res, false);
            System.out.println(res);
	}
        
        @Test
        public void testNullEqualsTrue() {
            Couple c0 = new Couple("0", "0");
            boolean res = c0.equals(null);
            assertEquals(res, false);
            System.out.println(res);
	}
}
