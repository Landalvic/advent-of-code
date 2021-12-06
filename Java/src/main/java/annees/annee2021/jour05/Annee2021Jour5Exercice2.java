package annees.annee2021.jour05;

import commun.structure.AdventOfCodeException;

public class Annee2021Jour5Exercice2 extends Annee2021Jour5 {

	public static void main(String[] args) {
		new Annee2021Jour5Exercice2().lancer(true);
	}

	public Annee2021Jour5Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var vecteurs = inputToStreamObject(input);
		return commun(vecteurs);
	}

}
