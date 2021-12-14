package annees.annee2021.jour09;

import commun.structure.AdventOfCodeException;

public class Annee2021Jour9Exercice1 extends Annee2021Jour9 {

	public static void main(String[] args) {
		new Annee2021Jour9Exercice1().lancer(true);
	}

	public Annee2021Jour9Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var map = inputToMap(input);
		return String.valueOf(map.listeAllCase()
				.stream()
				.filter(c -> c.getCasesAdjacentes().stream().noneMatch(adj -> adj.getId() <= c.getId()))
				.mapToInt(c -> c.getId() + 1)
				.sum());
	}

}
