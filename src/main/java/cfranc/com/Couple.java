package cfranc.com;

public class Couple {
	
        //Attributs de la classe
	private String first;
	private String second;
	
        //Constructeur de la classe
        //w1 : String
        //w2 : String
	public Couple(String w1, String w2) {
		init(w1, w2);
	}

        //Initialise les attributs de la classe, fonction appellée dans le constructeur
        //w1 : String
        //w2 : String
	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        //getter et setter des attributs First et Second
        //Retourne l'attribut first
	public String getFirst() {
		return first;
	}
        
        //Modifie la valeur de first
        //first : String
	public void setFirst(String first) {
		this.first = first;
	}

        //Retourne l'attribut second
	public String getSecond() {
		return second;
	}

        //Modifie la valeur de second
        //second : String
	public void setSecond(String second) {
		this.second = second;
	}

        //Lance la fonction "hashCodeEclipse()" et retourne la valeur obtenue du hashCode du couple
        //retourne : integer
	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}

        //permet de retourner le hashCode en fonction des attributs
        //result : integer
	int hashCodeEclipse() {
                // 31 = valeur choisi par préférence, pas par logique mathématique
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        //Permet de comparer deux objets entre eux
        //Retourne true si ils sont égaux, false si ils sont différents
        //obj : Object, tout type d'objet
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
