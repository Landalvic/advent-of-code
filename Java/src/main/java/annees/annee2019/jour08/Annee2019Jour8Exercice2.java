package annees.annee2019.jour08;

import java.util.ArrayList;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour8Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour8Exercice2().lancer("src/main/resources/annee2019/jour08/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		int wide = 25;
		int tall = 6;
		List<List<List<Integer>>> pixels = new ArrayList<>();
		for (int i = 0; i < ligne.length();) {
			List<List<Integer>> couche = new ArrayList<>();
			for (int j = 0; j < tall; j++) {
				List<Integer> couche2 = new ArrayList<>();
				for (int k = 0; k < wide; k++) {
					couche2.add(Integer.parseInt("" + ligne.charAt(i)));
					i++;
				}
				couche.add(couche2);
			}
			pixels.add(couche);
		}
		int[][] image = new int[tall][wide];
		for (int i = 0; i < tall; i++) {
			for (int k = 0; k < wide; k++) {
				for (int j = 0; j < pixels.size(); j++) {
					int pixel = pixels.get(j).get(i).get(k);
					if (pixel != 2) {
						image[i][k] = pixel;
						break;
					}
				}
			}
		}
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				if (image[i][j] == 0) {
					System.out.print(" ");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
		return "";
	}

}
