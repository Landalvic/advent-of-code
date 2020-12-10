package annees.annee2020.jour05;

import java.util.Set;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour5Exercice2 extends Annee2020Jour5 {

	public static void main(String[] args) {
		new Annee2020Jour5Exercice2().lancer(2020, 5, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Set<Integer> sieges = inputToSetObject(input);
		for (int i = 1; i < 128 * 8 - 1; i++) {
			if (sieges.contains(i - 1) && sieges.contains(i + 1) && !sieges.contains(i)) {
				return String.valueOf(i);
			}
		}
		throw new AdventOfCodeException("Aucun siège trouvé");
	}

}
