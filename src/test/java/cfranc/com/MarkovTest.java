package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovTest {

	@Test
	public void test() {
            // Exemple d'utilisation du programme
		Markov m = new Markov();
                // fichier qui lui apprend a parler comme quelqu'un
		m.readFile("cosette.txt");
                // va chercher dans l'objet Markov un debut de phrase aleatoire
		Couple p = Markov.randomElement(m.couples.keySet());
                // On prend le debut de phrase aleatoire et on cree une phrase aleatoire de 10 mots a partir de ca
		String res = m.generateText(p, 10);
		assertNotNull(res);
		System.out.println(res);
	}

}
