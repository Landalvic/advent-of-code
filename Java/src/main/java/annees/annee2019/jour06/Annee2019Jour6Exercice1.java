package annees.annee2019.jour06;

import java.util.Map;

import commun.Hierarchie;
import commun.structure.AdventOfCodeException;

public class Annee2019Jour6Exercice1 extends Annee2019Jour6 {

	public static void main(String[] args) {
		new Annee2019Jour6Exercice1().lancer(true);
	}

	public Annee2019Jour6Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Map<String, Hierarchie> orbites = inputToOrbites(input);
		return String.valueOf(orbites.entrySet().stream().mapToInt(orbite -> orbite.getValue().nombreParentsRecursif()).sum());
	}

}
