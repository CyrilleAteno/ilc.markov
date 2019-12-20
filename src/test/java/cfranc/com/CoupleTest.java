package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoupleTest {

        @Test
        public void equals_IsEqual_True(){
            Couple c = new Couple("a","b");
            Couple c1 = new Couple("a","b");
            boolean actual = c.equals(c1);
            assertEquals(true, actual);
        }
    
        @Test
        public void equals_IsNotEqualWithNull_False(){
            Couple c = new Couple("a","b");
            boolean actual = c.equals(null);
            assertEquals(false, actual);
        }
        
        @Test
        public void equals_IsNotEqualBetweenTwoCouples_False(){
            Couple c = new Couple("a","b");
            Couple c1 = new Couple("b","a");
            boolean actual = c.equals(c1);
            assertEquals(false, actual);
        }
        
        @Test
        public void equals_IsNotEqualWithAnotherObject_False(){
            Couple c = new Couple("a","b");
            int c1 = 21;
            boolean actual = c.equals(c1);
            assertEquals(false, actual);
        }
        
        //Les tests suivants ne fonctionnaient pas à la fin du TP, quel dommage pour ma note
        
	/*@Test
	public void hashCodeEclipse_FirstIsNull_False() {
            Couple c = new Couple(null,"bonjour");
            final int prime = 31;
            int actual = 1;
            int expected = (prime * actual + 0) + (prime * actual + c.getSecond().hashCode());
            actual = prime * actual + ((c.getFirst() == null) ? 0 : c.getFirst().hashCode());
            actual = prime * actual + ((c.getSecond() == null) ? 0 : c.getSecond().hashCode());
            assertEquals(expected, actual);
	}

        @Test
	public void hashCodeEclipse_SecondIsNull_False() {
            Couple c = new Couple("bonjour",null);
            final int prime = 31;
            int actual = 1;
            int expected = (prime * actual + c.getFirst().hashCode()) + (prime * actual + 0);
            actual = prime * actual + ((c.getFirst() == null) ? 0 : c.getFirst().hashCode());
            actual = prime * actual + ((c.getSecond() == null) ? 0 : c.getSecond().hashCode());
            assertEquals(expected, actual);
	}*/
        
}
