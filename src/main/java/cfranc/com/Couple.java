package cfranc.com;

public class Couple {
	
	private String first;
	private String second;
	
	public Couple(String w1, String w2) {
		init(w1, w2);
	}

	/*
	 * @param first initialisé à w1
	 * @param first initialisé à w2
	 * */
	public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}

	//getter
	public String getFirst() {
		return first;
	}

	//setter
	public void setFirst(String first) {
		this.first = first;
	}

	//getter auto
	public String getSecond() {
		return second;
	}

	//setters
	public void setSecond(String second) {
		this.second = second;
	}

	//réécriture du hacher
	@Override
	public int hashCode() {
		return hashCodeEclipse();
	}

	//redéfinition d'un hacheur
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}



	// test l'égalité entre deux couple
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
