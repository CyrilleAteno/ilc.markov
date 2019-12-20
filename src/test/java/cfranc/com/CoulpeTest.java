package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void testEquals() {
            Couple c1 = new Couple("Jean","De La Fontaine");
            Couple c2 = new Couple("Jean","");
            Couple c3 = new Couple("","De La Fontaine");
            Couple c4 = new Couple("","");
            
            assertTrue(c1.equals(c1)); //Test que le couple 1 est bien égal à c1
            assertFalse(c1.equals(c2)); //Test que le couple 1 est bien non égal à c2
            assertFalse(c1.equals(c3)); //Test que le couple 1 est bien non égal à c3   
	}

}
