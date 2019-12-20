package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

    String first;
    String second;
    
    String same = "Same";
    String notSame = "NotSame";
    Couple obj1 = new Couple(same,same);
    Couple obj2 = new Couple(same,same);
    Couple obj3 = new Couple(same,notSame);
    Couple obj4 = new Couple(notSame,notSame);
    
	@Test
	public void test() {
		//fail("Not yet implemented");
	}
        
        @Test
        public void equalTRUE(){
           boolean expected = true;
           boolean actual = obj1.equals(obj2);
           assertEquals(expected, actual);
        }
        
        @Test
        public void equalFALSE(){
           boolean expected = false;
           boolean actual = obj1.equals(obj4);
           assertEquals(expected, actual);
        }

}
