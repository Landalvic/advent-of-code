package annees.annee2021.jour04;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2021Jour4Exercice1 extends Annee2021Jour4 {

	public static void main(String[] args) {
		new Annee2021Jour4Exercice1().lancer(true);
	}

	public Annee2021Jour4Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var tirage = FileUtils.firstLineOfInteger(input, ",");
		var planches = inputToListObject(input, 2, 5);
		return applyToGagnant(tirage, planches, this::plancheToAnswer);
	}

}
