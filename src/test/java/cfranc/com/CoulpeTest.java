package cfranc.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoulpeTest {
        
        @Test
        public void equals_Couple1Couple1_True() {
            Couple c1 = new Couple("Test", "same");
            Boolean expected = true;
            Boolean actual = (c1.equals(c1));
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_Couple1Couple2Same_True() {
            Couple c1 = new Couple("Test", "same");
            Couple c2 = new Couple("Test", "same");
            Boolean expected = true;
            Boolean actual = (c1.equals(c2));
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_Couple1Couple2Differents_False() {
            Couple c1 = new Couple("Test", "same");
            Couple c2 = new Couple("Test", "differents");
            Boolean expected = false;
            Boolean actual = (c1.equals(c2));
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_Couple1Couple2Null_False() {
            Couple c1 = new Couple("Test", "same");
            Couple c2 = null;
            Boolean expected = false;
            Boolean actual = (c1.equals(c2));
            assertEquals(expected, actual);
        }
        
        /**
         * D'après la déclaration de la fonction, on compare le couple courant avec un objet
         * Un objet peut avoir n'importe quel type, or, à la ligne 74, on compare les types des objets
         * Puis à la ligne 76, on créer un couple par caste de l'objet
         * Cette opération est innutile en soit, car si on a besoin de créer un caste de l'objet,
         * cela veut dire que l'on aura d"ja retourner false à la ligne précédent, tout le reste de la fonction est donc innutile
         **/
        @Test
        public void equals_Couple1String2_False() {
            Couple c1 = new Couple("Test", "same");
            String s2 = "";
            Boolean expected = false;
            Boolean actual = (c1.equals(s2));
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_Couple1Int2_False() {
            Couple c1 = new Couple("Test", "same");
            Int i2 = 5;
            Boolean expected = false;
            Boolean actual = (c1.equals(i2));
            assertEquals(expected, actual);
        }
        
        @Test
        public void equals_Couple1Float2_False() {
            Couple c1 = new Couple("Test", "same");
            float f2 = 5,5;
            Boolean expected = false;
            Boolean actual = (c1.equals(f2));
            assertEquals(expected, actual);
        }

}
