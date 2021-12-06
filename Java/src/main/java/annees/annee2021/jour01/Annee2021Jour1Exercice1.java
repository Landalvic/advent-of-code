package annees.annee2021.jour01;

import commun.StreamHistory;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2021Jour1Exercice1 extends Annee2021Jour1 {

	public static void main(String[] args) {
		new Annee2021Jour1Exercice1().lancer(true);
	}

	public Annee2021Jour1Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.streamOfInt(input);
		StreamHistory<Integer> streamHistory = new StreamHistory<>(1);
		return String.valueOf(streamHistory.streamWithoutNull(stream.boxed()).filter(i -> i.current() > i.previous(1)).count());
	}

}
