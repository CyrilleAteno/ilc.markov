package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class MarkovTest {
	/*
	// Probleme d'encodage intelliJ
	@Test
	public void test() throws FileNotFoundException{
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
	*/

	@Test
	public void randomElementGenericVoid() throws FileNotFoundException{
		Markov m = new Markov();
		m.readFile("test3.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 3);
		assertEquals("Il fait tres ", res);
	}

	@Test
	public void readFileWithTest1() throws FileNotFoundException{
		Markov m = new Markov();
		m.readFile("test1.txt");
		assertEquals(0,m.couples.size());
	}

	@Test
	public void readFileWithTest2() throws FileNotFoundException{
		Markov m = new Markov();
		m.readFile("test2.txt");
		assertEquals(0, m.couples.size());
	}

	@Test
	public void readFileWithTest3() throws FileNotFoundException{
		Markov m = new Markov();
		m.readFile("test3.txt");
		assertEquals(1, m.couples.size());
	}

	@Test
	public void readFileWithTest4() throws FileNotFoundException{
		Markov m = new Markov();
		m.readFile("test4.txt");
		assertEquals(2, m.couples.size());
	}


}

