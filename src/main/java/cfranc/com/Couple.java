package cfranc.com;
      /*
        Cette classe associe deux mots

        Les deux attributs de la classe Couple
        attribut 1: 
            nom :first 
            Acces : Private
            type:string
    
        attribut 1: 
            nom :second
            Acces : Private
            type:string
            
        */


public class Couple {
	
        
	private String first;
	private String second;
	
        
        /*
        Constructeur d'initialisation de la classe couple qui prend en parametres deux String pour initialiser
        */
	public Couple(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        //Accesseur de l'attribut first
	public String getFirst() {
		return first;
	}
        //Mutateur de l'attribut first
	public void setFirst(String first) {
		this.first = first;
	}
        //Accesseur de l'attribut second
	public String getSecond() {
		return second;
	}
        //Mutateur de l'attribut second
	public void setSecond(String second) {
		this.second = second;
	}
        
        /*
        Génerer le hashCode de la classe à partir des hashCode de ses attributs
        Chaque instance de la classe dispose ainsi d'un code unique        
        */
        
	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
	}
        
        /*
            Génerer le code numérique de la classe à partir d'un calcul défini
            
        */
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode()); //Oération ternaire si first est nulle récupere 0 sinon récupere le hashCode de first
		result = prime * result + ((second == null) ? 0 : second.hashCode());// idem
		return result;
	}
	
        // Méthode de comparaison réécrite.(override)
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
