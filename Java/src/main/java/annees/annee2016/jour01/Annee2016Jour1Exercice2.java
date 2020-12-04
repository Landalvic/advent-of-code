package annees.annee2016.jour01;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Direction;
import commun.Position;
import util.FileUtils;

public class Annee2016Jour1Exercice2 extends Annee2016Jour1 {

	public static void main(String[] args) {
		new Annee2016Jour1Exercice2().lancer(2016, 1, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		String chemin = FileUtils.firstLine(input);
		Set<Position> positions = new HashSet<>();
		var blocs = chemin.split(",", -1);
		Direction direction = Direction.HAUT;
		Position position = new Position(0, 0);
		positions.add(new Position(position));
		for (String string : blocs) {
			String lettre = String.valueOf(string.trim().charAt(0));
			Integer chiffre = Integer.valueOf(String.valueOf(string.trim().substring(1)));
			direction = direction.tourner(StringUtils.equals(lettre, "L"));
			for (int i = 0; i < chiffre; i++) {
				position.bouger(direction, 1);
				if (!positions.add(new Position(position))) {
					return String.valueOf((int) position.distanceFromCenter());
				}
			}
		}
		return String.valueOf((int) position.distanceFromCenter());
	}

}
