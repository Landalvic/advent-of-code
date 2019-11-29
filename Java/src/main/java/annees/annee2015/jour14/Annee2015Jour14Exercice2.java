package annees.annee2015.jour14;

import java.util.List;

import commun.AdventOfCodeException;

public class Annee2015Jour14Exercice2 extends Annee2015Jour14 {

	public static void main(String[] args) {
		new Annee2015Jour14Exercice2().lancer("src/main/resources/annee2015/jour14/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Renne> rennes = inputToRennes(input);

		for (int i = 0; i < 2503; i++) {
			rennes.stream().forEach(renne -> renne.courir1s());

			int distanceMax = rennes.stream().mapToInt(renne -> renne.getDistance()).max().getAsInt();
			rennes.stream().filter(renne -> renne.getDistance() == distanceMax).forEach(renne -> renne.setPoints(renne.getPoints() + 1));
		}
		return String.valueOf(rennes.stream().mapToInt(renne -> renne.getPoints()).max().getAsInt());
	}

}
