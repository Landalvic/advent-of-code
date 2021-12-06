package annees.annee2021.jour04;

import java.util.concurrent.atomic.AtomicInteger;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2021Jour4Exercice2 extends Annee2021Jour4 {

	public static void main(String[] args) {
		new Annee2021Jour4Exercice2().lancer(true);
	}

	public Annee2021Jour4Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var tirage = FileUtils.firstLineOfInteger(input, ",");
		var planches = inputToListObject(input, 2, 5);
		AtomicInteger nbrGagnant = new AtomicInteger(0);
		return applyToGagnant(tirage, planches, (numero, planche) -> nbrGagnant.incrementAndGet() == planches.size() ? plancheToAnswer(numero, planche) : null);
	}

}
