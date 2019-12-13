package annees.annee2019.jour13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour13Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour13Exercice2().lancer("src/main/resources/annee2019/jour13/data.txt");
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
		blocs[0] = "2";
		var pointer = new AtomicInteger();
		var relativeBase = new AtomicInteger();

		long[][] map = new long[24][42];

		long score = 0;
		List<Long> inputs = new ArrayList<>();
		while (true) {
			var liste = programme(blocs, inputs, pointer, relativeBase);
			if (liste.size() != 3) {
				break;
			}
			if (liste.get(0).intValue() == -1) {
				score = liste.get(2).intValue();
			} else {
				map[liste.get(1).intValue()][liste.get(0).intValue()] = liste.get(2).longValue();
			}

			int paddle = position(map, 3);
			int ball = position(map, 4);
			int ipaddle = positioni(map, 3);
			int iball = positioni(map, 4);
			if (paddle != -1 && ball != -1) {
				inputs.clear();
				long joystick = 0;
				if (ball > paddle) {
					joystick = 1;
				} else if (ball < paddle) {
					joystick = -1;
				}
				inputs.add(joystick);
			}
			System.out.println(ball + " - " + iball);
		}

		System.out.println(position(map, 4));
		afficherMap(map);

		return "" + score;
	}

	private void afficherMap(long[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private int position(long[][] map, long numero) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == numero) {
					return j;
				}
			}
		}
		return -1;
	}

	private int positioni(long[][] map, long numero) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == numero) {
					return i;
				}
			}
		}
		return -1;
	}

	private List<Long> programme(String[] blocs, List<Long> entrees, AtomicInteger pointer, AtomicInteger relativeBase) {
		int ipointer = Integer.parseInt(blocs[pointer.get()]);
		List<Long> inputs = new ArrayList<>(entrees);
		List<Long> outputs = new ArrayList<>();
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
				pointer.addAndGet(1);
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
				outputs.add(valeur1);
				pointer.addAndGet(2);
				if (outputs.size() == 3) {
					return outputs;
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
		return outputs;
	}

}
