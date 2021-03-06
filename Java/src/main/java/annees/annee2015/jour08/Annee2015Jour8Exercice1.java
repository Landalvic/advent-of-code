package annees.annee2015.jour08;

import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2015Jour8Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour8Exercice1().lancer("src/main/resources/annee2015/jour08/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> stream = FileUtils.streamOfLines(input);
		int total = stream.mapToInt(string -> {
			String epuration = string.replace("\\\\", "a");
			epuration = epuration.replace("\\\"", "a");
			epuration = epuration.replace("\"", "");
			int nbrHex = epuration.split("\\\\x").length - 1;
			int longueurEpuree = epuration.length() - (nbrHex * 3);
			return string.length() - longueurEpuree;
		}).sum();
		return String.valueOf(total);
	}

}
