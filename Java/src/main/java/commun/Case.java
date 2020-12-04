package commun;

public class Case {

	private static final String AFFICHAGE = ".";
	private Position position;
	private Map<? extends Case> map;
	private String value;

	public Case(Map<? extends Case> map, Position position) {
		super();
		this.map = map;
		this.position = position;
	}

	public Case(Map<? extends Case> map, Position position, String value) {
		super();
		this.map = map;
		this.position = position;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String afficher() {
		return AFFICHAGE;
	}

	public Case bougerOuRester(Direction direction) {
		Case bouger = bouger(direction);
		return bouger == null ? this : bouger;
	}

	public Case bouger(Direction direction) {
		switch (direction) {
			case HAUT:
				return map.getCase((int) position.getX(), (int) position.getY() - 1);
			case BAS:
				return map.getCase((int) position.getX(), (int) position.getY() + 1);
			case GAUCHE:
				return map.getCase((int) position.getX() - 1, (int) position.getY());
			case DROITE:
				return map.getCase((int) position.getX() + 1, (int) position.getY());
			default:
				return null;
		}
	}

	@Override
	public String toString() {
		return "Case [position=" + position + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Case other = (Case) obj;
		if (getPosition() == null) {
			if (other.getPosition() != null) {
				return false;
			}
		} else if (!getPosition().equals(other.getPosition())) {
			return false;
		}
		return true;
	}

}
