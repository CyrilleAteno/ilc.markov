package cfranc.com;

/* La classe Couple permet de creer des objets Couple
    avec deux attributes first et second 
    et une fonction hashcodeEclipse permet de renvoyer une valeur de hashCode 
*/
public class Couple {
	
	private String first;
	private String second;
	
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

	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
	}
        // permet de retourner la valeur hashCode 
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode()); // res contient prime*result + (si first est null on rajoute 0 si non son hashCode)
		result = prime * result + ((second == null) ? 0 : second.hashCode()); // res contient prime*result + (si second est null on rajoute 0 si non son hashCode)
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
