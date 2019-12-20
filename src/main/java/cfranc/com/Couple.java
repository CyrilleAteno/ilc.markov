package cfranc.com;

public class Couple {
	
	private String first; 
	private String second;
	
	public Couple(String w1, String w2) {
		init(w1, w2);
	}
        /**
         * Fonction init qui permet d'initialiser les 2 attributs de la classe couple
         * @param w1 premi�re chaine de caract�re qui sera attribu� � l'attribut first
         * @param w2 seconde chaine de caract�re qui sera attribu� � l'attribut second
         */
	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	/**
         * Getter de l'attribut first
         * @return la chaine de caract�res de l'attribut first
         */
	public String getFirst() {
		return first;
	}
        /**
         * Permet de modifier le contenu de l'attribut first
         * @param first nouvelle chaine de caract�res � mettre dans first
         */
	public void setFirst(String first) {
		this.first = first;
	}
        /**
         * Getter de l'attribut second
         * @return la chaine de carat�res de l'attribut second
         */
	public String getSecond() {
		return second;
	}
        /**
         * Permet de modifier le contenu de l'attribut second
         * @param second nouvelle chaine de caract�res � mettre dans second
         */
	public void setSecond(String second) {
		this.second = second;
	}

	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}
        /**
         * Permet de construire le hashcode pour r�partir de mani�re uniforme dans l'annuaire.
         * @return le hashcode g�n�r�
         */
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	/**
         * Permet de savoir si l'objet pass� en param�tre est �gale � celui-ci.
         * @param obj l'objet � comparer.
         * @return vrai si l'objet en param�tre est lui-m�me, elle renvoie faux si l'objet est nul ou si la classe de l'objet est diff�rent
         * de celui-ci. 
         * Dans le cas o� l'objet est de classe Couple on regarde si les chaines de caract�res sont identitique, si c'est le cas alors la fonction renvoie vrai
         * sinon le fonction renverra faux
         */
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
