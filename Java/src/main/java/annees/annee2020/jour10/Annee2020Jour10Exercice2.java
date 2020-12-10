package annees.annee2020.jour10;

import java.util.Set;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour10Exercice2 extends Annee2020Jour10 {

	public static void main(String[] args) {
		new Annee2020Jour10Exercice2().lancer(2020, 10, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Set<Long> liste = FileUtils.setOfLongs(input);
		liste.add(0L);
		long depart = 0;
		long nbrAvant = 1;
		long nbrAvant2 = 1;
		long acc = 1;
		long total = 1;
		while (true) {
			int totalPrecedent = 0;
			for (int i = 1; i <= 3; i++) {
				if (liste.contains(depart - i)) {
					totalPrecedent++;
				}
			}
			if (totalPrecedent == 3) {
				long temp = acc;
				acc += nbrAvant + nbrAvant2;
				nbrAvant = nbrAvant2;
				nbrAvant2 = temp;
			} else if (totalPrecedent == 2) {
				long temp = acc;
				acc += nbrAvant2;
				nbrAvant = nbrAvant2;
				nbrAvant2 = temp;
			}
			if (liste.contains(depart + 1)) {
				depart += 1;
			} else if (liste.contains(depart + 2)) {
				depart += 2;
			} else if (liste.contains(depart + 3)) {
				depart += 3;
				total *= acc;
				nbrAvant = 1;
				nbrAvant2 = 1;
				acc = 1;
			} else {
				total *= acc;
				return String.valueOf(total);
			}
		}
	}

}
