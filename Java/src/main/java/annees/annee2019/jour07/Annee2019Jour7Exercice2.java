package annees.annee2019.jour07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;

public class Annee2019Jour7Exercice2 extends Annee2019Jour7 {

	public static void main(String[] args) {
		new Annee2019Jour7Exercice2().lancer(2019, 7, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<IntCode> codes = inputToCodes(input);
		return String.valueOf(lancementCodes(codes, 0, 0, Collections.emptyList(), 5, 9));
	}

	@Override
	protected long apresFinPremiereBoucle(long newRetour, List<IntCode> codes) {
		int indexCode = 4;
		List<IntCode> copyCodes = new ArrayList<>(codes.size());
		for (IntCode intCode : codes) {
			copyCodes.add(new IntCode(intCode));
		}
		while (!copyCodes.get((indexCode + 1) % copyCodes.size()).isFini()) {
			Long testRetour = copyCodes.get((indexCode + 1) % copyCodes.size()).lancerFirstOutput(newRetour);
			if (testRetour != null) {
				newRetour = testRetour;
			}
			indexCode++;
		}
		return newRetour;
	}

}
