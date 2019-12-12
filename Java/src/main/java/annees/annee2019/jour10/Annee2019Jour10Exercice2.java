package annees.annee2019.jour10;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour10Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour10Exercice2().lancer("src/main/resources/annee2019/jour10/data.txt");
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

		System.out.println(new Asteroid(10, -10).angle());
		System.out.println(new Asteroid(10, 10).angle());
		System.out.println(new Asteroid(-10, 10).angle());
		System.out.println(new Asteroid(-10, -10).angle());

		List<Asteroid> pulv = meilleur.listeVision(asteroids);
		for (Asteroid asteroid : pulv) {
			asteroid.setX2(asteroid.getX() - meilleur.getX());
			asteroid.setY2(asteroid.getY() - meilleur.getY());
		}
		System.out.println(meilleur.compareTo(meilleur));
		Collections.sort(pulv);
		return pulv.get(199).toString();
	}

}
