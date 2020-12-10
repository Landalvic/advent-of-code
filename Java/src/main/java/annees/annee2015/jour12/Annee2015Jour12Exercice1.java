package annees.annee2015.jour12;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2015Jour12Exercice1 extends Annee2015Jour12 {

	public static void main(String[] args) {
		new Annee2015Jour12Exercice1().lancer("src/main/resources/annee2015/jour12/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		StringBuilder string = new StringBuilder(FileUtils.firstLine(input));
		try {
			return calcul(string);
		} catch (Exception e) {
			throw new AdventOfCodeException(e.getMessage(), e);
		}
	}

}
