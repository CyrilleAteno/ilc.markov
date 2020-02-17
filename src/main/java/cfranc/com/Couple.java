package cfranc.com;

public class Couple {
	
	private String first;
	private String second;
	
        //Constructeur surcharger de la classe Couple 
	public Couple(String w1, String w2) {
		init(w1, w2);
	}

	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	//Retourne le 1er
	public String getFirst() {
		return first;
	}
        //modifie le 1er
	public void setFirst(String first) {
		this.first = first;
	}
        //retourne le 2nd
	public String getSecond() {
		return second;
	}
        //modifie le 2nd
	public void setSecond(String second) {
		this.second = second;
	}

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
