package commun.calculatrice;

public abstract class Operateur implements Bloc, Comparable<Operateur> {

	private String code;
	private int priority;

	public Operateur(String code, int priority) {
		super();
		this.code = code;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public abstract double calcul(double valeurGauche, double valeurDroite);

	@Override
	public double valeur() {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Operateur other = (Operateur) obj;
		if (code == null) {
			if (other.code != null) return false;
		} else if (!code.equals(other.code)) return false;
		return true;
	}

	@Override
	public int compareTo(Operateur o) {
		return Integer.compare(o.priority, priority);
	}

	@Override
	public String toString() {
		return "Operateur [code=" + code + "]";
	}

}
