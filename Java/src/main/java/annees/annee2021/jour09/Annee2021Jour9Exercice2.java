package annees.annee2021.jour09;

import java.util.Collections;

import commun.structure.AdventOfCodeException;

public class Annee2021Jour9Exercice2 extends Annee2021Jour9 {

	public static void main(String[] args) {
		new Annee2021Jour9Exercice2().lancer(true);
	}

	public Annee2021Jour9Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var map = inputToMap(input);
		return String.valueOf(map.listeAllCase().stream()
				.filter(c -> c.getCasesAdjacentes().stream().noneMatch(adj -> adj.getId() <= c.getId()))
				.map(c -> c.deplacementsDisponible().size())
				.sorted(Collections.reverseOrder())
				.limit(3)
				.mapToInt(i -> i)
				.reduce(1, (a, b) -> a * b));
	}

}
