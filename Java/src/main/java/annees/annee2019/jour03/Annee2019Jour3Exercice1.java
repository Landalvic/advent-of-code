package annees.annee2019.jour03;

import java.util.List;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2019Jour3Exercice1 extends Annee2019Jour3 {

	public static void main(String[] args) {
		new Annee2019Jour3Exercice1().lancer(true);
	}

	public Annee2019Jour3Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<List<Wire>> wires = inputToListObject(input);
		double min = Integer.MAX_VALUE;
		for (Wire wire : wires.get(0)) {
			for (Wire wire2 : wires.get(1)) {
				Position intersect = wire.pointOfIntersectionSegmentWithoutLimit(wire2);
				if (intersect != null) {
					min = Math.min(intersect.distanceFromCenter(), min);
				}
			}
		}
		return String.valueOf((int) min);
	}

}
