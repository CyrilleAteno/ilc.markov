package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void testEquals() {
            Couple c1 = new Couple("dvd","nss");
            Couple c2 = new Couple("dvd","");
            Couple c3 = new Couple("","nss");
            Couple c4 = new Couple("","");
            Couple c5 = new Couple("dvd","nss");
            
            assertTrue(c1.equals(c1)); 
            assertFalse(c1.equals(c4));
            assertTrue(c1.equals(c5));
	}
        
        @Test
        public void testHashCode(){
            Couple c1 = new Couple("dvd","nss");
            Couple c2 = new Couple("dvd","");
            Couple c3 = new Couple("","nss");
            Couple c4 = new Couple("","");
            Couple c5 = new Couple("dvd","nss");
            
            assertEquals(c1.hashCode(), c1.getFirst().hashCode() + c1.getSecond().hashCode());
            assertNotEquals(c1.hashCode(), c1.getFirst());
        }

}
