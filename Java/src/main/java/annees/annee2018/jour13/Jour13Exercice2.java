package annees.annee2018.jour13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.util.FileUtils;

public class Jour13Exercice2 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour13/data.txt");

		String[][] map = new String[liste.get(0).length() + 1][liste.size() + 1];
		List<Voiture> voitures = new ArrayList<>();
		for (int i = 0; i < liste.size(); i++) {
			String ligne = liste.get(i);
			for (int j = 0; j < ligne.length(); j++) {
				String character = "" + ligne.charAt(j);
				if (StringUtils.equals(character, "^")) {
					voitures.add(new Voiture(j, i, Direction.HAUT));
					map[j][i] = "|";
				} else if (StringUtils.equalsIgnoreCase(character, "v")) {
					voitures.add(new Voiture(j, i, Direction.BAS));
					map[j][i] = "|";
				} else if (StringUtils.equals(character, "<")) {
					voitures.add(new Voiture(j, i, Direction.GAUCHE));
					map[j][i] = "-";
				} else if (StringUtils.equalsIgnoreCase(character, ">")) {
					voitures.add(new Voiture(j, i, Direction.DROITE));
					map[j][i] = "-";
				}
				map[j][i] = character;
			}
		}

		boolean fin = false;
		while (!fin) {
			Collections.sort(voitures);
			if (!fin) {
				for (int i = 0; i < voitures.size(); i++) {
					Voiture voiture = voitures.get(i);
					switch (voiture.getDirection()) {
					case HAUT:
						voiture.setPositionY(voiture.getPositionY() - 1);
						String s = map[voiture.getPositionX()][voiture.getPositionY()];
						if (StringUtils.equals(s, "/")) {
							voiture.setDirection(Direction.DROITE);
						} else if (StringUtils.equals(s, "\\")) {
							voiture.setDirection(Direction.GAUCHE);
						} else if (StringUtils.equals(s, "+")) {
							voiture.reagirIntersection();
						}
						break;
					case BAS:
						voiture.setPositionY(voiture.getPositionY() + 1);
						s = map[voiture.getPositionX()][voiture.getPositionY()];
						if (StringUtils.equals(s, "/")) {
							voiture.setDirection(Direction.GAUCHE);
						} else if (StringUtils.equals(s, "\\")) {
							voiture.setDirection(Direction.DROITE);
						} else if (StringUtils.equals(s, "+")) {
							voiture.reagirIntersection();
						}
						break;
					case GAUCHE:
						voiture.setPositionX(voiture.getPositionX() - 1);
						s = map[voiture.getPositionX()][voiture.getPositionY()];
						if (StringUtils.equals(s, "/")) {
							voiture.setDirection(Direction.BAS);
						} else if (StringUtils.equals(s, "\\")) {
							voiture.setDirection(Direction.HAUT);
						} else if (StringUtils.equals(s, "+")) {
							voiture.reagirIntersection();
						}
						break;
					case DROITE:
						voiture.setPositionX(voiture.getPositionX() + 1);
						s = map[voiture.getPositionX()][voiture.getPositionY()];
						if (StringUtils.equals(s, "/")) {
							voiture.setDirection(Direction.HAUT);
						} else if (StringUtils.equals(s, "\\")) {
							voiture.setDirection(Direction.BAS);
						} else if (StringUtils.equals(s, "+")) {
							voiture.reagirIntersection();
						}
						break;
					default:
						break;
					}
					for (int j = 0; j < voitures.size(); j++) {
						Voiture voiture2 = voitures.get(j);
						if (voiture2 != voiture && voiture2.getPositionX() == voiture.getPositionX()
								&& voiture2.getPositionY() == voiture.getPositionY()) {
							voitures.remove(voiture2);
							voitures.remove(voiture);
							if (j < i) {
								i -= 2;
							} else {
								i--;
							}
							if (voitures.size() == 1) {
								fin = true;
							}
						}
					}
				}
			}
		}
		System.out.println(voitures.get(0).getPositionX() + "," + voitures.get(0).getPositionY());
	}

}
