package annees.annee2017.jour02;

import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2017Jour2Exercice1 extends Annee2017Jour2 {

	public static void main(String[] args) {
		new Annee2017Jour2Exercice1().lancer(2017, 2, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> data = FileUtils.streamOfLines(input);
		var total = data.mapToInt(ligne -> {
			var blocs = ligne.split("\\t", -1);
			int min = Integer.parseInt(blocs[0]);
			int max = Integer.parseInt(blocs[0]);
			for (String string : blocs) {
				min = Math.min(min, Integer.valueOf(string));
				max = Math.max(max, Integer.valueOf(string));
			}
			return max - min;
		}).sum();
		return String.valueOf(total);
	}

}
