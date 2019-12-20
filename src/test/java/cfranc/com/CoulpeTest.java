package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	@Test
	public void creation_complet_notNull() {
		Couple couple = new Couple("un", "couple");
                assertNotNull(couple);
	}
        
        @Test
	public void setFirst_notNull_valide() {
		Couple couple = new Couple("un", "couple");
                couple.setFirst("nouveau");
                String expected = "nouveau";
                assertEquals(expected, couple.getFirst());
	}
        @Test
	public void setSecond_notNull_valide() {
		Couple couple = new Couple("un", "couple");
                couple.setSecond("duo");
                String expected = "duo";
                assertEquals(expected, couple.getSecond());
	}
        
        // Fonction Equals
        
        @Test
	public void equals_ObjObj_TRUE() {
		Couple couple = new Couple("un", "couple");
                Couple couple2 = new Couple("un", "couple");
                
                Boolean expected = true;
                assertEquals(expected, couple.equals(couple2));
	}
        
        @Test
	public void equals_ObjNull_FALSE() {
		Couple couple = new Couple("un", "couple");
                Couple couple2 = null;
                
                Boolean expected = false;
                assertEquals(expected, couple.equals(couple2));
	}
        
        @Test
	public void equals_ObjNotcouple_FALSE() {
		Couple couple = new Couple("un", "couple");
                String couple2 = new String("Pas un couple");
                
                Boolean expected = false;
                assertEquals(expected, couple.equals(couple2));
	}
        
        @Test
	public void equals_firstNull_FALSE() {
		Couple couple = new Couple("un", "couple");
                Couple couple2 = new Couple( null , "couple");
                
                Boolean expected = false;
                assertEquals(expected, couple.equals(couple2));
	}
        
        @Test
	public void equals_secondNull_FALSE() {
		Couple couple = new Couple("un", "couple");
                Couple couple2 = new Couple( "un" , null);
                
                Boolean expected = false;
                assertEquals(expected, couple.equals(couple2));
	}
}
