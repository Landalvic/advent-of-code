package annees.annee2019.jour11;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour11Exercice2 extends Annee2019Jour11 {

	public static void main(String[] args) {
		new Annee2019Jour11Exercice2().lancer(2019, 11, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return runCommun(input, 1).dessiner();
	}

}
