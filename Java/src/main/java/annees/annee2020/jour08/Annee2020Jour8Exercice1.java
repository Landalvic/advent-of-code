package annees.annee2020.jour08;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour8Exercice1 extends Annee2020Jour8 {

	public static void main(String[] args) {
		new Annee2020Jour8Exercice1().lancer(2020, 8, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Taches taches = new Taches(inputToListObject(input));
		while (!taches.getIndex().isTest()) {
			taches.getIndex().setTest(true);
			taches.getIndex().run(taches.getDonnees());
		}
		return String.valueOf(taches.getDonnees().getAccumulateur());
	}

}
