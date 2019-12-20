package cfranc.com;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void generate() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}
        
        @Test(expected=Exception.class)
        public void readFile_NoFile_Exception() throws FileNotFoundException{
            Markov m = new Markov();
            m.readFile("salutcestlefichier");
        }
        
        @Test
	public void readFile_OneWordInFile_CouplesIsEmpty() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test1.txt");
                assertEquals(m.couples.isEmpty(),true);
	}
        
        @Test
	public void readFile_TwoWordsInFile_CouplesIsEmpty() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test2.txt");
                assertEquals(m.couples.isEmpty(),true);
	}
        
        @Test
	public void readFile_ThreeWordsInFile_CouplesSizeIsOne() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test3.txt");
                assertEquals(m.couples.size()==1,true);
	}
        
        @Test
	public void readFile_FourWordsInFile_CouplesSizeIsOne() throws FileNotFoundException {
		Markov m = new Markov();
		m.readFile("test4.txt");
                assertEquals(m.couples.size()==2,true);
	}
        
        @Test
	public void generateText_10Words_True() throws FileNotFoundException {
		Markov m = new Markov();
                m.readFile("cosette.txt");
		Couple p = Markov.randomElement(m.couples.keySet());
		String res = m.generateText(p, 10);
                int size = res.length();
                int nbMot=0;
                for(int i = 0; i<size; i++){
                    if(res.charAt(i)==' ')
                        nbMot++;
                }
                assertEquals(nbMot,10);
	}
        
        @Test
        public void randomElement_ListEmpty_Null(){
            ArrayList l = new ArrayList();
            assertEquals(Markov.randomElement(l),null);
        }
}

