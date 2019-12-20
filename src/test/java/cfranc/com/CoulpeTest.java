package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void equals_SameObject_True() {
		Couple c0 = new Couple("un", "deux");
                boolean res = c0.equals(c0);
                assertEquals(res, true);
		System.out.println(res);
	}
        
        @Test
	public void equals_NullFirst_False() {
		Couple c0 = new Couple(null, "deux");
                Couple c1 = new Couple("un", "quatre");
                boolean res = c1.equals(c0);
                assertEquals(res, false);
		System.out.println(res);
	}
        
        @Test
	public void equals_SameValues_True() {
		Couple c0 = new Couple("un", "deux");
                Couple c1 = new Couple("un", "deux");
                boolean res = c1.equals(c0);
                assertEquals(res, true);
		System.out.println(res);
	}
        
        @Test
	public void equals_DifferentClass_False() {
		int a = 5;
                Couple c1 = new Couple("un", "deux");
                boolean res = c1.equals(a);
                assertEquals(res, false);
		System.out.println(res);
	}
        
        @Test
	public void equals_DifferentCouple_False() {
		Couple c0 = new Couple("trois", "quatre");
                Couple c1 = new Couple("un", "deux");
                boolean res = c1.equals(c0);
                assertEquals(res, false);
		System.out.println(res);
	}

}
