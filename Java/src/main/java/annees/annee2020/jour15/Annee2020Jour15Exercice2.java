package annees.annee2020.jour15;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour15Exercice2 extends Annee2020Jour15 {

	public static void main(String[] args) {
		new Annee2020Jour15Exercice2().lancer(true);
	}

	public Annee2020Jour15Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return runCommun(input, 30000000);
	}

}
