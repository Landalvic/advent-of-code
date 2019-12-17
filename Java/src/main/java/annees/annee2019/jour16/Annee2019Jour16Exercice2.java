package annees.annee2019.jour16;

import java.util.Arrays;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour16Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour16Exercice2().lancer("src/main/resources/annee2019/jour16/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		int multiplier = 10000;
		StringBuilder sousLigne = new StringBuilder();
		for (int k = 0; k < multiplier; k++) {
			sousLigne.append(ligne);
		}
		List<Integer> phase = Arrays.asList(0, 1, 0, -1);
		int decalage = Integer.parseInt(ligne.substring(0, 7));
		sousLigne = new StringBuilder(sousLigne.substring(decalage));
		int[] entiers = new int[(sousLigne.length())];
		for (int i = 0; i < sousLigne.length(); i++) {
			int c = Integer.parseInt("" + sousLigne.charAt(i));
			entiers[i] = c;
		}

		for (int k = 0; k < 100; k++) {
			int[] newInput = new int[entiers.length];
			int changementPhase = decalage;
			int numero = 0;
			while (numero < entiers.length) {
				int total = 0;
				changementPhase++;
				numero++;
				for (int i = 0; i < entiers.length; i++) {
					int test = phase.get((((i + decalage + 1) / changementPhase)) % phase.size());
					if (test == 0) {
						if (i == 0) {
							i += numero - 2;
						} else {
							i += changementPhase - 1;
						}
					} else {
						int dec;
						dec = changementPhase - 1;
						for (int j = 0; j < dec + 1 && i + j < entiers.length; j++) {
							total += entiers[i + j] * test;
						}
						i += dec;
					}
				}
				String tot = ("" + total);
				newInput[numero - 1] = Integer.parseInt("" + tot.charAt(tot.length() - 1));
			}
			entiers = newInput;
			System.out.println(k);
		}

		String fin = "";
		for (int i = 0; i < 8; i++) {
			fin += entiers[i];
		}
		return fin;
	}

}
