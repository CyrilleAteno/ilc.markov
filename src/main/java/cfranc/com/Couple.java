package cfranc.com;

public class Couple {
	
	private String first;
	private String second;

	//le constructeur de la fonction qui initialise les deux attributs du nouveau objet
	public Couple(String w1, String w2) {
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


	//fonction qui va nous permetre de melanger l'ordre des objet sous forme uniforme
	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
	}

	//La méthode hashCodeEclipse () générée commence par une déclaration d'un nombre premier (31),
	// effectue diverses opérations sur les objets primitifs et renvoie son résultat en fonction des attributs de l'objet.
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	//equals () vérifie d'abord si deux objets sont la même instance (==) et renvoie true s'ils le sont.
	//Ensuite, il vérifie que l'objet de comparaison n'est pas nul et que les deux objets sont de la même classe, renvoyant false s'ils ne le sont pas.
	//Enfin, equals () convertie l'objet d'entré en Objet COUPLE, puis vérifie l'égalité de chaque variable membre du Couple crée et l'objet, renvoyant false si l'une d'entre elles n'est pas égale.
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
