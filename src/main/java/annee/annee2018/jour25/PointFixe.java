package annee.annee2018.jour25;

public class PointFixe {

	private int positionX;
	private int positionY;
	private int positionZ;
	private int positionT;
	private Constellation constellation;

	public PointFixe(int positionX, int positionY, int positionZ, int positionT) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
		this.positionT = positionT;
		constellation = new Constellation();
		constellation.getPoints().add(this);
	}

	public long distance(PointFixe point) {
		return Math.abs(point.positionX - positionX) + Math.abs(point.positionY - positionY)
				+ Math.abs(point.positionZ - positionZ) + Math.abs(point.positionT - positionT);
	}

	public Constellation getConstellation() {
		return constellation;
	}

	public void setConstellation(Constellation constellation) {
		this.constellation = constellation;
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

	public int getPositionZ() {
		return positionZ;
	}

	public void setPositionZ(int positionZ) {
		this.positionZ = positionZ;
	}

	public int getPositionT() {
		return positionT;
	}

	public void setPositionT(int positionT) {
		this.positionT = positionT;
	}

	@Override
	public String toString() {
		return "PointFixe [positionX=" + positionX + ", positionY=" + positionY + ", positionZ=" + positionZ
				+ ", positionT=" + positionT + "]";
	}

}
