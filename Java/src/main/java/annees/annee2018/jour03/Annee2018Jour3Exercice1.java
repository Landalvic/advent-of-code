package annees.annee2018.jour03;

import java.util.Arrays;

import commun.structure.AdventOfCodeException;

public class Annee2018Jour3Exercice1 extends Annee2018Jour3 {

	public static void main(String[] args) {
		new Annee2018Jour3Exercice1().lancer("src/main/resources/annee2018/jour03/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		inputToDemandes(input);
		long total = Arrays
				.stream(tissu)
				.flatMap(Arrays::stream)
				.filter(atomicInteger -> atomicInteger != null && atomicInteger.get() >= 2)
				.count();
		return String.valueOf(total);
	}

}
