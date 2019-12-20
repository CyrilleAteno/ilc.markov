package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {
        Couple cp = new Couple("Hello", "World");
        Couple cp1 = new Couple("It's", "Me");
        
	@Test
	public void test() {
		//fail("Not yet implemented");
                Couple cp = new Couple("Hello", "World");
                System.out.println(cp.hashCode());
                        
	}
        
        @Test
        public void testHashCode() {
            int expected = 153375780;
            assertNotEquals(expected, cp.hashCodeEclipse());
        
        }
        
        @Test
        public void nullEquals(){
            
            boolean res = cp.equals(null);
            assertEquals(false, res);
        }
        
        

}
