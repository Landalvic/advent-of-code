package annees.annee2019.jour04;

import java.util.ArrayList;
import java.util.List;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;

public abstract class Annee2019Jour4 extends Exercice {

	protected abstract boolean respectCritere(int mdp);

	@Override
	public String run(String input) throws AdventOfCodeException {
		int min = 387638;
		int max = 919123;
		List<Integer> good = new ArrayList<>();
		for (int i = min; i <= max; i++) {
			if (respectCritere(i)) {
				good.add(i);
			}
		}
		return String.valueOf(good.size());
	}

}
