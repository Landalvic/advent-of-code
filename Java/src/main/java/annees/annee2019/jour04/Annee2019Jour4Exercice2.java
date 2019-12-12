package annees.annee2019.jour04;

import java.util.ArrayList;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;

public class Annee2019Jour4Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour4Exercice2().lancer("src/main/resources/annee2019/jour04/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		int min = 387638;
		int max = 919123;
		List<Integer> good = new ArrayList<>();
		for (int i = min; i <= max; i++) {
			String s = "" + i;
			int oldDigit = 0;
			boolean ok = true;
			boolean doubl = false;
			boolean continu = false;
			boolean stop = false;
			int nbr = 0;
			for (int j = 0; j < s.length(); j++) {
				int digit = Integer.parseInt("" + s.charAt(j));
				if (digit < oldDigit) {
					ok = false;
					break;
				}
				if (!doubl) {
					if (digit == oldDigit) {
						nbr++;
						if (continu) {
							continu = false;
						} else {
							continu = true;
						}
					} else {
						if (continu) {
							stop = true;
						}
					}
				}
				if (digit != oldDigit && nbr == 1) {
					stop = false;
					doubl = true;
				}
				if (digit != oldDigit) {
					nbr = 0;
				}
				oldDigit = digit;
			}
			if (nbr == 1) {
				doubl = true;
			}
			if (ok && doubl) {
				good.add(i);
			}
		}
		System.out.println(good);
		return "" + good.size();
	}

}
