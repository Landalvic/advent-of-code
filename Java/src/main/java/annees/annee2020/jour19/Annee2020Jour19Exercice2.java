package annees.annee2020.jour19;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour19Exercice2 extends Annee2020Jour19 {

	public static void main(String[] args) {
		new Annee2020Jour19Exercice2().lancer(true);
	}

	public Annee2020Jour19Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		chargerInput(input);
		return String.valueOf(messages.stream().filter(message -> rules.get(0).accepterMessage(rules, message)).count());
	}

}
