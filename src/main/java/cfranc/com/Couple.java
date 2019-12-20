package cfranc.com;

public class Couple {
	
	private String first;
	private String second;
	
    /**
     * Constructeur de la classe Couple
     * @param w1
     * @param w2
     */
    public Couple(String w1, String w2) {
		init(w1, w2);
	}

    /**
     * Fonction permettant d'initialiser les attributs first et second
     * @param w1
     * @param w2
     */
    public void init(String w1, String w2) {
		this.first = w1;
		this.second = w2;
	}
	
    /**
     * Getter de first
     * @return
     */
    public String getFirst() {
		return first;
	}

    /**
     * Setter de first
     * @param first
     */
    public void setFirst(String first) {
		this.first = first;
	}

    /**
     * Getter de second
     * @return
     */
    public String getSecond() {
		return second;
	}

    /**
     * Setter de second
     * @param second
     */
    public void setSecond(String second) {
		this.second = second;
	}
    /**
     * Donne le hashCode
     * @return
     */
    @Override
    public int hashCode() {
            return hashCodeEclipse();
    }

    /**
     * Permet de calculer le hashCode
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
     * Permet de vérifier un objet est égale à celui-ci
     * On test d'abord l'objet, puis sa classe, puis ses attributs
     * @return
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
