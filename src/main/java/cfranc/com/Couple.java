package cfranc.com;

public class Couple {
	
	private String first;
	private String second;
	
	public Couple(String w1, String w2) { // Constructeur d'un objet couple avec 2 Strings
		this.first = w1;
		this.second = w2;
	}
	
	public String getFirst() {
		return first;
	} // Retourne le premier membre du couple

	public void setFirst(String first) {
		this.first = first;
	} // Set le premier membre du couple

	public String getSecond() {
		return second;
	} // Retourne le second membre du couple

	public void setSecond(String second) {
		this.second = second;
	} // Set le second membre du couple

	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode(); // Compose la ligne des couples de mots
	}

	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode()); // Si first n'est pas nul, on appelle la fonction hashCode()
		result = prime * result + ((second == null) ? 0 : second.hashCode()); // Si second n'est pas nul, on appelle la fonctin hashCode()
		return result;
	}
	
	@Override // Méthode de vérification des conditions de classes
	public boolean equals(Object obj) {
		if (this == obj) // Si l'argument donné est le m�me que l'objet -> true
			return true;
		if (obj == null) // Si l'objet donné est null -> false
			return false;
		if (getClass() != obj.getClass()) // Si la class de l'objet est différente de celle instanciée -> false
			return false;
		Couple other = (Couple) obj; // On créé un objet couple appelé "other"
		if (first == null) { // Si le premier membre du couple est vide
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
