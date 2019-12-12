package annees.annee2019.jour01;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour1Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour1Exercice2().lancer("src/main/resources/annee2019/jour01/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.listOfIntegers(input);
		int total = 0;
		for (Integer a : stream) {
			int redux = ((int) (a / 3.0)) - 2;
			while (redux > 0) {
				total += redux;
				redux = ((int) (redux / 3.0)) - 2;
			}
		}

		return String.valueOf(total);
	}

}
