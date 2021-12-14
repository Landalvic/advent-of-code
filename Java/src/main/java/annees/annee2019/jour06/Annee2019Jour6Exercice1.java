package annees.annee2019.jour06;

import commun.Hierarchie;
import commun.Hierarchies;
import commun.Infos;
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
		Hierarchies<Infos> orbites = inputToOrbites(input);
		return String.valueOf(orbites.listeHierarchie().stream().mapToInt(Hierarchie::nombreParentsRecursif).sum());
	}

}
