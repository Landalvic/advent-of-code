package annees.annee2019.jour11;

import commun.Direction;
import commun.Map;
import commun.Position;

public class Robot {

	private Position position;
	private Direction direction;
	private int nbrPeinture;

	public Robot(Position position) {
		super();
		this.position = position;
		direction = Direction.HAUT;
		nbrPeinture = 0;
	}

	public int getNbrPeinture() {
		return nbrPeinture;
	}

	public void setNbrPeinture(int nbrPeinture) {
		this.nbrPeinture = nbrPeinture;
	}

	public void jouer(Map<Peinture> map, int couleur, int tourner) {
		var case1 = map.getCase(position);
		if (case1.getCouleur() != couleur) {
			nbrPeinture++;
		}
		case1.setCouleur(couleur);
		if (tourner == 0) {
			direction = direction.tourner(true);
		} else {
			direction = direction.tourner(false);
		}
		position.bouger(direction);
		if (map.getCase(position) == null) {
			map.setCase(new Peinture(map, position, 0));
		}
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
