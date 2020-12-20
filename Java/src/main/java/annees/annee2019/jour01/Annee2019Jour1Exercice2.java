package annees.annee2019.jour01;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2019Jour1Exercice2 extends Annee2019Jour1 {

	public static void main(String[] args) {
		new Annee2019Jour1Exercice2().lancer(true);
	}

	public Annee2019Jour1Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.streamOfInt(input);
		return String.valueOf(stream.reduce(0, (accumulateur, masse) -> {
			int reducer = calculEssence(masse);
			while (reducer > 0) {
				accumulateur += reducer;
				reducer = calculEssence(reducer);
			}
			return accumulateur;
		}));
	}

}
