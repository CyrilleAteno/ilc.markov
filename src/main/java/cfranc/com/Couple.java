package cfranc.com;

/**
 * Classe generant un couple
 * Dans cette classe, on veut repartir les objets de facon uniforme
 * @author dm663891
 */

public class Couple {
	
	private String first;
	private String second;
	
        /**
         * Créé un couple compose de deux String    
         * @param w1 Premiere String passee en parametre
         * @param w2 Deuxieme String passee en parametre
         */
	public Couple(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        // --- ACCESSEURS ---
        
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

        /**
         * Re-definition de la methode HashCode afin de mieux gerer les données specifique a cette classe,
         * ici en prenant les hashCode des deux String correspondant a l objet et en creant un hashcode pour chaque objet
         * @return 
         */
	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
	}
        
        /**
         * Définition d un hashCode particulier permettant de repartir les objets de façon uniforme, afin d eviter un phenomene de fil
         * @return result : represente le resultat du hashCode
         */
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        /**
         * Surcharge de la methode equals permettant de comparer les valeurs de deux instances, evite surtout les erreurs en cas de non-egalite 
         * @param obj L objet a comparer avec l objet courant
         * @return boolean : indique si les objets sont egaux ou non 
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
