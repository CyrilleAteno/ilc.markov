package cfranc.com;

/**
 * Class Couple qui permet d'associer deux mot (first et second)
 * 
 * @author cyrille
 *
 */
public class Couple {

	private String first;
	private String second;

	/**
	 * constructeur de la classe couple
	 * 
	 * @param w1 correspondant à first
	 * @param w2 correspondant à second
	 */
	public Couple(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}

	/**
	 * Getteur de l'attribue first
	 * 
	 * @return first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Setteur de l'attribue first
	 * 
	 * @return first
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Getteur de l'attribue second
	 * 
	 * @return second
	 */
	public String getSecond() {
		return second;
	}

	/**
	 * Setteur de l'attribue second
	 * 
	 * @return second
	 */
	public void setSecond(String second) {
		this.second = second;
	}

	@Override
	public int hashCode() {
		// return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
	}

	/**
	 * fonction hashcodeEclipse qui retourne result C'est une technique en object
	 * qui permet de repartir dans un tableau d'object de façon la plus uniforme
	 * possible pour eviter un phénomène de classement de façon alpha numérique
	 * 
	 * @return result
	 */
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

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
