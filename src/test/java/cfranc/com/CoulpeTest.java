package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
        public void equals_NotSameClass_False(){
            Couple c = new Couple("1","2");
            int n = 5;
            assertEquals(c.equals(n),false);
        }
        @Test
        public void equals_NullObject_False(){
            Couple c = new Couple("1","2");
            assertEquals(c.equals(null),false);
        }
        @Test
        public void equals_SelfObject_True(){
            Couple c = new Couple("1","2");
            assertEquals(c.equals(c),true);
        }
        @Test
        public void equals_SameObject_False(){
            Couple c = new Couple("1","2");
            Couple c2 = new Couple("1","2");
            assertEquals(c.equals(c2),true);
        }

}
