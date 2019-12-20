/**
 * @Potiquet Clement
 */

/**
 * Utilite de la classe :
 */
package cfranc.com;

public class Couple {
	
	private String first;
	private String second;
	
        //Constructeur avec paramètre de la classe
	public Couple(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        //Accesseurs et mutateurs-----------
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
        //-----------------------------------
        
        //hashCode ne donne pas de priorite alphanumerique.Repartie donc aleatoirement la chaine de caractere de l'instance dynamique
        
        /**
         * Surcharge la methode java
         * @return 
         */
	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
	}

        /**
         * Si il n'y a pas d'ordre alors on appel la methode hashcode
         * @return 
         */
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        /**
         * Surcharge la methode qui comprend en entree un parametre et retourne un boolean
         * Elle va comparer deux objets de l'instance
         * @param obj
         * @return 
         */
	@Override
	public boolean equals(Object obj) {
                //Verifie si l'objet et le meme que celui rentree en parametre
		if (this == obj)
			return true;
                //
		if (obj == null)
			return false;
                //
		if (getClass() != obj.getClass())
			return false;
                //
		Couple other = (Couple) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
                //
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}
}