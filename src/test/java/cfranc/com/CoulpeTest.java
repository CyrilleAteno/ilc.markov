package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
        
        //Test the case where c1 equals c2 is true
        @Test
        public void equals_GIVEN_WHEN_THEN_True(){
            Couple c1 = new Couple("Alexandre","BILLON");
            Couple c2 = new Couple("Alexandre","BILLON");
            
            // printing
            System.out.println("c1 = " + c1);
            System.out.println("c2 = " + c2);

            // should be true
            boolean res = c1.equals(c2);
            System.out.println("c1 equals c2 : " + res);
            assertEquals(c1, c2);
        }
        
        //Test the case where c1 is not equals to c2 (equals false)
        @Test
        public void equals_GIVEN_WHEN_THEN_False(){
            Couple c1 = new Couple("Alexandre","BILLON");
            Couple c2 = new Couple("ESIREM","Java");
            
            //printing
            System.out.println("c1 = " + c1);
            System.out.println("c2 = " + c2);

            // should be false
            boolean res = c1.equals(c2);
            System.out.println("c1 equals c2 : " + res);
            assertNotEquals(c1, c2);
        }

}
