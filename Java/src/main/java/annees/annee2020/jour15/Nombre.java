package annees.annee2020.jour15;

public class Nombre {

	private int value;
	private int lastTour;

	public Nombre(int value, int lastTour) {
		super();
		this.value = value;
		this.lastTour = lastTour;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getLastTour() {
		return lastTour;
	}

	public void setLastTour(int lastTour) {
		this.lastTour = lastTour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Nombre other = (Nombre) obj;
		return value == other.value;
	}

	@Override
	public String toString() {
		return "Nombre [value=" + value + ", lastTour=" + lastTour + "]";
	}

}
