package annees.annee2019.jour02;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour2Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour2Exercice1().lancer("src/main/resources/annee2019/jour02/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var blocs = ligne.split(",");
		int pointer = 0;
		blocs[1] = "12";
		blocs[2] = "2";
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
