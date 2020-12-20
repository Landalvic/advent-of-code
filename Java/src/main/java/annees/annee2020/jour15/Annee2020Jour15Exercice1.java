package annees.annee2020.jour15;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour15Exercice1 extends Annee2020Jour15 {

	public static void main(String[] args) {
		new Annee2020Jour15Exercice1().lancer(true);
	}

	public Annee2020Jour15Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return runCommun(input, 2020);
	}

}
