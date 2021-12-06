package annees.annee2018.jour01;

import java.util.stream.IntStream;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2018Jour1Exercice1 extends Annee2018Jour1 {

	public static void main(String[] args) {
		new Annee2018Jour1Exercice1().lancer(true);
	}

	public Annee2018Jour1Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		IntStream stream = FileUtils.streamOfInt(input);
		return String.valueOf(stream.sum());
	}

}
