package jours.jour23;

public class Nanobot {

	private Position position;
	private long puissanceSignal;

	public Nanobot(long positionX, long positionY, long positionZ, long puissanceSignal) {
		super();
		position = new Position(positionX, positionY, positionZ);
		this.puissanceSignal = puissanceSignal;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean aPortee(Nanobot nanobot) {
		return aPortee(nanobot.position);
	}

	public boolean aPortee(Position position) {
		return this.position.distance(position) <= puissanceSignal;
	}

	public long getPuissanceSignal() {
		return puissanceSignal;
	}

	public void setPuissanceSignal(long puissanceSignal) {
		this.puissanceSignal = puissanceSignal;
	}

}
