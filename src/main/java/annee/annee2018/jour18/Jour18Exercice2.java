package annee.annee2018.jour18;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Jour18Exercice2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		List<String> liste = FileUtils.lireFichier("./jour18/data.txt");

		Acre[][] map = new Acre[liste.get(0).length()][liste.size()];

		for (int i = 0; i < liste.size(); i++) {
			String ligne = liste.get(i);
			for (int j = 0; j < ligne.length(); j++) {
				String character = "" + ligne.charAt(j);
				if (StringUtils.equals(character, "|")) {
					map[j][i] = new Acre(Type.ARBRE);
				} else if (StringUtils.equals(character, ".")) {
					map[j][i] = new Acre(Type.OUVERT);
				} else if (StringUtils.equalsIgnoreCase(character, "#")) {
					map[j][i] = new Acre(Type.COURS_A_BOIS);
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				for (int k = -1; k < 2; k++) {
					for (int l = -1; l < 2; l++) {
						if (i + k >= 0 && j + l >= 0 && i + k < map.length && j + l < map[0].length
								&& (k != 0 || l != 0)) {
							map[i][j].getAcresAdjacentes().add(map[i + k][j + l]);
						}
					}
				}
			}
		}

		List<Integer> resultats = new ArrayList<>();
		int nbrReapparition = 0;
		int minutesFin = 1000000000;
		for (int minutes = 0; minutes < 1000000000; minutes++) {

			int nbrArbres1 = 0;
			int nbrCoursABois1 = 0;
			for (int j = 0; j < map[0].length; j++) {
				for (int i = 0; i < map.length; i++) {
					if (map[i][j].getType() == Type.COURS_A_BOIS) {
						nbrCoursABois1++;
					} else if (map[i][j].getType() == Type.ARBRE) {
						nbrArbres1++;
					}
				}
			}
			if (resultats.contains(Integer.valueOf(nbrArbres1 * nbrCoursABois1))) {
				if (nbrReapparition < 20) {
					nbrReapparition++;
					resultats.clear();
				} else {
					minutesFin = minutes;
					break;
				}
			}
			resultats.add(nbrArbres1 * nbrCoursABois1);

			boolean aucunChangement = true;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j].getType() != map[i][j].getTypeSauvegarde()) {
						aucunChangement = false;
					}
					map[i][j].setTypeSauvegarde(map[i][j].getType());
				}
			}
			if (aucunChangement) {
				break;
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					switch (map[i][j].getTypeSauvegarde()) {
					case OUVERT:
						int nbrArbres = 0;
						for (Acre acre : map[i][j].getAcresAdjacentes()) {
							if (acre.getTypeSauvegarde() == Type.ARBRE) {
								nbrArbres++;
							}
						}
						if (nbrArbres >= 3) {
							map[i][j].setType(Type.ARBRE);
						}
						break;
					case ARBRE:
						int nbrCoursABois = 0;
						for (Acre acre : map[i][j].getAcresAdjacentes()) {
							if (acre.getTypeSauvegarde() == Type.COURS_A_BOIS) {
								nbrCoursABois++;
							}
						}
						if (nbrCoursABois >= 3) {
							map[i][j].setType(Type.COURS_A_BOIS);
						}
						break;
					case COURS_A_BOIS:
						boolean arbre = false;
						boolean coursABois = false;
						for (Acre acre : map[i][j].getAcresAdjacentes()) {
							if (acre.getTypeSauvegarde() == Type.COURS_A_BOIS) {
								coursABois = true;
							} else if (acre.getTypeSauvegarde() == Type.ARBRE) {
								arbre = true;
							}
						}
						if (arbre && coursABois) {
							map[i][j].setType(Type.COURS_A_BOIS);
						} else {
							map[i][j].setType(Type.OUVERT);
						}
						break;
					default:
						break;
					}
				}
			}
		}

		System.out.println(resultats.get((1000000000 - minutesFin) % resultats.size()));
	}

}
