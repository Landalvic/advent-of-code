package annees.annee2018.jour01;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2018Jour1Exercice2 extends Annee2018Jour1 {

	public static void main(String[] args) {
		new Annee2018Jour1Exercice2().lancer(2018, 1, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Integer> liste = FileUtils.listOfIntegers(input);
		Set<Integer> frequencesDejaVues = new HashSet<>();
		int total = 0;
		frequencesDejaVues.add(total);
		while (true) {
			for (Integer i : liste) {
				total += i;
				if (!frequencesDejaVues.add(total)) {
					return String.valueOf(total);
				}
			}
		}
	}

}
