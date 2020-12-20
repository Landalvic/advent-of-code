package annees.annee2020.jour10;

import java.util.Set;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour10Exercice1 extends Annee2020Jour10 {

	public static void main(String[] args) {
		new Annee2020Jour10Exercice1().lancer(true);
	}

	public Annee2020Jour10Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Set<Integer> liste = FileUtils.setOfIntegers(input);
		int depart = 0;
		int tension1 = 0;
		int tension3 = 0;
		while (true) {
			if (liste.contains(depart + 1)) {
				depart += 1;
				tension1++;
			} else if (liste.contains(depart + 2)) {
				depart += 2;
			} else if (liste.contains(depart + 3)) {
				depart += 3;
				tension3++;
			} else {
				tension3++;
				return String.valueOf(tension1 * tension3);
			}
		}
	}

}
