package annees.annee2018.jour06;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2018Jour6Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2018Jour6Exercice2().lancer("src/main/resources/annee2018/jour06/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		Pattern xPattern = Pattern.compile("(.*), .*");
		Pattern yPattern = Pattern.compile(".*, (.*)");

		int minX = 1000;
		int maxX = 0;
		int minY = 1000;
		int maxY = 0;
		for (String string : liste) {
			int x = FileUtils.trouverPatternInt(string, xPattern);
			int y = FileUtils.trouverPatternInt(string, yPattern);
			if (minX > x) {
				minX = x;
			}
			if (maxX < x) {
				maxX = x;
			}
			if (minY > y) {
				minY = y;
			}
			if (maxY < y) {
				maxY = y;
			}
		}
		Emplacement[][] map = new Emplacement[maxX - minX + 1][maxY - minY + 1];
		List<Repere> reperes = new ArrayList<>(liste.size());
		for (String string : liste) {
			int x = FileUtils.trouverPatternInt(string, xPattern);
			int y = FileUtils.trouverPatternInt(string, yPattern);
			map[x - minX][y - minY] = new Emplacement();
			map[x - minX][y - minY].genererId();
			reperes.add(new Repere(x - minX, y - minY));
		}
		int zone = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				int distanceTotale = 0;
				for (Repere repere : reperes) {
					distanceTotale += Math.abs(i - repere.getPositionX()) + Math.abs(j - repere.getPositionY());
				}
				if (distanceTotale < 10000) {
					zone++;
				}
			}
		}
		System.out.println(zone);
		return String.valueOf(zone);
	}

}
