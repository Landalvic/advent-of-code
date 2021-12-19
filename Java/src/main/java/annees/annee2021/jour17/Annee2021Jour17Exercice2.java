package annees.annee2021.jour17;

import commun.StreamHistory;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2021Jour17Exercice2 extends Annee2021Jour17 {

	public static void main(String[] args) {
		new Annee2021Jour17Exercice2().lancer(true);
	}

	public Annee2021Jour17Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.streamOfInt(input);
		StreamHistory<Integer> streamHistory = new StreamHistory<>(3);
		return String.valueOf(streamHistory.streamWithoutNull(stream.boxed()).filter(i -> i.current() + i.previous(1) + i.previous(2) > i.previous(1) + i.previous(2) + i.previous(3))
				.count());
	}

}
