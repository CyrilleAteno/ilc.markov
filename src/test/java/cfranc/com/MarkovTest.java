package cfranc.com;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import cfranc.com.Markov;
import cfranc.com.Couple;

public class MarkovTest {

	@Test
	public void test() throws FileNotFoundException {
		cfranc.com.Markov m = new Markov();
		m.readFile("cosette.txt");
		cfranc.com.Couple p = Markov.randomElement(m.couples.keySet());
		String res = "";
		if(p != null) {
			res = m.generateText(p, 10);
		}
		assertNotNull(res);
		System.out.println(res);
	}

	@Test
	public void creationIsNotNull() {
		Markov markov1 = new Markov();
		assertNotNull(markov1.couples);
	}

	@Test
	public void readFileCanRead() {
		Scanner sc;
		try {
			sc = new Scanner(new File("cosette.txt"));
			assertNotNull(sc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readFileCreateCouple() {
		Markov markov2 = new Markov();
		markov2.couples.put(new Couple("Mot1","Mot2"), new ArrayList<>());
		assertEquals(1, markov2.couples.size());
	}


	@Test
	public void generateTextCanGenerateTextWithCouple() {
		Markov markov3 = new Markov();
		Couple couple = new Couple("mot1","mot2");
		String res = couple.getFirst() + " " + couple.getSecond() + " ";
		String test = markov3.generateText(couple, 0);
		assertEquals(res, test);
	}

	@Test
	public void readFileCanRead1Word() {
		Scanner sc;
		sc = new Scanner("test1.txt");
		boolean res = false;
		if (sc.hasNext()) {
			String w1 = sc.next();
			if (w1 != null) {
				res = true;
			}
		}
		assertEquals(res, true);
	}

	@Test
	public void readFileCanRead2Word() {
		Scanner sc;
		sc = new Scanner("test2.txt");
		boolean res = false;
		if (sc.hasNext()) {
			String w1 = sc.next();
			if (sc.hasNext() && w1 != null) {
				String w2 = sc.next();
				if (w2 != null) {
					res = true;
				}
			}
		}
		assertEquals(res, true);
	}

	@Test
	public void readFileCanRead3Word() {
		Scanner sc;
		sc = new Scanner("test3.txt");
		boolean res = false;
		if (sc.hasNext()) {
			String w1 = sc.next();
			if (sc.hasNext() && w1 != null) {
				String w2 = sc.next();
				if (sc.hasNext() && w2 != null) {
					String w3 = sc.next();
					if (w3 != null) {
						res = true;
					}
				}
			}
		}
		assertEquals(res, true);
	}

	@Test
	public void readFileCanRead4Word() {
		Scanner sc;
		sc = new Scanner("test4.txt");
		boolean res = false;
		if (sc.hasNext()) {
			String w1 = sc.next();
			if (sc.hasNext() && w1 != null) {
				String w2 = sc.next();
				if (sc.hasNext() && w2 != null) {
					String w3 = sc.next();
					if (sc.hasNext() && w3 != null) {
						String w4 = sc.next();
						if (w4 != null) {
							res = true;
						}
					}
				}
			}
		}
		assertEquals(res, true);
	}
}
