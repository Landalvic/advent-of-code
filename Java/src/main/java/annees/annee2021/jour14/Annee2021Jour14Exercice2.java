package annees.annee2021.jour14;

import commun.structure.AdventOfCodeException;

public class Annee2021Jour14Exercice2 extends Annee2021Jour14 {

	public static void main(String[] args) {
		new Annee2021Jour14Exercice2().lancer(true);
	}

	public Annee2021Jour14Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return runCommun(input, 40);
	}

}
