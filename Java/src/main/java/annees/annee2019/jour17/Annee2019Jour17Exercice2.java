package annees.annee2019.jour17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour17Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour17Exercice2().lancer("src/main/resources/annee2019/jour17/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		code.getBlocs()[0] = "2";
		List<List<Case>> map = new ArrayList<List<Case>>();
		List<Case> ligneEnCours = new ArrayList<Case>();
		map.add(ligneEnCours);
		int x = 0;
		int y = 0;
		List<Long> phrase = new ArrayList<Long>();
		while (!code.isFini()) {
			Long retour = code.lancer();
			Case c = new Case(x, y);
			if (retour == null) {
				break;
			} else if (retour.intValue() == 35) {
				c.setEchafaudage(true);
				ajouterCase(map, ligneEnCours, c);
				x++;
			} else if (retour.intValue() == 46) {
				ajouterCase(map, ligneEnCours, c);
				x++;
			} else if (retour.intValue() == 10) {
				y++;
				x = 0;
				ligneEnCours = new ArrayList<Case>();
				map.add(ligneEnCours);
			} else if (retour.intValue() == 94) {
				c.setEchafaudage(true);
				ajouterCase(map, ligneEnCours, c);
				x++;
			} else if (retour.intValue() == 58) {
				break;
			} else {
				phrase.add(retour);
			}
		}
		System.out.println(code.lireAscii(phrase));
		var inputs = new ArrayList<>(Arrays.asList(110L, 10L));
		code.lancer(inputs);
		inputs = new ArrayList<>(Arrays.asList(65L, 44L, 65L, 44L, 66L, 44L, 66L, 44L, 67L, 44L, 66L, 44L, 67L, 44L,
				66L, 44L, 67L, 44L, 65L, 10L));
		var retour3 = code.lancerAttendreInput(inputs);
		System.out.println(code.lireAscii(retour3));
		inputs = new ArrayList<>(Arrays.asList(76L, 44L, 49L, 48L, 44L, 76L, 44L, 49L, 48L, 44L, 82L, 44L, 54L, 10L));
		retour3 = code.lancerAttendreInput(inputs);
		System.out.println(code.lireAscii(retour3));
		inputs = new ArrayList<>(
				Arrays.asList(82L, 44L, 49L, 50L, 44L, 76L, 44L, 49L, 50L, 44L, 76L, 44L, 49L, 50L, 10L));
		retour3 = code.lancerAttendreInput(inputs);
		System.out.println(code.lireAscii(retour3));
		inputs = new ArrayList<>(Arrays.asList(76L, 44L, 54L, 44L, 76L, 44L, 49L, 48L, 44L, 82L, 44L, 49L, 50L, 44L,
				82L, 44L, 49L, 50L, 10L));
		retour3 = code.lancerAttendreInput(inputs);
		System.out.println(code.lireAscii(retour3));
		inputs = new ArrayList<>(Arrays.asList(110L, 10L));
		retour3 = code.lancerAttendreInput(inputs);
		return "" + retour3.get(retour3.size() - 1);
	}

	public void visualiserMap(List<List<Case>> map, Robot robot) {
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.get(i).size(); j++) {
				if (robot.getY() == i && robot.getX() == j) {
					System.out.print("^");
				} else {
					Case case1 = map.get(i).get(j);
					if (case1.isEchafaudage()) {
						System.out.print("X");
					} else {
						System.out.print(".");
					}
				}
			}
			System.out.println();
		}
	}

	private void ajouterCase(List<List<Case>> map, List<Case> ligneEnCours, Case c) {
		ligneEnCours.add(c);
		if (c.getPositionX() >= 1) {
			c.setOuest(ligneEnCours.get(ligneEnCours.size() - 2));
		}
		if (c.getPositionY() >= 1) {
			if (c.getPositionX() < map.get(c.getPositionY() - 1).size()) {
				c.setNord(map.get(c.getPositionY() - 1).get(c.getPositionX()));
			}
		}
	}

}
