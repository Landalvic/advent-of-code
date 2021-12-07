package annees.annee2021.jour07;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2021Jour7 extends Exercice {

	protected Annee2021Jour7(int exercice) {
		super(2021, 7, exercice);
	}

	protected abstract int fonction(int x);

	@Override
	public String run(String input) throws AdventOfCodeException {
		var entiers = FileUtils.firstLineOfInteger(input, ",");
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (Integer integer : entiers) {
			min = Math.min(min, integer);
			max = Math.max(max, integer);
		}
		int plusPetit = Integer.MAX_VALUE;
		for (int j = min; j <= max; j++) {
			int total = 0;
			for (Integer integer : entiers) {
				total += fonction(Math.abs(integer - j));
			}
			plusPetit = Math.min(plusPetit, total);
		}
		return String.valueOf(plusPetit);
	}

}
