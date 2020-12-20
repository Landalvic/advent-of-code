package annees.annee2020.jour12;

import java.util.List;

import commun.Direction;
import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2020Jour12Exercice1 extends Annee2020Jour12 {

	public static void main(String[] args) {
		new Annee2020Jour12Exercice1().lancer(true);
	}

	public Annee2020Jour12Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Instruction> lignes = inputToListObject(input);
		Position bateau = new Position();
		Direction direction = Direction.DROITE;
		for (Instruction instruction : lignes) {
			if (instruction.getAvancement() != null) {
				bateau.bouger(instruction.getAvancement(), instruction.getNbr());
			} else {
				switch (instruction.getDirection()) {
					case GAUCHE:
						for (int i = 0; i < instruction.getNbr() / 90; i++) {
							direction = direction.tournerGauche();
						}
						break;
					case DROITE:
						for (int i = 0; i < instruction.getNbr() / 90; i++) {
							direction = direction.tournerDroite();
						}
						break;
					case HAUT:
						bateau.bouger(direction, instruction.getNbr());
						break;
					default:
						break;
				}
			}
		}
		return String.valueOf((int) bateau.distanceFromCenter());
	}

}
