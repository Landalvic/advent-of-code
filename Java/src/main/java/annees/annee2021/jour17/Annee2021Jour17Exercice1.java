package annees.annee2021.jour17;

import commun.Position;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2021Jour17Exercice1 extends Annee2021Jour17 {

	public static void main(String[] args) {
		new Annee2021Jour17Exercice1().lancer(true);
	}

	public Annee2021Jour17Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var donnees = FileUtils.firstLineOfPattern(input, Input.class);
		Position position = new Position(0, 0);

		int vitesse = 10;
		int angle = -1;
		for (int i = 0; i < 10; i++) {

		}
		return "";
	}

}
