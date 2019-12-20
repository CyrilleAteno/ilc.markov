package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void generateText_True() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        
        @Test
	public void readFile_OneWord_True() throws FileNotFoundException {
		Markov m = new Markov();
                int temp1 = m.couples.size();
		m.readFile("test1word.txt.txt");
                int temp2 = m.couples.size();

		assertEquals(temp1, temp2);
		System.out.println(temp1);
                System.out.println(temp2);
	}
        
        @Test
	public void readFile_TwoWords_True() throws FileNotFoundException {
		Markov m = new Markov();
                int temp1 = m.couples.size();
		m.readFile("test2word.txt.txt");
                int temp2 = m.couples.size();
                
                assertEquals(temp1, temp2);
		System.out.println(temp1);
                System.out.println(temp2);
	}
        
        @Test
	public void readFile_ThreeWords_True() throws FileNotFoundException {
		Markov m = new Markov();
                int temp1 = m.couples.size();
		m.readFile("test3word.txt.txt");
                int temp2 = m.couples.size();
                
                assertEquals(temp1+1, temp2);
		System.out.println(temp1);
                System.out.println(temp2);
	}
        
        @Test
	public void readFile_FourWords_True() throws FileNotFoundException {
		Markov m = new Markov();
                int temp1 = m.couples.size();
		m.readFile("test4word.txt.txt");
                int temp2 = m.couples.size();
                
                assertEquals(temp1+2, temp2);
		System.out.println(temp1);
                System.out.println(temp2);
	}
}
