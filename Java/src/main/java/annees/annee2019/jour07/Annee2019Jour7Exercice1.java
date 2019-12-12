package annees.annee2019.jour07;

import java.util.ArrayList;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour7Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour7Exercice1().lancer("src/main/resources/annee2019/jour07/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		int max = 0;
		String result = "";
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				for (int j2 = 0; j2 <= 4; j2++) {
					for (int k = 0; k <= 4; k++) {
						for (int k2 = 0; k2 <= 4; k2++) {
							if (i != j && i != k && i != j2 && i != k2 && j != j2 && j != k && j != k2 && j2 != k && j2 != k2 && k != k2) {
								int valeurA = programme(ligne, i, 0);
								int valeurB = programme(ligne, j, valeurA);
								int valeurC = programme(ligne, j2, valeurB);
								int valeurD = programme(ligne, k, valeurC);
								int valeurE = programme(ligne, k2, valeurD);
								if (valeurE > max) {
									max = valeurE;
									result = "" + i + j + j2 + k + k2;
									System.out.println(valeurE);
									System.out.println(result);
								}
							}
						}
					}
				}
			}
		}
		return "" + max;
	}

	private int programme(String ligne, int phase, int inputProg) {
		var blocs = ligne.split(",");
		int pointer = 0;
		int ipointer = Integer.parseInt(blocs[pointer]);
		List<Integer> inputs = new ArrayList<>();
		inputs.add(phase);
		inputs.add(inputProg);
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
				blocs[Integer.parseInt(blocs[pointer + 1])] = "" + inputs.remove(0);
				pointer += 2;
			} else if (opcodePointer == 4) {
				inputs.add(valeur1);
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
		return inputs.remove(0);
	}

}
