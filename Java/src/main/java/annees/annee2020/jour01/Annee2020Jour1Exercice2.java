package annees.annee2020.jour01;

import java.util.List;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2020Jour1Exercice2 extends Annee2020Jour1 {

	public static void main(String[] args) {
		new Annee2020Jour1Exercice2().lancer(2020, 1, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Integer> liste = FileUtils.listOfIntegers(input);
		for (int i = 0; i < liste.size(); i++) {
			for (int j = 0; j < liste.size(); j++) {
				for (int j2 = 0; j2 < liste.size(); j2++) {
					if (i != j && j != j2 && i != j2 && liste.get(i) + liste.get(j) + liste.get(j2) == 2020) {
						return String.valueOf((liste.get(i) * liste.get(j) * liste.get(j2)));
					}
				}
			}
		}
		return String.valueOf(0);
	}

}
