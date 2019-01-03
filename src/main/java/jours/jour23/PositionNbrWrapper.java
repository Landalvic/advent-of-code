package jours.jour23;

public class PositionNbrWrapper {

	private Position position;
	private long nbr;

	public PositionNbrWrapper(Position position, long nbr) {
		super();
		this.position = position;
		this.nbr = nbr;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public long getNbr() {
		return nbr;
	}

	public void setNbr(long nbr) {
		this.nbr = nbr;
	}

}
