package annees.annee2020.jour10;

import java.util.List;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour10Exercice3 extends Annee2020Jour10 {

	public static void main(String[] args) {
		new Annee2020Jour10Exercice3().lancer(2020, 10, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Integer> liste = FileUtils.listOfIntegers(input);
		int depart = 0;
		int affile = 0;
		int multiplicateur = 1;
		int tension1Avec3 = 0;
		int tension2Avec3 = 0;
		boolean fin = false;
		while (true) {
			if (liste.contains(depart + 1)) {
				affile++;
				depart += 1;
			} else if (liste.contains(depart + 2)) {
				if (liste.contains(depart + 3)) {
					tension2Avec3++;
				}
				depart += 2;
			} else if (liste.contains(depart + 3)) {
				depart += 3;
				System.out.println(affile);
				multiplicateur *= calculAffile(affile);
				affile = 0;
			} else {
				return "" + multiplicateur;
			}
		}
	}

	private int calculAffile(int affile) {
		int depart = 1;
		int depart2 = 2;
		int depart3 = 4;
		if (affile == 1) {
			return depart;
		}
		if (affile == 2) {
			return depart2;
		}
		for (int i = 3; i < affile; i++) {
			int temp = depart3;
			depart3 += depart + depart2;
			depart = depart2;
			depart2 = temp;
		}
		return depart3;
	}

}
