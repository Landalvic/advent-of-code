package annees.annee2019.jour09;

import commun.AdventOfCodeException;

public class Annee2019Jour9Exercice1 extends Annee2019Jour9 {

	public static void main(String[] args) {
		new Annee2019Jour9Exercice1().lancer(2019, 9, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return runCommun(input, 1L);
	}

}
