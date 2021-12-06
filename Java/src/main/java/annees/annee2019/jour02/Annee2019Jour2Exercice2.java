package annees.annee2019.jour02;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2019Jour2Exercice2 extends Annee2019Jour2 {

	public static void main(String[] args) {
		new Annee2019Jour2Exercice2().lancer(true);
	}

	public Annee2019Jour2Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var programme = FileUtils.firstLineOfLong(input, ",");
		var code = new IntCode(programme);
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				code.init();
				if (lancerCode(code, i, j) == 19690720) {
					return String.valueOf(100 * i + j);
				}
			}
		}
		throw new AdventOfCodeException("Aucune réponse trouvée.");
	}

}
