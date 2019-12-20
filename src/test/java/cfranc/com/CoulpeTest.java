package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {
    
    Couple c1 = new Couple("Bonjour","Bonsoir");
    Couple c2 = new Couple("Bonjour", "Bonsoir");

	@Test
	public void equals_this_obj() 
        {
            boolean expected = true;
            boolean actual = c1.equals(c2);
            assertEquals(expected,actual);
	}
        


}
