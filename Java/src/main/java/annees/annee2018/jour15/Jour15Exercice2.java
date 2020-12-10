package annees.annee2018.jour15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Jour15Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Jour15Exercice2().lancer("src/main/resources/annee2018/jour15/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);

		long debut = System.currentTimeMillis();
		int degatsElfe = 3;
		boolean elfeMort = false;
		do {
			elfeMort = false;
			degatsElfe++;
			Case[][] map = new Case[liste.get(0).length()][liste.size()];
			List<Personnage> personnages = new ArrayList<>();

			for (int i = 0; i < liste.size(); i++) {
				String ligne = liste.get(i);
				for (int j = 0; j < ligne.length(); j++) {
					String character = "" + ligne.charAt(j);
					if (StringUtils.equals(character, "#")) {
						map[j][i] = new Case(j, i, true);
					} else if (StringUtils.equals(character, ".")) {
						map[j][i] = new Case(j, i, false);
					} else if (StringUtils.equalsIgnoreCase(character, "G")) {
						map[j][i] = new Case(j, i, false);
						Gobelin gobelin = new Gobelin(map[j][i]);
						personnages.add(gobelin);
					} else if (StringUtils.equalsIgnoreCase(character, "E")) {
						map[j][i] = new Case(j, i, false);
						Elfe elfe = new Elfe(map[j][i], degatsElfe);
						personnages.add(elfe);
					}
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (j > 0) {
						map[i][j].getCasesAdjacentes().add(map[i][j - 1]);
					}
					if (i > 0) {
						map[i][j].getCasesAdjacentes().add(map[i - 1][j]);
					}
					if (i < map.length - 1) {
						map[i][j].getCasesAdjacentes().add(map[i + 1][j]);
					}
					if (j < map[0].length - 1) {
						map[i][j].getCasesAdjacentes().add(map[i][j + 1]);
					}
				}
			}

			int round = 0;
			boolean fullRound = true;
			a: while (fullRound) {
				// afficher(map, round);
				Collections.sort(personnages);
				for (int i = 0; i < personnages.size(); i++) {
					if (!resteEnnemis(personnages)) {
						fullRound = false;
						break;
					}
					Personnage p = personnages.get(i);
					p.jouer(personnages);
					for (int j = 0; j < personnages.size(); j++) {
						if (personnages.get(j).getPv() <= 0) {
							if (personnages.get(j) instanceof Elfe) {
								elfeMort = true;
								break a;
							}
							personnages.get(j).getEmplacement().setPersonnage(null);
							personnages.get(j).setEmplacement(null);
							personnages.remove(j);
							if (j < i) {
								i--;
							}
							j--;
						}
					}
				}
				if (fullRound) {
					round++;
				}
			}
			// afficher(map, round);
			int pvRestants = 0;
			for (int i = 0; i < personnages.size(); i++) {
				pvRestants += personnages.get(i).getPv();
			}
			System.out.println(pvRestants);
			System.out.println(round * pvRestants);
		} while (elfeMort);
		System.out.println(degatsElfe);
		long fin = System.currentTimeMillis();
		System.out.println("********** Le batch se termine **********");
		System.out.println("Le batch a dur� : " + DurationFormatUtils.formatDuration(fin - debut, "HH:mm:ss:SSS", true));
		return "";
	}

	private static void afficher(Case[][] map, int round) {
		for (int i = 0; i < map.length; i++) {
			List<Integer> pvs = new ArrayList<>();
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[j][i]);
				if (map[j][i].getPersonnage() != null) {
					pvs.add(map[j][i].getPersonnage().getPv());
				}
			}
			for (Integer integer : pvs) {
				System.out.print("  " + integer);
			}
			System.out.println();
		}
		System.out.println(round);
	}

	private static boolean resteEnnemis(List<Personnage> personnages) {
		boolean elfe = false;
		boolean gobelin = false;
		for (Personnage personnage : personnages) {
			if (personnage instanceof Elfe) {
				elfe = true;
			} else if (personnage instanceof Gobelin) {
				gobelin = true;
			}
		}
		return elfe && gobelin;
	}

}
