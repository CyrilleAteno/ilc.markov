package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovTest {

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
	public void creation__NotNull() {
		Markov m = new Markov();
                assertNotNull(m);
	}
        
        @Test
	public void readFile_FileNotNull_couplesNotEmpty() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		
                assertNotEquals(0, m.couples.size());
	}
        
        
        // ----- Fonction generateText -----
        @Test
	public void generateText_couple0_TRUE() {
            Markov m = new Markov();
            Couple couple = new Couple("un","couple");
            String expected = couple.getFirst() + " " + couple.getSecond() + " ";
            
            assertEquals(expected, m.generateText(couple, 0));
	}
}
