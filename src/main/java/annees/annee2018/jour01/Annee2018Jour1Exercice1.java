package annees.annee2018.jour01;

import java.util.stream.IntStream;

import commun.Exercice;
import util.FileUtils;

public class Annee2018Jour1Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2018Jour1Exercice1().lancer("src/main/resources/annee2018/jour01/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		IntStream stream = FileUtils.streamOfInt(input);
		return String.valueOf(stream.sum());
	}

}
