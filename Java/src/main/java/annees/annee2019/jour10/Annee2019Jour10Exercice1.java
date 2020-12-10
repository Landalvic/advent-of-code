package annees.annee2019.jour10;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour10Exercice1 extends Annee2019Jour10 {

	public static void main(String[] args) {
		new Annee2019Jour10Exercice1().lancer(2019, 10, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var asteroids = inputToAsteroid(input);
		return String.valueOf(asteroids.stream().mapToInt(asteroid -> asteroid.calculerVision(asteroids)).max().getAsInt());
	}

}
