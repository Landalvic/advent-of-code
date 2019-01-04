package annee.annee2018.jour23;

public class Position {

	private long positionX;
	private long positionY;
	private long positionZ;

	public Position(long positionX, long positionY, long positionZ) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
	}

	public long distance(Position position) {
		return Math.abs(position.positionX - positionX) + Math.abs(position.positionY - positionY)
				+ Math.abs(position.positionZ - positionZ);
	}

	public long getPositionZ() {
		return positionZ;
	}

	public void setPositionZ(long positionZ) {
		this.positionZ = positionZ;
	}

	public long getPositionX() {
		return positionX;
	}

	public void setPositionX(long positionX) {
		this.positionX = positionX;
	}

	public long getPositionY() {
		return positionY;
	}

	public void setPositionY(long positionY) {
		this.positionY = positionY;
	}

	@Override
	public String toString() {
		return "Position [positionX=" + positionX + ", positionY=" + positionY + ", positionZ=" + positionZ + "]";
	}

}
