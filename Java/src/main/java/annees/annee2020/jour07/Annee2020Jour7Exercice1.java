package annees.annee2020.jour07;

import commun.Hierarchie;
import commun.structure.AdventOfCodeException;

public class Annee2020Jour7Exercice1 extends Annee2020Jour7 {

	public static void main(String[] args) {
		new Annee2020Jour7Exercice1().lancer(2020, 7, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		inputToListObject(input);
		Hierarchie notre = hierarchies.trouver("shiny gold");
		return String.valueOf(notre.parentsRecursif().size());
	}

}
