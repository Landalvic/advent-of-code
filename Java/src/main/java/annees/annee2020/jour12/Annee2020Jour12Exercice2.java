package annees.annee2020.jour12;

import java.util.stream.Stream;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2020Jour12Exercice2 extends Annee2020Jour12 {

	public static void main(String[] args) {
		new Annee2020Jour12Exercice2().lancer(true);
	}

	public Annee2020Jour12Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<Instruction> lignes = inputToStreamObject(input);
		Position bateau = new Position();
		Position wayPoint = new Position(10, -1);
		lignes.forEach(instruction -> {
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
						bateau.setX(bateau.getX() + wayPoint.getX() * instruction.getNbr());
						bateau.setY(bateau.getY() + wayPoint.getY() * instruction.getNbr());
						break;
					default:
						break;
				}
			}
		});
		return String.valueOf((int) bateau.distanceFromCenter());
	}

}
