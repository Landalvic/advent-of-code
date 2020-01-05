package annees.annee2019.jour12;

import commun.AdventOfCodeException;

public class Annee2019Jour12Exercice1 extends Annee2019Jour12 {

	public static void main(String[] args) {
		new Annee2019Jour12Exercice1().lancer(2019, 12, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lunes = inputToLunes(input);
		for (int i = 0; i < 1000; i++) {
			tour(lunes);
		}
		return String.valueOf(lunes.stream().mapToInt(Lune::calculerEnergie).sum());
	}

}
