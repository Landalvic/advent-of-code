package annees.annee2019.jour07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour7Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour7Exercice2().lancer("src/main/resources/annee2019/jour07/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		int max = 0;
		String result = "";
		for (int i = 5; i <= 9; i++) {
			for (int j = 5; j <= 9; j++) {
				for (int j2 = 5; j2 <= 9; j2++) {
					for (int k = 5; k <= 9; k++) {
						for (int k2 = 5; k2 <= 9; k2++) {
							if (i != j && i != k && i != j2 && i != k2 && j != j2 && j != k && j != k2 && j2 != k && j2 != k2 && k != k2) {
								int valeurE = 0;
								var blocs1 = ligne.split(",");
								var blocs2 = ligne.split(",");
								var blocs3 = ligne.split(",");
								var blocs4 = ligne.split(",");
								var blocs5 = ligne.split(",");
								var pointer1 = new AtomicInteger();
								var pointer2 = new AtomicInteger();
								var pointer3 = new AtomicInteger();
								var pointer4 = new AtomicInteger();
								var pointer5 = new AtomicInteger();
								while (pointer1.get() >= 0) {
									int valeurA = programme(blocs1, i, valeurE, pointer1);
									int valeurB = programme(blocs2, j, valeurA, pointer2);
									int valeurC = programme(blocs3, j2, valeurB, pointer3);
									int valeurD = programme(blocs4, k, valeurC, pointer4);
									valeurE = programme(blocs5, k2, valeurD, pointer5);
								}
								if (valeurE > max) {
									max = valeurE;
									result = "" + i + j + j2 + k + k2;
								}
							}
						}
					}
				}
			}
		}
		return "" + max;
	}

	private int programme(String[] blocs, int phase, int inputProg, AtomicInteger pointer) {
		int ipointer = Integer.parseInt(blocs[pointer.get()]);
		List<Integer> inputs = new ArrayList<>();
		if (pointer.get() == 0) {
			inputs.add(phase);
		}
		inputs.add(inputProg);
		boolean stop = false;
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
				valeur1 = Integer.parseInt(blocs[Integer.parseInt(blocs[pointer.get() + 1])]);
			} else {
				valeur1 = Integer.parseInt(blocs[pointer.get() + 1]);
			}
			int valeur2 = 0;
			if (opcodePointer == 1 || opcodePointer == 2 || opcodePointer == 5 || opcodePointer == 6 || opcodePointer == 7 || opcodePointer == 8) {
				if (mode2 == 0) {
					valeur2 = Integer.parseInt(blocs[Integer.parseInt(blocs[pointer.get() + 2])]);
				} else {
					valeur2 = Integer.parseInt(blocs[pointer.get() + 2]);
				}
			}
			if (opcodePointer == 99) {
				break;
			} else if (opcodePointer == 1) {
				blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "" + (valeur1 + valeur2);

				pointer.addAndGet(4);
			} else if (opcodePointer == 2) {
				blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "" + (valeur1 * valeur2);

				pointer.addAndGet(4);
			} else if (opcodePointer == 3) {
				blocs[Integer.parseInt(blocs[pointer.get() + 1])] = "" + inputs.remove(0);
				pointer.addAndGet(2);
			} else if (opcodePointer == 4) {
				inputs.add(valeur1);
				pointer.addAndGet(2);
				return valeur1;
			} else if (opcodePointer == 5) {
				if (valeur1 != 0) {
					pointer.set(valeur2);
				} else {
					pointer.addAndGet(3);
				}
			} else if (opcodePointer == 6) {
				if (valeur1 == 0) {
					pointer.set(valeur2);
				} else {
					pointer.addAndGet(3);
				}
			} else if (opcodePointer == 7) {
				if (valeur1 < valeur2) {
					blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "1";
				} else {
					blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "0";
				}
				pointer.addAndGet(4);
			} else if (opcodePointer == 8) {
				if (valeur1 == valeur2) {
					blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "1";
				} else {
					blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "0";
				}
				pointer.addAndGet(4);
			} else {
				pointer.addAndGet(1);
			}
			ipointer = Integer.parseInt(blocs[pointer.get()]);
		}
		pointer.set(-1);
		return inputs.remove(0);
	}

}
