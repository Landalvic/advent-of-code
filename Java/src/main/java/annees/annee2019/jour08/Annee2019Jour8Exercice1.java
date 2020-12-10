package annees.annee2019.jour08;

import java.util.List;
import java.util.stream.Collectors;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour8Exercice1 extends Annee2019Jour8 {

	public static void main(String[] args) {
		new Annee2019Jour8Exercice1().lancer(2019, 8, 1, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		int wide = 25;
		int tall = 6;
		List<List<Integer>> pixels = inputToImage(input, wide, tall).stream()
				.map(sousStream -> sousStream.stream().flatMap(List::stream).collect(Collectors.toList())).collect(Collectors.toList());
		List<Integer> fewest = pixels.stream()
				.min((liste1, liste2) -> Long.compare(liste1.stream().filter(pixel -> pixel == 0).count(), liste2.stream().filter(pixel -> pixel == 0).count()))
				.orElseThrow();
		long nbr1 = fewest.stream().filter(pixel -> pixel == 1).count();
		long nbr2 = fewest.stream().filter(pixel -> pixel == 2).count();
		return String.valueOf(nbr1 * nbr2);
	}

}
