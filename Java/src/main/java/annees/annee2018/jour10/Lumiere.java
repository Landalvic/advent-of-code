package annees.annee2018.jour10;

public class Lumiere implements Comparable<Lumiere> {

	private int positionX;
	private int positionY;
	private int velociteX;
	private int velociteY;

	public Lumiere(int positionX, int positionY, int velociteX, int velociteY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.velociteX = velociteX;
		this.velociteY = velociteY;
	}

	public void bouger() {
		positionX += velociteX;
		positionY += velociteY;
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

	public int getVelociteX() {
		return velociteX;
	}

	public void setVelociteX(int velociteX) {
		this.velociteX = velociteX;
	}

	public int getVelociteY() {
		return velociteY;
	}

	public void setVelociteY(int velociteY) {
		this.velociteY = velociteY;
	}

	@Override
	public int compareTo(Lumiere o) {
		return Integer.compare(positionY, o.positionY);
	}

}
