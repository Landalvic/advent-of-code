package annees.annee2021.jour05;

import commun.structure.AdventOfCodeException;

public class Annee2021Jour5Exercice1 extends Annee2021Jour5 {

	public static void main(String[] args) {
		new Annee2021Jour5Exercice1().lancer(true);
	}

	public Annee2021Jour5Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var vecteurs = inputToStreamObject(input);
		return commun(vecteurs.filter(v -> v.isHorizontal() || v.isVertical()));
	}

}
