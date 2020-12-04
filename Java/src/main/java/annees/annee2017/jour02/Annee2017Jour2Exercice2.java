package annees.annee2017.jour02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2017Jour2Exercice2 extends Annee2017Jour2 {

	public static void main(String[] args) {
		new Annee2017Jour2Exercice2().lancer(2017, 2, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> data = FileUtils.streamOfLines(input);
		var total = data.mapToInt(ligne -> {
			List<Integer> liste = Arrays.stream(ligne.split("\\t", -1)).map(bloc -> Integer.valueOf(bloc)).collect(Collectors.toList());
			for (int i = 0; i < liste.size(); i++) {
				for (int j = 0; j < liste.size(); j++) {
					double calcul = ((double) liste.get(i)) / liste.get(j);
					if (i != j && calcul == Math.floor(calcul)) {
						return (int) calcul;
					}
				}
			}
			return 0;
		}).sum();
		return String.valueOf(total);
	}

}
