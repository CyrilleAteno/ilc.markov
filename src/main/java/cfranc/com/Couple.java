package cfranc.com;

public class Couple {
	
	private String first;
	private String second;
	
        //Constructeur d'un objet couple qui associe deux chaines de charactères
	public Couple(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        //Retourne la première chaine de charactère
	public String getFirst() {
		return first;
	}

        //Modifie la valeur de la première chaine de charactère
	public void setFirst(String first) {
		this.first = first;
	}

        //Retourne la seconde chaine de charactère
	public String getSecond() {
		return second;
	}

        //Modifie la valeur de la seconde chaine de charactère
	public void setSecond(String second) {
		this.second = second;
	}

        //Retourne un hashcode des deux chaines de charactères : coder de manière uniforme dans un tableau d'objet
	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
	}

        //Création d'une méthode pour le hashcode
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        //Création d'une méthode de vérifiation des conditions de la classe
	@Override
	public boolean equals(Object obj) {
            
                //Si l'argument donné est un objet : true
		if (this == obj)
			return true;
		//Si l'argument donné est null : false
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
