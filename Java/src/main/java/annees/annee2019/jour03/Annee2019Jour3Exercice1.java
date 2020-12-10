package annees.annee2019.jour03;

import java.util.List;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2019Jour3Exercice1 extends Annee2019Jour3 {

	public static void main(String[] args) {
		new Annee2019Jour3Exercice1().lancer(2019, 3, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<List<Wire>> wires = inputToWires(input);
		Position min = null;
		for (Wire wire : wires.get(0)) {
			for (Wire wire2 : wires.get(1)) {
				Position intersect = wire.pointOfIntersectionSegmentWithoutLimit(wire2);
				if (intersect != null && (min == null || intersect.distanceFromCenter() < min.distanceFromCenter())) {
					min = intersect;
				}
			}
		}
		if (min == null) {
			throw new AdventOfCodeException("aucun croisement trouvé");
		}
		return String.valueOf((int) min.distanceFromCenter());
	}

}
