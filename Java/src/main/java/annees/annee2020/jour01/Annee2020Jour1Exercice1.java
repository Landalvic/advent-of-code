package annees.annee2020.jour01;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour1Exercice1 extends Annee2020Jour1 {

	public static void main(String[] args) {
		new Annee2020Jour1Exercice1().lancer(true);
	}

	public Annee2020Jour1Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var liste = FileUtils.listOfIntegers(input);
		for (int i = 0; i < liste.size(); i++) {
			for (int j = 0; j < liste.size(); j++) {
				if (i != j && liste.get(i) + liste.get(j) == 2020) {
					return String.valueOf((liste.get(i) * liste.get(j)));
				}
			}
		}
		throw new AdventOfCodeException("Aucun élément trouvé");
	}

}
