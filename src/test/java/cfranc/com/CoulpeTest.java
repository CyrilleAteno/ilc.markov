package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void test() {
		fail("Not yet implemented"); 
	}
        
        /**
         * Test the case where c1 equals c2 is true
         */
        @Test
        public void equalsTrue(){
            Couple c1 = new Couple("elouan","gouinguenet");
            Couple c2 = new Couple("elouan","gouinguenet");
            
            // printing...
            System.out.println("c1 : " + c1);
            System.out.println("c2 : " + c2);

            // should be true
            boolean res = c1.equals(c2);
            System.out.println("c1 equals c2 : " + res);
            assertEquals(c1, c2);
        }
        
        /**
         * Test the case where c1 is not equals to c2 (equals false)
         */
        @Test
        public void equalsFalse(){
            Couple c1 = new Couple("elouan","gouinguenet");
            Couple c2 = new Couple("ESIREM","gouinguenet");
            
            // printing...
            System.out.println("c1 : " + c1);
            System.out.println("c2 : " + c2);

            // should be false
            boolean res = c1.equals(c2);
            System.out.println("c1 equals c2 : " + res);
            assertNotEquals(c1, c2);
        }

}
