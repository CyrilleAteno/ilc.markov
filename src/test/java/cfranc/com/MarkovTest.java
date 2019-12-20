package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

public class MarkovTest {

	/*@Test //Ne fonctionne pas à cause de l'encodage
	public void test() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette1.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}*/

	@Test
	public void readFile_1Mot_0Couple() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test1.txt");
		int expected = 0;
		int result = m.couples.size();
		assertEquals(expected, result);
	}

	@Test
	public void readFile_2Mot_0Couple() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test2.txt");
		int expected = 0;
		int result = m.couples.size();
		assertEquals(expected, result);
	}

	@Test
	public void readFile_3Mot_1Couple() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test3.txt");
		int expected = 1;
		int result = m.couples.size();
		assertEquals(expected, result);
	}

	@Test
	public void readFile_4Mot_2Couples() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test4.txt");
		int expected = 2;
		int result = m.couples.size();
		assertEquals(expected, result);
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		System.out.println(res);
	}

	@Test(expected=Exception.class)
	public void generateText_CoupleNull_Exception() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test4.txt");
		String res = m.generateText(null, 4);
		System.out.println(res);
	}

	@Test
	public void generateText_2Couples_3MotsMax() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test4.txt");
		String res = m.generateText(new Couple("Il", "fait"), 3);
		int result = res.split(" ").length;
		assertTrue(result <= 3);
		System.out.println(res);
	}

	@Test
	public void randomElement_ListeRemplie_OK(){
		ArrayList<String> list = new ArrayList<>();
		list.add("toto");
		list.add("tata");
		list.add("titi");
		list.add("tutu");
		String random = Markov.randomElement(list);
		assertTrue(list.contains(random));
	}

	@Test
	public void randomElement_ListeVide_Null(){
		ArrayList<String> list = new ArrayList<>();
		String random = Markov.randomElement(list);
		assertNull(random);
	}

	@Test(expected=Exception.class)
	public void randomElement_ListeNull_Exception(){
		String random = Markov.randomElement(null);
	}
}
