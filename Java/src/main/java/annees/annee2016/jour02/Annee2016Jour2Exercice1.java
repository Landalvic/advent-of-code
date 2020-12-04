package annees.annee2016.jour02;

import java.util.List;

import commun.AdventOfCodeException;
import commun.Case;
import commun.Direction;
import commun.Map;
import commun.MapDefault;
import util.FileUtils;

public class Annee2016Jour2Exercice1 extends Annee2016Jour2 {

	public static void main(String[] args) {
		new Annee2016Jour2Exercice1().lancer(2016, 2, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> etapes = FileUtils.listOfLines(input);
		Map<Case> map = new MapDefault(3, 3);
		Case position = map.getCase(1, 1);
		StringBuilder solution = new StringBuilder();
		for (String etape : etapes) {
			for (int i = 0; i < etape.length(); i++) {
				switch (String.valueOf(etape.charAt(i))) {
					case "U":
						position = position.bougerOuRester(Direction.HAUT);
						break;
					case "L":
						position = position.bougerOuRester(Direction.GAUCHE);
						break;
					case "R":
						position = position.bougerOuRester(Direction.DROITE);
						break;
					case "D":
						position = position.bougerOuRester(Direction.BAS);
						break;
					default:
						break;
				}
			}
			solution.append((int) ((position.getPosition().getX() + 1) + (position.getPosition().getY()) * 3));
		}
		return solution.toString();
	}

}
