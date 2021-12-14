package annees.annee2020.jour08;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour8Exercice1 extends Annee2020Jour8 {

	public static void main(String[] args) {
		new Annee2020Jour8Exercice1().lancer(true);
	}

	public Annee2020Jour8Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Taches taches = new Taches(inputToListObject(input));
		while (!taches.getIndex().isRunned()) {
			taches.getIndex().setRunned(true);
			taches.getIndex().run(taches.getDonnees());
		}
		return String.valueOf(taches.getDonnees().getAccumulateur());
	}

}
