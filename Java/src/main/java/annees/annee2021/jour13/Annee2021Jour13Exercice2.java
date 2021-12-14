package annees.annee2021.jour13;

import java.util.HashSet;
import java.util.Set;

import commun.Position;
import commun.structure.AdventOfCodeException;

public class Annee2021Jour13Exercice2 extends Annee2021Jour13 {

	public static void main(String[] args) {
		new Annee2021Jour13Exercice2().lancer(true);
	}

	public Annee2021Jour13Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = inputToListObjectNotNull(input);
		Set<Position> positions = new HashSet<>();
		for (var i : stream) {
			positions = i.run(positions);
		}
		var minX = positions.stream().mapToInt(p -> (int) p.getX()).min().orElseThrow();
		var maxX = positions.stream().mapToInt(p -> (int) p.getX()).max().orElseThrow();
		var minY = positions.stream().mapToInt(p -> (int) p.getY()).min().orElseThrow();
		var maxY = positions.stream().mapToInt(p -> (int) p.getY()).max().orElseThrow();
		System.out.println();
		for (int i = minY; i <= maxY; i++) {
			for (int j = minX; j <= maxX; j++) {
				if (positions.contains(new Position(j, i))) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		return "";
	}

}
