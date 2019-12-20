package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void generateText_ResNotNull_True() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        
        @Test
        public void readFile_OneWord_CouplesEmpty()throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test1.txt");
                assertEquals(m.couples.isEmpty(),true);
                
        }
        @Test
        public void readFile_TwoWord_CouplesEmpty()throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test2.txt");
                assertEquals(m.couples.isEmpty(),true);
        }
        @Test
        public void readFile_ThreeWord_CouplesSizeEqualOne()throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test3.txt");
                assertEquals(m.couples.size(),1);
        }
        @Test
        public void readFile_MultipleSameWords_ListAssociateSup1()throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test4.txt");
                Couple key = new Couple("il","fait");
                assertEquals(m.couples.get(key).size()>1,true);
        }
        @Test(expected = Exception.class)
        public void readFile_NotFile_ExceptionNotFound()throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("fichierinexsitant.txt");
        }
        @Test
        public void generateText_3Word_TrueWithSameString() throws FileNotFoundException{
            Markov m = new Markov();
            m.readFile("test3.txt");
            Couple p = Markov.randomElement(m.couples.keySet());
            String res = m.generateText(p, 3);
            assertEquals(res,"Il fait très ");
        }
        @Test
        public void randomElement_ListEmpty_TrueForNull(){
            ArrayList l = new ArrayList();
            assertEquals(Markov.randomElement(l),null);
        }
        @Test
        public void randomElement_BigList_TrueForTwoDifferentCouple() throws FileNotFoundException{
            Markov m = new Markov();
            m.readFile("cosette.txt");
            Couple c1 = Markov.randomElement(m.couples.keySet());
            Couple c2 = Markov.randomElement(m.couples.keySet());
            assertNotEquals(c1,c2);
        }
        
        
        
        
        
}
