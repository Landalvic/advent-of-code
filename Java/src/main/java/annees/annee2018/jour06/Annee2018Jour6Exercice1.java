package annees.annee2018.jour06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2018Jour6Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2018Jour6Exercice1().lancer("src/main/resources/annee2018/jour06/data.txt");
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
		for (String string : liste) {
			int x = FileUtils.trouverPatternInt(string, xPattern);
			int y = FileUtils.trouverPatternInt(string, yPattern);
			map[x - minX][y - minY] = new Emplacement();
			map[x - minX][y - minY].genererId();
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == null) {
					Emplacement depart = new Emplacement();
					List<Integer> plusProches = new ArrayList<>();
					for (int k = 1; k < map.length; k++) {
						for (int l = 0; l < k; l++) {
							ajouterSiExiste(map, plusProches, i + l, j + k - l);
							ajouterSiExiste(map, plusProches, i + k - l, j - l);
							ajouterSiExiste(map, plusProches, i - l, j - k + l);
							ajouterSiExiste(map, plusProches, i - k + l, j + l);
						}
						if (plusProches.size() > 0) {
							break;
						}
					}
					if (plusProches.size() == 1) {
						depart.setIdPlusProche(plusProches.get(0));
					}
					map[i][j] = depart;
				}
			}
		}
		Set<Integer> bords = new HashSet<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (i == 0 || j == 0 || i == map.length - 1 || j == map[0].length - 1) {
					bords.add(map[i][j].getIdPlusProche());
				}
			}
		}
		HashMap<Integer, AtomicInteger> hashMap = new HashMap<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (!bords.contains(map[i][j].getIdPlusProche())) {
					hashMap.putIfAbsent(map[i][j].getIdPlusProche(), new AtomicInteger());
					hashMap.get(map[i][j].getIdPlusProche()).incrementAndGet();
				}
			}
		}
		int plusGrande = 0;
		for (AtomicInteger zone : hashMap.values()) {
			if (plusGrande < zone.get()) {
				plusGrande = zone.get();
			}
		}
		System.out.println(plusGrande);
		return String.valueOf(plusGrande);
	}

	private static void ajouterSiExiste(Emplacement[][] map, List<Integer> plusProches, int x, int y) {
		if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
			Emplacement e = map[x][y];
			if (e != null && e.getId() != null) {
				plusProches.add(e.getId());
			}
		}
	}

}
