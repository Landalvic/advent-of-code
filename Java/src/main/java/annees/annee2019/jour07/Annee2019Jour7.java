package annees.annee2019.jour07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour7 extends Exercice {

	protected List<IntCode> inputToCodes(String input) throws AdventOfCodeException {
		var programme = FileUtils.firstLine(input);
		List<IntCode> codes = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			codes.add(new IntCode(programme));
		}
		return codes;
	}

	protected abstract long apresFinPremiereBoucle(long newRetour, List<IntCode> codes);

	protected long lancementCodes(List<IntCode> codes, long retour, int indexCode, List<Long> interdits,
			int phaseDepart, int phaseFin) {
		long max = 0;
		var code = codes.get(indexCode);
		for (long i = phaseDepart; i <= phaseFin; i++) {
			if (!interdits.contains(i)) {
				List<Long> newInterdits = new ArrayList<>(interdits);
				newInterdits.add(i);
				code.init();
				long newRetour = code.lancerFirstOutput(Arrays.asList(i, retour));
				if (indexCode + 1 >= codes.size()) {
					return apresFinPremiereBoucle(newRetour, codes);
				} else {
					long total = lancementCodes(codes, newRetour, indexCode + 1, newInterdits, phaseDepart, phaseFin);
					if (total > max) {
						max = total;
					}
				}
			}
		}
		return max;
	}

}
