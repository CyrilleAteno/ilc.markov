package cfranc.com;

/**
 * La classe Couple associe 2 cha�nes de caract�res avec leur ordre "1�re" et "2�me"
 */
public class Couple {
	
	private String first;
	private String second;
	
	public Couple(String w1, String w2) {
		init(w1, w2);
	}

	public void init(String w1, String w2) {
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

	/**
	 * Cr�er un code de hashage
	 * @return
	 */
	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}

	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	/**
	 * Permet de tester l'�galit� d'un objet avec l'objet couple actuel
	 * @param obj l'objet � tester
	 * @return true si l'objet � tester est bien de la classe Couple et que les variables first et second soient �gales
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
