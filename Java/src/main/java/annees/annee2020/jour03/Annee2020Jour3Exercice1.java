package annees.annee2020.jour03;

import java.util.List;
import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.util.StreamUtils;

public class Annee2020Jour3Exercice1 extends Annee2020Jour3 {

	public static void main(String[] args) {
		new Annee2020Jour3Exercice1().lancer(2020, 3, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<List<Boolean>> map = inputToStreamObject(input);
		return String.valueOf(StreamUtils
				.filterWithIndex(map, (ligne, index) -> ligne.get((index * 3) % ligne.size()).booleanValue()).count());
	}

}
