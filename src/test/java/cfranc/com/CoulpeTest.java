package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {

	private String first = null;
	private String second = null;
	private Couple mCouple = new Couple( first, second);



	//les deux éléments sont null
	@Test
	public void hashCodeEclipseTest_All_NULL(){

		int expected = 31 * 31;
		int actual = mCouple.hashCodeEclipse();
		assertEquals(expected, actual);

	}

	//Aucun élément n'est null
	@Test
	public void hashCodeEclipseTest_Return_All_Not_NULL(){

		mCouple.setFirst("Je suis first");
		mCouple.setSecond("Je suis second");
		int expected = 31 + mCouple.getFirst().hashCode();
		expected = expected * 31 + mCouple.getSecond().hashCode();

		int actual = mCouple.hashCodeEclipse();
		assertEquals(expected, actual);

	}

	//Un seul élément est null
	@Test
	public void hashCodeEclipseTest_Return_One_Null(){

		//result = prime * result + ((first == null) ? 0 : first.hashCode());
		//result = prime * result + ((second == null) ? 0 : second.hashCode());
		mCouple.setFirst("Je suis first");
		int expected = 31 + mCouple.getFirst().hashCode();
		expected = expected * 31;
		int actual = mCouple.hashCodeEclipse();
		assertEquals(expected, actual);

	}

}
