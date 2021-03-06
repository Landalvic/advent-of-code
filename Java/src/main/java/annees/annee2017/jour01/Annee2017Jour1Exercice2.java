package annees.annee2017.jour01;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2017Jour1Exercice2 extends Annee2017Jour1 {

	public static void main(String[] args) {
		new Annee2017Jour1Exercice2().lancer(2017, 1, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		String data = FileUtils.firstLine(input);
		return runCommun(data, data.length() / 2);
	}

}
