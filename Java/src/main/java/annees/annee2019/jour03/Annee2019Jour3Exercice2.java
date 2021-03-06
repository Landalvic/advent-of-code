package annees.annee2019.jour03;

import java.util.List;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2019Jour3Exercice2 extends Annee2019Jour3 {

	public static void main(String[] args) {
		new Annee2019Jour3Exercice2().lancer(true);
	}

	public Annee2019Jour3Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<List<Wire>> wires = inputToListObject(input);
		double minDistance = Double.MAX_VALUE;
		for (Wire wire : wires.get(0)) {
			for (Wire wire2 : wires.get(1)) {
				Position intersect = wire.pointOfIntersectionSegmentWithoutLimit(wire2);
				if (intersect != null) {
					minDistance = Math.min(wire.calculDistance(intersect) + wire2.calculDistance(intersect), minDistance);
				}
			}
		}
		return String.valueOf((int) minDistance);
	}

}
