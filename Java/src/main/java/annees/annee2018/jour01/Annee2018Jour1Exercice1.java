package annees.annee2018.jour01;

import java.util.stream.IntStream;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2018Jour1Exercice1 extends Annee2018Jour1 {

	public static void main(String[] args) {
		new Annee2018Jour1Exercice1().lancer(2018, 1, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		IntStream stream = FileUtils.streamOfInt(input);
		return String.valueOf(stream.sum());
	}

}
