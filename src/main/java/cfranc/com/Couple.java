package cfranc.com;

//Classe

public class Couple {
	
	private String first;
	private String second;
	
        //Constructeur de la classe Couple avec deux String
        //en param�tre, en appelant la m�thode init 
	public Couple(String w1, String w2) {
		init(w1, w2);
	}

        //Stocke les deux String dans deux attributs diff�rents
	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

        /*Surcharge la fonction hashCode() pour utiliser la m�thode hashCodeEclipse()
        d�clar�e plus bas pour g�rer deux attributs diff�rents dans un m�me hashCode
        */
	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}

        /*R�partit �quitablement les mots non par ordre alphab�tique mais par
        hashCode. Tous les objets hash� seront accessibles �quitablement en m�moire
        et permet de tirer un mot vraiment al�atoirement*/
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        /*Surcharge la fonction equals pour comparer si deux instances ont 
        la m�me valeur de hachage*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couple other = (Couple) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

}
