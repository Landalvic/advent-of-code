package annees.annee2019.jour23;

public class Operation implements Comparable<Operation> {

	private int adresse;
	private long x;
	private long y;
	private long nbrEtapes;

	public Operation(int adresse, long x, long y, long nbrEtapes) {
		super();
		this.adresse = adresse;
		this.x = x;
		this.y = y;
		this.nbrEtapes = nbrEtapes;
	}

	public int getAdresse() {
		return adresse;
	}

	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public long getNbrEtapes() {
		return nbrEtapes;
	}

	public void setNbrEtapes(long nbrEtapes) {
		this.nbrEtapes = nbrEtapes;
	}

	@Override
	public int compareTo(Operation o) {
		return Long.compare(nbrEtapes, o.nbrEtapes);
	}

}
