package annees.annee2020.jour08;

public class Donnees {

	private int accumulateur = 0;
	private int index = 0;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getAccumulateur() {
		return accumulateur;
	}

	public void setAccumulateur(int accumulateur) {
		this.accumulateur = accumulateur;
	}

	@Override
	public String toString() {
		return "Donnees [accumulateur=" + accumulateur + ", index=" + index + "]";
	}

}
