package annees.annee2019.jour02;

import annees.annee2019.IntCode;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2019Jour2Exercice1 extends Annee2019Jour2 {

	public static void main(String[] args) {
		new Annee2019Jour2Exercice1().lancer(2019, 2, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var programme = FileUtils.firstLine(input);
		var code = new IntCode(programme);
		return lancerCode(code, 12, 2);
	}

}
