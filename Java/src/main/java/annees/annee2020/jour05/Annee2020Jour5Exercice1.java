package annees.annee2020.jour05;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour5Exercice1 extends Annee2020Jour5 {

	public static void main(String[] args) {
		new Annee2020Jour5Exercice1().lancer(true);
	}

	public Annee2020Jour5Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		return String.valueOf(inputToStreamObject(input).mapToInt(i -> i).max().orElseThrow());
	}

}
