package annees.annee2019.jour09;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour9 extends Exercice {

	protected String runCommun(String input, long instruction) throws AdventOfCodeException {
		var programme = FileUtils.firstLine(input);
		IntCode code = new IntCode(programme);
		return String.valueOf(code.lancerFirstOutput(instruction));
	}

}
