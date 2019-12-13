package annees.annee2018.jour01;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2018Jour1Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2018Jour1Exercice2().lancer("src/main/resources/annee2018/jour01/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Integer> liste = FileUtils.listOfIntegers(input);
		Set<Integer> frequencesDejaVues = new HashSet<>();
		int total = 0;
		boolean dejaVu = false;
		while (!dejaVu) {
			for (Integer i : liste) {
				total += i;
				if (!frequencesDejaVues.add(total)) {
					dejaVu = true;
					break;
				}
			}
		}
		return String.valueOf(total);
	}

}