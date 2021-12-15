package annees.annee2021.jour11;

import commun.structure.AdventOfCodeException;

public class Annee2021Jour11Exercice1 extends Annee2021Jour11 {

	public static void main(String[] args) {
		new Annee2021Jour11Exercice1().lancer(true);
	}

	public Annee2021Jour11Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var map = inputToMap(input, true);
		long total = 0;
		for (int i = 0; i < 100; i++) {
			map.listeAllCase().forEach(Pieuvre::augmenterNombre);
			map.listeAllCase().forEach(Pieuvre::clignoter);
			total += map.listeAllCase().stream().filter(Pieuvre::reinit).count();
		}
		return String.valueOf(total);
	}

}
