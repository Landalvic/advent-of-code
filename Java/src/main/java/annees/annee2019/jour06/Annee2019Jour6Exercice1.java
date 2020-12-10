package annees.annee2019.jour06;

import java.util.Map;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour6Exercice1 extends Annee2019Jour6 {

	public static void main(String[] args) {
		new Annee2019Jour6Exercice1().lancer(2019, 6, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Map<String, Orbite> orbites = inputToOrbites(input);
		return String.valueOf(
				orbites.entrySet().stream().mapToInt(orbite -> orbite.getValue().nombreParentsRecursif()).sum());
	}

}
