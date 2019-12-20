package cfranc.com;

public class Couple {
	//couple de 2 chaine de caractere
	private String first;
	private String second;
	
        //constructeur
	public Couple(String w1, String w2) {
		init(w1, w2);
	}
        
        //initialise la classe
	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        //getter
	public String getFirst() {
		return first;
	}
        //setter
	public void setFirst(String first) {
		this.first = first;
	}
        //getter
	public String getSecond() {
		return second;
	}
        //setter
	public void setSecond(String second) {
		this.second = second;
	}

        //retourne le hashcode du couple
	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}
        
        //le hashcode surcharg�, dependant des hashcodes
        //des chaines de caractere
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
        
        //test l'egalite d'une instance avec un aute objet
	@Override
	public boolean equals(Object obj) {
                //verifie l'egalite des objets en terme d'adresse m�moire
		if (this == obj)
			return true;
                //verifie si l'objet compar� n'est pas nul
		if (obj == null)
			return false;
                //verifie l'egalite des classes
		if (getClass() != obj.getClass())
			return false;
                //si on est arriv� l�, il n'y aura pas d'erreur sur ce cast
		Couple other = (Couple) obj;
                
                //verifie si la premi�re chaine a la m�me valeur
                //que celle de la premi�re chaine de l'objet
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
                
                //verifie si la premi�re chaine a la m�me valeur
                //que celle de la premi�re chaine de l'objet
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
                
                //si on arrive l�, c'est que tous les tests qui permettent
                //d'indiquer que les objets sont diff�rents n'ont pas �t�
                //valid�s, donc ils sont identiques
		return true;
	}

}
