package annees.annee2019.jour13;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public abstract class Annee2019Jour13 extends Exercice {

	protected IntCode inputToCode(String input) throws AdventOfCodeException {
		var programme = FileUtils.firstLine(input);
		return new IntCode(programme);
	}

}
