package annees.annee2019.jour01;

import java.util.stream.IntStream;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour1Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour1Exercice1().lancer("src/main/resources/annee2019/jour01/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		IntStream stream = FileUtils.streamOfInt(input);

		return String.valueOf(stream.map(a -> ((int) (a / 3.0)) - 2).sum());
	}

}
