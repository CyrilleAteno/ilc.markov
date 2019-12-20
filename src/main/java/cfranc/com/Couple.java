package cfranc.com;

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
        
        /*
            surcharge de la methode hascode pour qu'elle retourne un hascode calculé dans hashCodeEclipse
        */
	@Override
	public int hashCode() {
            return hashCodeEclipse();
	}

        /*
            hashCodeEclipse permet d'obtenir un hashcode prenant en compte first et second
        */
	int hashCodeEclipse() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((first == null) ? 0 : first.hashCode());
            result = prime * result + ((second == null) ? 0 : second.hashCode());
            return result;
	}
	/*
            la méthode equals commence par verifier si les addresses sont identiques auquel cas les 2 objets sont identiques
            si ce n'est pas le cas, elle test si l'objet est null ils ne sont pas identiques
            si obj n'est pas de la classe couple alors ils ne sont pas non plus identiques
            on caste ensuite obj puis on test l'égalité de du first et second de l'instance actuelles avec first et second de l'instance obj
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
