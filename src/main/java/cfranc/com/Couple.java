package cfranc.com;
/**
 * La classe Couple représente un couple de deux mots et les fonctions de gestion
 * qui s'y rapportent.
 * @author jm512325
 */
public class Couple {
	
	private String first;
	private String second;
        
        /**
         * Constructeur de couple
         * @param w1 : Chaine de caractères correspondant au premier membre du couple
         * @param w2 : Chaine de caractères correspondant au deuxième membre du couple
         */
        public Couple(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        /**
         * Getter sur le premier membre du couple
         * @return le premier membre du couple
         */
	public String getFirst() {
		return first;
	}

        /**
         * Setter sur le premier membre du couple
         * @param first Nouvelle valeur pour le premier membre
         */
	public void setFirst(String first) {
		this.first = first;
	}

        /**
         * Getter sur le deuxieme membre du couple
         * @return le deuxieme membre du couple
         */
	public String getSecond() {
		return second;
	}

        /**
         * Setter sur le deuxieme membre du couple
         * @param second Nouvelle valeur pour le deuxieme membre
         */
	public void setSecond(String second) {
		this.second = second;
	}

        /**
         * Surcharge la génération de hashcode pour généré un HashCode pour le couple
         * @return le HashCode du couple
         */
	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
	}

        /**
         * Génere un hashCode propre à Eclipse
         * @return le hashCode
         */
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        /**
         * Surcharge la comparation pour comparer un Couple avec un autre objet 
         * @param obj objet avec lequelle comparer
         * @return true si egal, false sinon
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
