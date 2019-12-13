package annees.annee2019.jour13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour13Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour13Exercice1().lancer("src/main/resources/annee2019/jour13/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var sblocs = ligne.split(",");
		String[] blocs = new String[sblocs.length + 1000];
		for (int i = 0; i < blocs.length; i++) {
			if (i < sblocs.length) {
				blocs[i] = sblocs[i];
			} else {
				blocs[i] = "0";
			}
		}
		var pointer = new AtomicInteger();
		var relativeBase = new AtomicInteger();
		int nbrBloc = 0;
		for (int i = 0; i < blocs.length; i++) {
			var liste = programme(blocs, pointer, relativeBase);
			if (liste.size() != 3) {
				break;
			}
			if (liste.get(2).intValue() == 2) {
				nbrBloc++;
			}
		}

		return "" + nbrBloc;
	}

	private List<Long> programme(String[] blocs, AtomicInteger pointer, AtomicInteger relativeBase) {
		int ipointer = Integer.parseInt(blocs[pointer.get()]);
		List<Long> inputs = new ArrayList<>();
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
			long valeur1;
			if (mode1 == 1) {
				valeur1 = Long.parseLong(blocs[pointer.get() + 1]);
			} else if (mode1 == 2) {
				valeur1 = Long.parseLong(blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 1])]);
			} else {
				valeur1 = Long.parseLong(blocs[Integer.parseInt(blocs[pointer.get() + 1])]);
			}
			long valeur2 = 0;
			if (opcodePointer == 1 || opcodePointer == 2 || opcodePointer == 5 || opcodePointer == 6 || opcodePointer == 7 || opcodePointer == 8) {
				if (mode2 == 1) {
					valeur2 = Long.parseLong(blocs[pointer.get() + 2]);
				} else if (mode2 == 2) {
					valeur2 = Long.parseLong(blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 2])]);
				} else {
					valeur2 = Long.parseLong(blocs[Integer.parseInt(blocs[pointer.get() + 2])]);
				}
			}
			if (opcodePointer == 99) {
				break;
			} else if (opcodePointer == 1) {
				if (mode3 == 2) {
					blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 3])] = "" + (valeur1 + valeur2);
				} else {
					blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "" + (valeur1 + valeur2);
				}
				pointer.addAndGet(4);
			} else if (opcodePointer == 2) {
				if (mode3 == 2) {
					blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 3])] = "" + (valeur1 * valeur2);
				} else {
					blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "" + (valeur1 * valeur2);
				}
				pointer.addAndGet(4);
			} else if (opcodePointer == 3) {
				if (mode1 == 2) {
					blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 1])] = "" + inputs.remove(0);
				} else {
					blocs[Integer.parseInt(blocs[pointer.get() + 1])] = "" + inputs.remove(0);
				}
				pointer.addAndGet(2);
			} else if (opcodePointer == 4) {
				inputs.add(valeur1);
				pointer.addAndGet(2);
				if (inputs.size() == 3) {
					return inputs;
				}
			} else if (opcodePointer == 5) {
				if (valeur1 != 0) {
					pointer.getAndSet((int) valeur2);
				} else {
					pointer.addAndGet(3);
				}
			} else if (opcodePointer == 6) {
				if (valeur1 == 0) {
					pointer.getAndSet((int) valeur2);
				} else {
					pointer.addAndGet(3);
				}
			} else if (opcodePointer == 7) {
				if (valeur1 < valeur2) {
					if (mode3 == 2) {
						blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 3])] = "1";
					} else {
						blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "1";
					}
				} else {
					if (mode3 == 2) {
						blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 3])] = "0";
					} else {
						blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "0";
					}
				}
				pointer.addAndGet(4);
			} else if (opcodePointer == 8) {
				if (valeur1 == valeur2) {
					if (mode3 == 2) {
						blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 3])] = "1";
					} else {
						blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "1";
					}
				} else {
					if (mode3 == 2) {
						blocs[relativeBase.get() + Integer.parseInt(blocs[pointer.get() + 3])] = "0";
					} else {
						blocs[Integer.parseInt(blocs[pointer.get() + 3])] = "0";
					}
				}
				pointer.addAndGet(4);
			} else if (opcodePointer == 9) {
				relativeBase.addAndGet((int) valeur1);
				pointer.addAndGet(2);
			} else {
				pointer.addAndGet(1);
			}
			ipointer = Integer.parseInt(blocs[pointer.get()]);
		}
		return inputs;
	}

}
