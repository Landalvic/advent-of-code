package annees.annee2020.jour12;

import commun.Direction;
import commun.structure.ExerciceInputToObject;

public abstract class Annee2020Jour12 extends ExerciceInputToObject<Instruction> {

	@Override
	protected void init() {
	}

	@Override
	protected Instruction ligneToObject(String ligne) {
		String c = String.valueOf(ligne.charAt(0));
		Instruction instruction = new Instruction();
		instruction.setNbr(Integer.valueOf(ligne.substring(1)));
		switch (c) {
		case "N":
			instruction.setAvancement(Direction.HAUT);
			break;
		case "S":
			instruction.setAvancement(Direction.BAS);
			break;
		case "E":
			instruction.setAvancement(Direction.DROITE);
			break;
		case "W":
			instruction.setAvancement(Direction.GAUCHE);
			break;
		case "L":
			instruction.setDirection(Direction.GAUCHE);
			break;
		case "R":
			instruction.setDirection(Direction.DROITE);
			break;
		case "F":
			instruction.setDirection(Direction.HAUT);
			break;
		default:
			break;
		}
		return instruction;
	}

}
