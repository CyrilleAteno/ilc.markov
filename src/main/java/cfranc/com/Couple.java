package cfranc.com;

public class Couple {
	
	private String first;
	private String second;
	
        //constructeur de la classe Couple
	public Couple(String w1, String w2) {
		init(w1, w2);
	}
        //initialise les attributs (first et second) avec les Strings donné en paramètre
	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
        
	// permet de recevoir la valeur de l'attribut first
	public String getFirst() {
		return first;
	}

        // permet de définir l'atribut first grâce à un String donné en paramètre 
	public void setFirst(String first) {
		this.first = first;
	}
        // permet de recevoir la valeur de l'attribut second
	public String getSecond() {
		return second;
	}
        // permet de définir l'atribut second grâce à un String donné en paramètre 
	public void setSecond(String second) {
		this.second = second;
	}
        
        // retourne le hash code du couple
	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}
        
        //permet de créé un hash code qui définit un entier qui represente les donées envoyées,
        //si on réutilise la fct hash code avec les données recu , on peut savoir si la donnée envoyer est la même que celle reçu
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        //permet de savoir si les objets on les mêmes attributs et les même valeurs .
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
