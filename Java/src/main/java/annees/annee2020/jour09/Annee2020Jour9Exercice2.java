package annees.annee2020.jour09;

import java.util.List;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour9Exercice2 extends Annee2020Jour9 {

	public static void main(String[] args) {
		new Annee2020Jour9Exercice2().lancer(true);
	}

	public Annee2020Jour9Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Long> liste = FileUtils.listOfLongs(input);
		var exercice1 = new Annee2020Jour9Exercice1();
		exercice1.setTest(test);
		Long resultatPartie1 = Long.valueOf(exercice1.run(input));
		for (int i = 0; i < liste.size(); i++) {
			long total = 0;
			long max = 0;
			long min = Long.MAX_VALUE;
			for (int j = i; j < liste.size(); j++) {
				total += liste.get(j);
				max = Math.max(max, liste.get(j));
				min = Math.min(min, liste.get(j));
				if (total == resultatPartie1) {
					return String.valueOf((min + max));
				} else if (total > resultatPartie1) {
					break;
				}
			}
		}
		throw new AdventOfCodeException("Aucune réponse trouvée.");
	}

}
