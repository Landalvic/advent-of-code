package annees.annee2015.jour07;

import commun.structure.AdventOfCodeException;

public class Annee2015Jour7Exercice1 extends Annee2015Jour7 {

	public static void main(String[] args) {
		new Annee2015Jour7Exercice1().lancer("src/main/resources/annee2015/jour07/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return runCommun(input, null);
	}

}
