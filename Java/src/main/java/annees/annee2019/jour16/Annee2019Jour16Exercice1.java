package annees.annee2019.jour16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour16Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour16Exercice1().lancer("src/main/resources/annee2019/jour16/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		List<Integer> entiers = new ArrayList<Integer>();
		List<Integer> phase = Arrays.asList(0, 1, 0, -1);
		for (int i = 0; i < ligne.length(); i++) {
			int c = Integer.parseInt("" + ligne.charAt(i));
			entiers.add(c);
		}

		for (int k = 0; k < 100; k++) {
			List<Integer> newInput = new ArrayList<Integer>();
			int changementPhase = 0;
			while (newInput.size() < entiers.size()) {
				int total = 0;
				changementPhase++;
				for (int i = 0; i < entiers.size(); i++) {
					int test = phase.get((((i + 1) / changementPhase)) % phase.size());
					if (test == 0) {
						if (i == 0) {
							i += changementPhase - 2;
						} else {
							i += changementPhase - 1;
						}
					} else {
						total += entiers.get(i) * test;
					}
				}
				String tot = ("" + total);
				newInput.add(Integer.parseInt("" + tot.charAt(tot.length() - 1)));
			}
			entiers = newInput;
			System.out.println(entiers);
		}
		String fin = "";
		for (int i = 0; i < 8; i++) {
			fin += entiers.get(i);
		}
		return fin;
	}

}
