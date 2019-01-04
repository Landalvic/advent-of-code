package annee.annee2018.jour10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour10Exercice2 {

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

		int secondes = 0;
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
				secondes++;
			}
		}
		System.out.println(secondes);
	}

}
