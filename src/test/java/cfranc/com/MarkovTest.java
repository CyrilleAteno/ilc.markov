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
        // ----- Fonction readFile -----
        
        @Test
	public void readFile_FileNotNull_couplesNotEmpty() {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		
                assertNotEquals(0, m.couples.size());
	}
        
        @Test
        public void readFile_test1_couples0() {
		Markov m = new Markov();
		m.readFile("test1.txt");
		
                assertEquals(0, m.couples.size());
	}
        
        @Test
        public void readFile_test2_couples0() {
		Markov m = new Markov();
		m.readFile("test2.txt");
		
                assertEquals(0, m.couples.size());
	}
        
        @Test
        public void readFile_test3_couples1() {
		Markov m = new Markov();
		m.readFile("test3.txt");
		
                assertEquals(1, m.couples.size());
	}
        
        @Test
        public void readFile_test4_couples2() {
		Markov m = new Markov();
		m.readFile("test4.txt");
		
                assertEquals(2, m.couples.size());
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
