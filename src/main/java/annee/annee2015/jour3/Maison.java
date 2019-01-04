package annee.annee2015.jour3;

public class Maison {

	private int positionX;
	private int positionY;
	private int nbrCadeaux;

	public Maison(int positionX, int positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		nbrCadeaux = 1;
	}

	public int getNbrCadeaux() {
		return nbrCadeaux;
	}

	public void setNbrCadeaux(int nbrCadeaux) {
		this.nbrCadeaux = nbrCadeaux;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}
