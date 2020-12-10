package annees.annee2015.jour14;

import java.util.List;

import commun.structure.AdventOfCodeException;

public class Annee2015Jour14Exercice1 extends Annee2015Jour14 {

	public static void main(String[] args) {
		new Annee2015Jour14Exercice1().lancer("src/main/resources/annee2015/jour14/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Renne> rennes = inputToRennes(input);
		for (int i = 0; i < 2503; i++) {
			rennes.stream().forEach(renne -> renne.courir1s());
		}
		return String.valueOf(rennes.stream().mapToInt(renne -> renne.getDistance()).max().getAsInt());
	}

}
