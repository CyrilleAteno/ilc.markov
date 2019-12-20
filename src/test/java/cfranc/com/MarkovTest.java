package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MarkovTest {


	private String first = " i'm first";
	private String second = " i'm second";
	private Markov mMarkov = new Markov();


	// TODO ------------------------- LE FICHIER "COSETTE.TXT" n'arrive pas à être détecté ----------------------------------------

	@Test
	public void test() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}

	@Test
	public void GenerateText(){

		HashMap<Couple, List<String>> couples;
		


	}

}
