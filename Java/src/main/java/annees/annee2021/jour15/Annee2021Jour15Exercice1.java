package annees.annee2021.jour15;

import commun.structure.AdventOfCodeException;

public class Annee2021Jour15Exercice1 extends Annee2021Jour15 {

	public static void main(String[] args) {
		new Annee2021Jour15Exercice1().lancer(true);
	}

	public Annee2021Jour15Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var map = inputToMap(input, true);
		return runOnMap(map);
	}

}
