package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {
        
        @Test
        public void equals_hasTheSameAddress()
        {
            Couple c1 = new Couple("first","second");
            Couple c2 = c1;
            boolean expected = true;
            boolean actual = c1.equals(c2);
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_isNotEqualsToNull()
        {
            Couple c1 = new Couple("first","second");
            Couple c2 = null;
            boolean expected = false;
            boolean actual = c1.equals(c2);
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_isNotEqualsToInstanceOfAnotherClass()
        {
            Couple c1 = new Couple("first","second");
            int c2 = 12;
            boolean expected = false;
            boolean actual = c1.equals(c2);
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_firstEqualsNullButNotTheOther()
        {
            Couple c1 = new Couple(null,"second");
            Couple c2 = new Couple("first","second");
            boolean expected = false;
            boolean actual = c1.equals(c2);
            assertEquals(expected, actual);
        }
        
        public void equals_firstDiferentToOtherFirst()
        {
            Couple c1 = new Couple("first","second");
            Couple c2 = new Couple("other first","second");
            boolean expected = false;
            boolean actual = c1.equals(c2);
            assertEquals(expected, actual);
        }

}
