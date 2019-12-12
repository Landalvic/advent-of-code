package annees.annee2019.jour04;

import java.util.ArrayList;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;

public class Annee2019Jour4Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour4Exercice1().lancer("src/main/resources/annee2019/jour04/data.txt");
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
			for (int j = 0; j < s.length(); j++) {
				int digit = Integer.parseInt("" + s.charAt(j));
				if (digit < oldDigit) {
					ok = false;
					break;
				}
				if (digit == oldDigit) {
					doubl = true;
				}
				oldDigit = digit;
			}
			if (ok && doubl) {
				good.add(i);
			}
		}
		return "" + good.size();
	}

}
