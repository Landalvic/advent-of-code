package annees.annee2015.jour13;

import commun.structure.AdventOfCodeException;

public class Annee2015Jour13Exercice1 extends Annee2015Jour13 {

	public static void main(String[] args) {
		new Annee2015Jour13Exercice1().lancer("src/main/resources/annee2015/jour13/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		inputToInvites(input);
		return bonheurMax();
	}

}
