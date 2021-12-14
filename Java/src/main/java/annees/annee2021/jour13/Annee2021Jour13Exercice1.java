package annees.annee2021.jour13;

import java.util.HashSet;
import java.util.Set;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2021Jour13Exercice1 extends Annee2021Jour13 {

	public static void main(String[] args) {
		new Annee2021Jour13Exercice1().lancer(true);
	}

	public Annee2021Jour13Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = inputToListObjectNotNull(input);
		Set<Position> positions = new HashSet<>();
		for (var i : stream) {
			positions = i.run(positions);
			if (i instanceof Pliage) {
				return "" + positions.size();
			}
		}
		return "";
	}

}
