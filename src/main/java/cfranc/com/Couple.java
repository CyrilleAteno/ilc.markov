package cfranc.com;

public class Couple {
	
	private String first;
	private String second;

	/**
	 * Contructeur de Couple
	 * @param w1 Phrase 1 utilisé par le constructeur
	 * @param w2 Phrase 2 utilisé par le constructeur
	 */
	public Couple(String w1, String w2) {
		init(w1, w2);
	}

	/**
	 * @param w1 Phrase 1 que l'on aatribut à l'attribut first
	 * @param w2 Phrase 2 que l'on aatribut à l'attribut second
	 */
	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}

	/**
	 * @return Retourne l'attribut first de la l'objet Couple
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * @param first Permet d'attribuer une valeur à l'attribut first de l'objet
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * @return Retourne l'attribut second de la l'objet Couple
	 */
	public String getSecond() {
		return second;
	}

	/**
	 * @param second Permet d'attribuer une valeur à l'attribut second de l'objet
	 */
	public void setSecond(String second) {
		this.second = second;
	}

	/**
	 * @return Retourne la valeur renvoyé par la fonction hashCodeEsclipse()
	 */
	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}

	/**
	 * @return Retourne une variable qui stockera un code de hashage
	 */
	int hashCodeEclipse() {
		final int prime = 31; // On fixe une valeur constante dans prime
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode()); // On attribut à result le resultat du calcul prime * result + 0 (si first est null) ou la valeur stockée dans l'attribut first
		result = prime * result + ((second == null) ? 0 : second.hashCode()); // On attribut à result le resultat du calcul prime * result + 0 (si second est null) ou la valeur stockée dans l'attribut second
		return result; // On return le hash
	}

	/**
	 * @param obj Objet à tester
	 * @return False : si l'instance de l'object n'est pas égale à l'object passé en paramètre
	 * @return True : Si l'instance de l'objet est égale à l'objet passé en paramètre
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // Si l'instance actuel est égale à l'object passé en paramètre on renvoie true
			return true;
		if (obj == null) //Si l'object passé en paramètre est null et n'existe pas on renvoie false
			return false;
		if (getClass() != obj.getClass()) // Si la classe de l'instance n'est pas la même que l'objet passé en paramètre on renvoie false
			return false;
		Couple other = (Couple) obj; // On créer un objet couple
		if (first == null) { // Si l'attribut first de l'instance est null
			if (other.first != null) // et si l'objet passé en paramètre a un attribut first on renvoie false
				return false;
		} else if (!first.equals(other.first)) // Sinon si l'attribut first de l'instance actuelle n'est pas le même que celui de l'objet, on renvoie false
			return false;
		if (second == null) { // Si l'attribut second de l'instance est null
			if (other.second != null) // et si l'attribut de l'objet en paramètre ne l'est pas, on renvoie false
				return false;
		} else if (!second.equals(other.second)) // Sinon si l'attribut second de l'instance est égalé à celui de l'objet est égale, on renvoie true
			return false;
		return true; // On renvoie true si nous n'avons rien renvoyé jusqu'ici
	}

}
