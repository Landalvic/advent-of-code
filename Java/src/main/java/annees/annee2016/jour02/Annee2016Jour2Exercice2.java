package annees.annee2016.jour02;

import java.util.List;

import commun.CaseDefault;
import commun.Direction;
import commun.MapOld;
import commun.Position;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2016Jour2Exercice2 extends Annee2016Jour2 {

	public static void main(String[] args) {
		new Annee2016Jour2Exercice2().lancer(2016, 2, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> etapes = FileUtils.listOfLines(input);
		MapOld<CaseDefault> map = new MapOld<>(5, 5);
		map.setCase(new CaseDefault(map, new Position(2, 0), "1"));
		map.setCase(new CaseDefault(map, new Position(1, 1), "2"));
		map.setCase(new CaseDefault(map, new Position(2, 1), "3"));
		map.setCase(new CaseDefault(map, new Position(3, 1), "4"));
		map.setCase(new CaseDefault(map, new Position(0, 2), "5"));
		map.setCase(new CaseDefault(map, new Position(1, 2), "6"));
		map.setCase(new CaseDefault(map, new Position(2, 2), "7"));
		map.setCase(new CaseDefault(map, new Position(3, 2), "8"));
		map.setCase(new CaseDefault(map, new Position(4, 2), "9"));
		map.setCase(new CaseDefault(map, new Position(1, 3), "A"));
		map.setCase(new CaseDefault(map, new Position(2, 3), "B"));
		map.setCase(new CaseDefault(map, new Position(3, 3), "C"));
		map.setCase(new CaseDefault(map, new Position(2, 4), "D"));
		CaseDefault position = map.getCase(0, 2);
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
			solution.append(position.getId());
		}
		return solution.toString();
	}

}
