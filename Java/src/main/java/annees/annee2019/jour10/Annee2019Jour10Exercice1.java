package annees.annee2019.jour10;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2019Jour10Exercice1 extends Annee2019Jour10 {

	public static void main(String[] args) {
		new Annee2019Jour10Exercice1().lancer("src/main/resources/annee2019/jour10/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		Asteroid[][] asteroids = new Asteroid[lignes.get(0).length()][lignes.size()];
		for (int i = 0; i < lignes.size(); i++) {
			for (int j = 0; j < lignes.get(0).length(); j++) {
				if (StringUtils.equals("" + lignes.get(i).charAt(j), "#")) {
					asteroids[j][i] = new Asteroid(j, i);
				}
			}
		}
		int max = 0;
		Asteroid meilleur = null;
		for (int i = 0; i < asteroids.length; i++) {
			for (int j = 0; j < asteroids[0].length; j++) {
				if (asteroids[i][j] != null) {
					int vision = asteroids[i][j].calculerVision(asteroids);
					System.out.println(vision);
					if (vision > max) {
						meilleur = asteroids[i][j];
						max = vision;
					}
				}
			}
		}
		System.out.println(meilleur);
		System.out.println(max);
		return "";
	}

}
