package annees.annee2019.jour05;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour5Exercice2 extends Annee2019Jour5 {

	public static void main(String[] args) {
		new Annee2019Jour5Exercice2().lancer(true);
	}

	public Annee2019Jour5Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return runCommun(input, 5L);
	}

}
