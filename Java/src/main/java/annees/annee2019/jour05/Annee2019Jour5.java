package annees.annee2019.jour05;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour5 extends Exercice {

	public Annee2019Jour5(int exercice) {
		super(2019, 5, exercice);
	}

	@Override
	protected void init() {}

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
