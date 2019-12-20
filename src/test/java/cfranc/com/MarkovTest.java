package cfranc.com;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void readFile_file_True() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        
        @Test
	public void readFile_1Mot_True() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test1.txt");
                int expected = 0;
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}
        
        @Test
	public void readFile_2Mot_True() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test2.txt");
                int expected = 1;
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}
        
        @Test
	public void readFile_3Mot_True() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test3.txt");
                int expected = 2;
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}
        
        @Test
	public void readFile_4Mot_True() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test4.txt");
                int expected = 3;
                int actual = m.couples.size();
                assertEquals(expected, actual);
	}       
        
        //test d'une autre fonction
        @Test
	public void randomElement_Liste1Mot_True() {
		Markov m = new Markov();
                List<String> l1 = new ArrayList<String>();
                String expected = "unMot";
                l1.add(expected);
		String actual = m.randomElement(l1);
                assertEquals(expected, actual);
	}
        
        //il est difficile de tester quelque chose d'aléatoire
        //Ici par exemple, on ne sait pas si ce sera expected1 ou expected2 qui sera choisi aléatoirement par la fonction
        //Le problème se répète pour tous les autres cas suivants
        @Test
	public void randomElement_Liste2Mot_True() {
		Markov m = new Markov();
                List<String> l2 = new ArrayList<String>();
                String expected1 = "unMot";
                String expected2 = "deuxMot";
                l2.add(expected1);
                l2.add(expected2);
		String actual = m.randomElement(l2);
                assertEquals(expected1, actual);
                assertEquals(expected2, actual);
	}

}
