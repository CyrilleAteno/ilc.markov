package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
        public void testGetFirst(){
            Couple c = new Couple("x","y");
            String test = c.getFirst();
            assertEquals("x",test);
        }
        @Test
        public void testGetSecond(){
            Couple c = new Couple("x","y");
            String test = c.getSecond();
            assertEquals("y",test);
        }
        @Test
        public void testSetSecond(){
            Couple c = new Couple("x","y");
            c.setSecond("a");
            String test = c.getSecond();
            assertEquals("a",test);
        }
        @Test
        public void testSetFirst(){
            Couple c = new Couple("x","y");
            c.setFirst("a");
            String test = c.getFirst();
            assertEquals("a",test);
        }
        @Test
	public void testInit() {
		Couple c = new Couple("a","b");
                c.init("e", "r");
                Couple c1 = new Couple("e","r");
                assertEquals(c,c1);
	}
        @Test
        public void testEquals1(){
            Couple c = new Couple("a","b");
            Couple c1 = new Couple("a","b");
            boolean k = c.equals(c1);
            assertEquals(true,k);
        }
        @Test
        public void testEquals2(){
            Couple c = new Couple("a","b");
            Couple c1 = new Couple("r","b");
            boolean k = c.equals(c1);
            assertEquals(false,k);
        }
        @Test
        public void testEquals3(){
            Couple c = new Couple("a","b");
            Couple c1 = new Couple("a","r");
            boolean k = c.equals(c1);
            assertEquals(false,k);
        }
        @Test
        public void testEquals4(){
            Couple c = new Couple("a","b");
            Couple c1 = new Couple("r","r");
            boolean k = c.equals(c1);
            assertEquals(false,k);
        }
        @Test
        public void testhashCodeEclipse(){
            Couple c = new Couple(null,"b");
            String s = "b";
            int h = 31;
            h = 31*31+s.hashCode();
            int h1 = c.hashCode();
            assertEquals(h,h1);
            
        }
        @Test
        public void testhashCodeEclipse2(){
            Couple c = new Couple("b",null);
            String s = "b";
            int h = 31+s.hashCode();
            h = 31*h;
            int h1 = c.hashCode();
            assertEquals(h,h1);
            
        }
        @Test
        public void testhashCodeEclipse1(){
            Couple c = new Couple("a","b");
            String s = "b";
            String s1 = "a";
            int h = 31 + s1.hashCode();
            h = h*31+s.hashCode();
            int h1 = c.hashCode();
            assertEquals(h,h1);
        }
}
