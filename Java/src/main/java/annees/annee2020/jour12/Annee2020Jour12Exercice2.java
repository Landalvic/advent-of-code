package annees.annee2020.jour12;

import java.util.List;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2020Jour12Exercice2 extends Annee2020Jour12 {

	public static void main(String[] args) {
		new Annee2020Jour12Exercice2().lancer(2020, 12, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Instruction> lignes = inputToListObject(input);
		Position p = new Position();
		Position wayPoint = new Position(10, -1);
		for (Instruction instruction : lignes) {
			if (instruction.getAvancement() != null) {
				wayPoint.bouger(instruction.getAvancement(), instruction.getNbr());
			} else {
				switch (instruction.getDirection()) {
				case GAUCHE:
					for (int i = 0; i < instruction.getNbr() / 90; i++) {
						double temp = wayPoint.getX();
						wayPoint.setX(wayPoint.getY());
						wayPoint.setY(-temp);
					}
					break;
				case DROITE:
					for (int i = 0; i < instruction.getNbr() / 90; i++) {
						double temp = wayPoint.getX();
						wayPoint.setX(-wayPoint.getY());
						wayPoint.setY(temp);
					}
					break;
				case HAUT:
					p.setX(p.getX() + wayPoint.getX() * instruction.getNbr());
					p.setY(p.getY() + wayPoint.getY() * instruction.getNbr());
					break;
				default:
					break;
				}
			}
		}
		return String.valueOf("" + p.distanceFromCenter());
	}

}
