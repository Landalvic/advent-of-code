package annees.annee2019.jour05;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public abstract class Annee2019Jour5 extends Exercice {

	protected String runCommun(String input, long inputStart) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		var retour = code.lancerFirstOutput(inputStart);
		while (retour == 0) {
			retour = code.lancerFirstOutput(inputStart);
		}
		return String.valueOf(retour);
	}

}
