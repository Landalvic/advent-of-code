package annees.annee2019.jour01;

import java.util.stream.IntStream;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour1Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour1Exercice2().lancer("src/main/resources/annee2019/jour01/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		IntStream stream = FileUtils.streamOfInt(input);
		return String.valueOf(stream.sum());
	}

}
