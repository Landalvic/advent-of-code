package annees.annee2019.jour11;

import commun.AdventOfCodeException;

public class Annee2019Jour11Exercice1 extends Annee2019Jour11 {

	public static void main(String[] args) {
		new Annee2019Jour11Exercice1().lancer(2019, 11, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return String.valueOf(runCommun(input, 0).getNombreNonNull());
	}

}
