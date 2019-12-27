package annees.annee2019.jour07;

import java.util.Collections;
import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;

public class Annee2019Jour7Exercice1 extends Annee2019Jour7 {

	public static void main(String[] args) {
		new Annee2019Jour7Exercice1().lancer(2019, 7, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<IntCode> codes = inputToCodes(input);
		return String.valueOf(lancementCodes(codes, 0, 0, Collections.emptyList(), 0, 4));
	}

	@Override
	protected long apresFinPremiereBoucle(long newRetour, List<IntCode> codes) {
		return newRetour;
	}

}
