package commun.calculatrice;

import java.util.Objects;

public abstract class Operateur implements Bloc, Comparable<Operateur> {

	protected String code;
	protected int priority;

	protected Operateur(String code, int priority) {
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
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Operateur other = (Operateur) obj;
		return Objects.equals(code, other.code);
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
