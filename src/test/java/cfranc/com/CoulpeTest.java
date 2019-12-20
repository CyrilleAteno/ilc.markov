package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

        Couple c1 = new Couple("Bonjour", "ça");
        Couple c2 = new Couple("Bonjour", "ça");
        Couple c3 = new Couple("Bonjour", "tu");
        Couple c4 = new Couple(null, "tu");
        Couple c5 = new Couple("Bonjour", null);
        Couple c6 = new Couple("Bonjour", null);
        Couple c7 = new Couple(null, "tu");

        @Test
        public void equals_objectAreEquals_True() {
            boolean expected = true;
            boolean actual = c1.equals(c1);
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_valuesNotNullAreEqual_True() {
            boolean expected = true;
            boolean actual = c1.equals(c2);
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_valuesAreNullForFirsts_True() {
            boolean expected = true;
            boolean actual = c4.equals(c7);
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_valuesAreNullForSeconds_True() {
            boolean expected = true;
            boolean actual = c5.equals(c6);
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_valueNullAndNotNullFirst_False() {
            boolean expected = false;
            boolean actual = c4.equals(c3);
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_valueNullAndNotNullSecond_False() {
            boolean expected = false;
            boolean actual = c3.equals(c5);
            assertEquals(expected, actual);
        }
}
