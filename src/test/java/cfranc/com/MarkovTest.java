package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void test() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        // essai de trigger un out of bound en recrant la fct random element car pas de mock
        /*@Test
        public void testRandomElementOutofBound(){
            boolean  k = false;
            List<String> l = new ArrayList<String>();
            l.add("hello");
            l.add("world");
            try (String k = randomElement(l))
            catch(OutOfBoundException e) {k  = true};
            assertEquals("false",k);
            
        }
        
        private String randomElement(List<String> v){
		int n = (int) (1 * v.size());
		return v.get(n);
	}*/
        
        @Test
        public void testReadFilePasdeMot() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("text1.txt");
            int k = m.couples.size();
            assertEquals(0,k);
        }
        @Test
        public void testReadFilePasdeMot2() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("text2.txt");
            int k = m.couples.size();
            assertEquals(0,k);
        }
        @Test
        public void testReadFileTestCoupleAvecMot() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("text3.txt");
            List<String> k = m.couples.get(new Couple("il","fait"));
            assertEquals("tres",k.get(0));
        }
        @Test
        public void testReadFileTestCoupleAvecMot2() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("text4.txt");
            List<String> k = m.couples.get(new Couple("fait","tres"));
            assertEquals("beau",k.get(0));
        }
        @Test
        public void testGenerateText() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("text4.txt");
            String res = m.generateText(new Couple("fait","tres"), 2);
            assertEquals("fait tres ",res);
        }
        
        @Test
        public void testGenerateTextMot() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("text4.txt");
            String res = m.generateText(new Couple("fait","tres"), 3);
            assertEquals("fait tres beau ",res);
        }
        // essais de test avec l'aleatoir
        /*@Test
        public void testGenerateTextMot2() throws FileNotFoundException {
            Markov m = new Markov();
            m.readFile("text5.txt");
            String res = m.generateText(new Couple("fait","tres"), 3);
            assertEquals("fait tres beau " || "fait tres jour ",res);
        }*/
}
