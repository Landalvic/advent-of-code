package annees.annee2019.jour02;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2019Jour2Exercice2 extends Annee2019Jour2 {

	public static void main(String[] args) {
		new Annee2019Jour2Exercice2().lancer(2019, 2, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var programme = FileUtils.firstLine(input);
		var code = new IntCode(programme);
		String result = "";
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				code.init();
				if (Integer.parseInt(lancerCode(code, i, j)) == 19690720) {
					result = String.valueOf(100 * i + j);
				}
			}
		}
		return result;
	}

}
