package annees.annee2020.jour07;

import commun.Hierarchie;
import commun.structure.AdventOfCodeException;

public class Annee2020Jour7Exercice1 extends Annee2020Jour7 {

	public static void main(String[] args) {
		new Annee2020Jour7Exercice1().lancer(true);
	}

	public Annee2020Jour7Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		inputToListObject(input);
		Hierarchie notre = hierarchies.trouver("shiny gold");
		return String.valueOf(notre.parentsRecursif().size());
	}

}
