package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {
                Couple c = new Couple("a", "b");
                Couple d = new Couple("a" ,"b");
                Couple e = new Couple("" ,"");
                @Test
                public void equals1(){
                     boolean expected = true ;
                     boolean actual = c.equals(d);
                     assertEquals(expected, actual);
        } 
                    @Test
                public void equalsnull(){
                     boolean expected = false ;
                     boolean actual = equals(e);
                     assertEquals(expected, actual);
        } 
	@Test
	public void test() {
		//fail("Not yet implemented");
                
      
	}

}
