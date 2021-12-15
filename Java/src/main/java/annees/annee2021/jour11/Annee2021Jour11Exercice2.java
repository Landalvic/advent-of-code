package annees.annee2021.jour11;

import commun.structure.AdventOfCodeException;

public class Annee2021Jour11Exercice2 extends Annee2021Jour11 {

	public static void main(String[] args) {
		new Annee2021Jour11Exercice2().lancer(true);
	}

	public Annee2021Jour11Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var map = inputToMap(input, false);
		for (int i = 1; true; i++) {
			map.listeAllCase().forEach(Pieuvre::augmenterNombre);
			map.listeAllCase().forEach(Pieuvre::clignoter);
			if (map.listeAllCase().stream().filter(Pieuvre::reinit).count() == map.listeAllCase().size()) {
				return String.valueOf(i);
			}
		}
	}

}
