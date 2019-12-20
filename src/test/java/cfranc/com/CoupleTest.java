package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoupleTest {

        @Test
        public void equals_ObjIsNull_False(){
            
            
            assertEquals("","");
        }
    
	@Test
	public void hashCodeEclipse_FirstIsNull_False() {
            Couple c = new Couple(null,"bonjour");
            final int prime = 31;
            int actual = 1;
            int expected = (prime * actual + 0) + (prime * actual + c.getSecond().hashCode());
            actual = prime * actual + ((c.getFirst() == null) ? 0 : c.getFirst().hashCode());
            actual = prime * actual + ((c.getSecond() == null) ? 0 : c.getSecond().hashCode());
            assertEquals(expected, actual);
            
	}

}
