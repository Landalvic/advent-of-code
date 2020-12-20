package annees.annee2019.jour04;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour4 extends Exercice {

	public Annee2019Jour4(int exercice) {
		super(2019, 4, exercice);
	}

	@Override
	protected void init() {}

	protected abstract boolean respectCritere(int mdp);

	@Override
	public String run(String input) throws AdventOfCodeException {
		var blocs = FileUtils.firstLine(input).split("-", -1);
		int min = Integer.parseInt(blocs[0]);
		int max = Integer.parseInt(blocs[1]);
		int total = 0;
		for (int i = min; i <= max; i++) {
			if (respectCritere(i)) {
				total++;
			}
		}
		return String.valueOf(total);
	}

}
