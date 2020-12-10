package annees.annee2019.jour01;

import java.util.stream.IntStream;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2019Jour1Exercice1 extends Annee2019Jour1 {

	public static void main(String[] args) {
		new Annee2019Jour1Exercice1().lancer(2019, 1, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		IntStream stream = FileUtils.streamOfInt(input);
		return String.valueOf(stream.map(this::calculEssence).sum());
	}

}
