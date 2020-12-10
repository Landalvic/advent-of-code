package annees.annee2019.jour09;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour9Exercice2 extends Annee2019Jour9 {

	public static void main(String[] args) {
		new Annee2019Jour9Exercice2().lancer(2019, 9, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return runCommun(input, 2L);
	}

}
