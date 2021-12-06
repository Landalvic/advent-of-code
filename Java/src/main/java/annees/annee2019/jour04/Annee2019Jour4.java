package annees.annee2019.jour04;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour4 extends Exercice {

	protected Annee2019Jour4(int exercice) {
		super(2019, 4, exercice);
	}

	protected abstract boolean respectCritere(int mdp);

	@Override
	public String run(String input) throws AdventOfCodeException {
		var blocs = FileUtils.firstLineOfInteger(input, "-");
		int min = blocs.get(0);
		int max = blocs.get(1);
		int total = 0;
		for (int i = min; i <= max; i++) {
			if (respectCritere(i)) {
				total++;
			}
		}
		return String.valueOf(total);
	}

}
