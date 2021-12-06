package annees.annee2019.jour05;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour5 extends Exercice {

	protected Annee2019Jour5(int exercice) {
		super(2019, 5, exercice);
	}

	protected String runCommun(String input, long inputStart) throws AdventOfCodeException {
		var blocs = FileUtils.firstLineOfLong(input, ",");
		var code = new IntCode(blocs);
		var retour = code.lancerFirstOutput(inputStart);
		while (retour == 0) {
			retour = code.lancerFirstOutput(inputStart);
		}
		return String.valueOf(retour);
	}

}
