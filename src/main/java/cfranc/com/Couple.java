package cfranc.com;

public class Couple {
	
	private String first;
	private String second;
	
        //Constructeur du couple 
	public Couple(String w1, String w2) {
		init(w1, w2);
	}

        //Permet d'initialiser un couple avec deux mots donnés
	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        //Getter du premier membre du couple
	public String getFirst() {
		return first;
	}

        //Setter du premier membre du couple
	public void setFirst(String first) {
		this.first = first;
	}

        //Getter du second membre du couple
	public String getSecond() {
		return second;
	}
        
        //Setter du second membre du couple
	public void setSecond(String second) {
		this.second = second;
	}

        //Permet d'avoir la valeur du HashCode du couple actuel
	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}

        //Permet de calculer un identifiant unique pour le couple
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        //Permet de définir la comparaison entre un couple et un objet passé
        //en paramètre
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
                
                //Dans le cas où l'autre objet est aussi un couple
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
