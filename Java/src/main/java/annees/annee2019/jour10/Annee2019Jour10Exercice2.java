package annees.annee2019.jour10;

import java.util.Collections;
import java.util.List;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour10Exercice2 extends Annee2019Jour10 {

	public static void main(String[] args) {
		new Annee2019Jour10Exercice2().lancer(2019, 10, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var asteroids = inputToAsteroid(input);
		Asteroid meilleur = asteroids.stream().max((Asteroid o1, Asteroid o2) -> Integer.compare(o1.calculerVision(asteroids), o2.calculerVision(asteroids)))
				.orElseThrow();
		List<Asteroid> aPulveriser = meilleur.listeVision(asteroids);
		Collections.sort(aPulveriser, (Asteroid o1, Asteroid o2) -> -Double.compare(o1.angle(meilleur), o2.angle(meilleur)));
		return String.valueOf((int) (aPulveriser.get(199).getPosition().getX() * 100 + aPulveriser.get(199).getPosition().getY()));
	}

}
