package cfranc.com;

/**
 * This class associate two word
 * 
 */

public class Couple {
	
        // Attribute
	private String first;
	private String second;
	
        // Constructor
	public Couple(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
        // Setter & Getter
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
        
        // overload of hashCode
	@Override
	public int hashCode() {
		//return hashCodeEclipse();
		return this.first.hashCode() + this.second.hashCode();
                // recusivly hash both of our attribut
	}
        
        // return prime * result + 0 if attribut exist or hash it not
	int hashCodeEclipse() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	
        // overload of equals operator
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
