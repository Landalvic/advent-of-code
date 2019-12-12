package annees.annee2019.jour05;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour5Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour5Exercice2().lancer("src/main/resources/annee2019/jour05/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var blocs = ligne.split(",");
		int pointer = 0;
		int ipointer = Integer.parseInt(blocs[pointer]);
		int inputProg = 5;
		while (ipointer != 99) {
			int opcodePointer = Integer.parseInt(String.valueOf(ipointer).substring(Math.max(String.valueOf(ipointer).length() - 2, 0)));
			int mode1 = 0;
			if (String.valueOf(ipointer).length() >= 3) {
				mode1 = Integer.parseInt("" + String.valueOf(ipointer).charAt(Math.max(2 + String.valueOf(ipointer).length() - 5, 0)));
			}
			int mode2 = 0;
			if (String.valueOf(ipointer).length() >= 4) {
				mode2 = Integer.parseInt("" + String.valueOf(ipointer).charAt(Math.max(1 + String.valueOf(ipointer).length() - 5, 0)));
			}
			int mode3 = 0;
			if (String.valueOf(ipointer).length() >= 5) {
				mode3 = Integer.parseInt("" + String.valueOf(ipointer).charAt(0));
			}
			int valeur1;
			if (mode1 == 0) {
				valeur1 = Integer.parseInt(blocs[Integer.parseInt(blocs[pointer + 1])]);
			} else {
				valeur1 = Integer.parseInt(blocs[pointer + 1]);
			}
			int valeur2 = 0;
			if (opcodePointer == 1 || opcodePointer == 2 || opcodePointer == 5 || opcodePointer == 6 || opcodePointer == 7 || opcodePointer == 8) {
				if (mode2 == 0) {
					valeur2 = Integer.parseInt(blocs[Integer.parseInt(blocs[pointer + 2])]);
				} else {
					valeur2 = Integer.parseInt(blocs[pointer + 2]);
				}
			}
			if (opcodePointer == 99) {
				break;
			} else if (opcodePointer == 1) {
				blocs[Integer.parseInt(blocs[pointer + 3])] = "" + (valeur1 + valeur2);

				pointer += 4;
			} else if (opcodePointer == 2) {
				blocs[Integer.parseInt(blocs[pointer + 3])] = "" + (valeur1 * valeur2);

				pointer += 4;
			} else if (opcodePointer == 3) {
				blocs[Integer.parseInt(blocs[pointer + 1])] = "" + inputProg;
				pointer += 2;
			} else if (opcodePointer == 4) {
				inputProg = valeur1;
				pointer += 2;
			} else if (opcodePointer == 5) {
				if (valeur1 != 0) {
					pointer = valeur2;
				} else {
					pointer += 3;
				}
			} else if (opcodePointer == 6) {
				if (valeur1 == 0) {
					pointer = valeur2;
				} else {
					pointer += 3;
				}
			} else if (opcodePointer == 7) {
				if (valeur1 < valeur2) {
					blocs[Integer.parseInt(blocs[pointer + 3])] = "1";
				} else {
					blocs[Integer.parseInt(blocs[pointer + 3])] = "0";
				}
				pointer += 4;
			} else if (opcodePointer == 8) {
				if (valeur1 == valeur2) {
					blocs[Integer.parseInt(blocs[pointer + 3])] = "1";
				} else {
					blocs[Integer.parseInt(blocs[pointer + 3])] = "0";
				}
				pointer += 4;
			} else {
				pointer += 1;
			}
			ipointer = Integer.parseInt(blocs[pointer]);
		}
		return "" + inputProg;
	}

}
