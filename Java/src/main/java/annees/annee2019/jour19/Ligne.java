package annees.annee2019.jour19;

public class Ligne {

	private long x;
	private long y;
	private long nbr;

	public Ligne(long x, long y, long nbr) {
		super();
		this.x = x;
		this.y = y;
		this.nbr = nbr;
	}

	public void addNombre() {
		nbr++;
	}

	public void addNombre(long x) {
		nbr += x;
	}

	public boolean baisserLongueur() {
		x++;
		nbr--;
		return nbr >= 100;
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

	public long getNbr() {
		return nbr;
	}

	public void setNbr(long nbr) {
		this.nbr = nbr;
	}

	@Override
	public String toString() {
		return "Ligne [x=" + x + ", y=" + y + ", nbr=" + nbr + "]";
	}

}
