package annees.annee2019.jour10;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.Position;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour10 extends Exercice {

	protected List<Asteroid> inputToAsteroid(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		List<Asteroid> asteroids = new ArrayList<>();
		for (int i = 0; i < lignes.size(); i++) {
			for (int j = 0; j < lignes.get(0).length(); j++) {
				if (StringUtils.equals(String.valueOf(lignes.get(i).charAt(j)), "#")) {
					asteroids.add(new Asteroid(new Position(j, i)));
				}
			}
		}
		return asteroids;
	}

}
