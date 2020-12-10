package annees.annee2020.jour10;

import java.util.List;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour10Exercice1 extends Annee2020Jour10 {

	public static void main(String[] args) {
		new Annee2020Jour10Exercice1().lancer(2020, 10, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Integer> liste = FileUtils.listOfIntegers(input);
		int depart = 0;
		int tension1 = 0;
		int tension2 = 0;
		int tension3 = 0;
		while (true) {
			boolean test = false;
			if (liste.contains(depart + 1)) {
				depart += 1;
				tension1++;
			} else if (liste.contains(depart + 2)) {
				depart += 2;
				tension2++;
			} else if (liste.contains(depart + 3)) {
				depart += 3;
				tension3++;
			} else {
				tension3++;
				System.out.println(tension1);
				System.out.println(tension2);
				System.out.println(tension3);
				return "" + tension1 * tension3;
			}
		}
	}

}
