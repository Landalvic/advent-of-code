package annee.annee2018.jour10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour10Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour10/data.txt");
		Pattern positionPattern = Pattern.compile("position=<(.*)> velocity.*");
		Pattern velocitePattern = Pattern.compile(".*velocity=<(.*)>");
		List<Lumiere> lignes = new ArrayList<>(liste.size());
		for (String string : liste) {
			String[] position = FileUtils.trouverPattern(string, positionPattern).split(",");
			String[] velocite = FileUtils.trouverPattern(string, velocitePattern).split(",");
			lignes.add(new Lumiere(Integer.valueOf(position[0].trim()), Integer.valueOf(position[1].trim()),
					Integer.valueOf(velocite[0].trim()), Integer.valueOf(velocite[1].trim())));
		}

		boolean message = false;
		while (!message) {
			HashMap<Integer, List<Lumiere>> test = new HashMap<>();
			for (Lumiere lumiere : lignes) {
				test.putIfAbsent(lumiere.getPositionX(), new ArrayList<>());
				test.get(lumiere.getPositionX()).add(lumiere);
			}
			for (List<Lumiere> lumieres : test.values()) {
				if (lumieres.size() >= 8) {
					Collections.sort(lumieres);
					int yPrecedent = lumieres.get(0).getPositionY();
					int aligne = 1;
					for (int i = 1; i < lumieres.size(); i++) {
						if (yPrecedent == lumieres.get(i).getPositionY() - 1) {
							yPrecedent = lumieres.get(i).getPositionY();
							aligne++;
						} else if (yPrecedent != lumieres.get(i).getPositionY()) {
							break;
						}
					}
					if (aligne >= 8) {
						message = true;
					}
				}
			}
			if (!message) {
				for (Lumiere lumiere : lignes) {
					lumiere.bouger();
				}
			}
		}

		int xMin = 99999;
		int xMax = 0;
		int yMin = 99999;
		int yMax = 0;
		for (Lumiere lumiere : lignes) {
			if (xMin > lumiere.getPositionX()) {
				xMin = lumiere.getPositionX();
			}
			if (xMax < lumiere.getPositionX()) {
				xMax = lumiere.getPositionX();
			}
			if (yMin > lumiere.getPositionY()) {
				yMin = lumiere.getPositionY();
			}
			if (yMax < lumiere.getPositionY()) {
				yMax = lumiere.getPositionY();
			}
		}
		boolean[][] ciel = new boolean[yMax - yMin + 1][xMax - xMin + 1];
		for (Lumiere lumiere : lignes) {
			ciel[lumiere.getPositionY() - yMin][lumiere.getPositionX() - xMin] = true;
		}
		for (boolean[] bs : ciel) {
			for (boolean b : bs) {
				if (b) {
					System.out.print("#");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

}
