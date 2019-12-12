package annees.annee2019.jour11;

import java.util.HashSet;
import java.util.Set;

public class Robot {

	private int x;
	private int y;
	private Direction direction;
	private int nbrPeinture;
	private Set<Position> panelsPeints;

	public Robot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		direction = Direction.HAUT;
		nbrPeinture = 0;
		panelsPeints = new HashSet<>();
	}

	public Set<Position> getPanelsPeints() {
		return panelsPeints;
	}

	public void setPanelsPeints(Set<Position> panelsPeints) {
		this.panelsPeints = panelsPeints;
	}

	public int getNbrPeinture() {
		return nbrPeinture;
	}

	public void setNbrPeinture(int nbrPeinture) {
		this.nbrPeinture = nbrPeinture;
	}

	public void dessiner(int[][] map) {
		for (int j = 0; j < map.length; j++) {
			for (int j2 = 0; j2 < map[0].length; j2++) {
				if (j == getY() && j2 == getX()) {
					switch (getDirection()) {
					case HAUT:
						System.out.print("^");
						break;
					case GAUCHE:
						System.out.print("<");
						break;
					case DROITE:
						System.out.print(">");
						break;
					case BAS:
						System.out.print("v");
						break;
					}
				} else if (map[j2][j] == 0) {
					System.out.print(".");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}

	public void jouer(int[][] map, int couleur, int tourner) {
		if (map[x][y] != couleur) {
			nbrPeinture++;
		}
		panelsPeints.add(new Position(x, y));
		map[x][y] = couleur;
		if (tourner == 0) {
			direction = direction.tourner(true);
		} else {
			direction = direction.tourner(false);
		}
		switch (direction) {
		case HAUT:
			y += -1;
			break;
		case BAS:
			y += 1;
			break;
		case GAUCHE:
			x += -1;
			break;
		case DROITE:
			x += 1;
			break;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Robot [x=" + x + ", y=" + y + ", direction=" + direction + ", nbrPeinture=" + nbrPeinture + "]";
	}

}
