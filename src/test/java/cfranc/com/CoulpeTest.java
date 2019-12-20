package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	
        
        @Test
	public void testHashCodeEclipse() {
            Couple couple= new Couple("valeur","text");
            int actual = couple.hashCodeEclipse();
            assertNotNull(actual);
            //assertEquals(expected,actual);
	}
        
        @Test
	public void ObjectEqualsObject() {
            Couple couple= new Couple("valeur","text");
            boolean expected = true;
            boolean actual=couple.equals(couple);       
            assertEquals(expected,actual);
	}
        @Test
	public void ObjectEqualsNull() {
            Couple couple= new Couple("valeur","text");
            boolean expected = false;
            boolean actual=couple.equals(null);       
            assertEquals(expected,actual);
	}

}
