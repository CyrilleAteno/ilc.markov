package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

       private String first = null;
	private String second = null;
	private Couple mCouple = new Couple( first, second);



	// cas où les deux éléments sont nuls
	@Test
	public void hashCodeEclipseTestNuls(){
		int expected = 31 * 31;
		int actual = mCouple.hashCodeEclipse();
		assertEquals(expected, actual);

	}
        //Cas où un seul élément est nul
	@Test
	public void hashCodeEclipseTestUnSeulNonNul(){

		
		mCouple.setSecond("Je suis Second");
		int expected = 31 + mCouple.getSecond().hashCode();
		expected = expected * 31;
		int actual = mCouple.hashCodeEclipse();
		assertEquals(expected, actual);
}

	//cas où aucun  élément n'est nul
	@Test
	public void hashCodeEclipseTestNonNuls(){

		mCouple.setFirst("Je suis first");
		mCouple.setSecond("Je suis second");
		int expected = 31 + mCouple.getFirst().hashCode();
		expected = expected * 31 + mCouple.getSecond().hashCode();

		int actual = mCouple.hashCodeEclipse();
		assertEquals(expected, actual);

	}


	
}
