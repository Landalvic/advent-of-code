package annees.annee2019.jour02;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour2Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour2Exercice2().lancer("src/main/resources/annee2019/jour02/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		String result = "";
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				String retour = programme(input, "" + i, "" + j);
				if (Integer.parseInt(retour) == 19690720) {
					result = "" + (100 * i + j);
				}
			}
		}
		return result;
	}

	public String programme(String input, String valeur1, String valeur2) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var blocs = ligne.split(",");
		int pointer = 0;
		blocs[1] = valeur1;
		blocs[2] = valeur2;
		while (Integer.parseInt(blocs[pointer]) != 99) {
			if (Integer.parseInt(blocs[pointer]) == 99) {
				break;
			} else if (Integer.parseInt(blocs[pointer]) == 1) {
				blocs[Integer.parseInt(blocs[pointer + 3])] = ""
						+ (Integer.parseInt(blocs[Integer.parseInt(blocs[pointer + 1])]) + Integer.parseInt(blocs[Integer.parseInt(blocs[pointer + 2])]));

				pointer += 4;
			} else if (Integer.parseInt(blocs[pointer]) == 2) {
				blocs[Integer.parseInt(blocs[pointer + 3])] = ""
						+ (Integer.parseInt(blocs[Integer.parseInt(blocs[pointer + 1])]) * Integer.parseInt(blocs[Integer.parseInt(blocs[pointer + 2])]));

				pointer += 4;
			} else {
				pointer += 1;
			}
		}
		return blocs[0];
	}

}
