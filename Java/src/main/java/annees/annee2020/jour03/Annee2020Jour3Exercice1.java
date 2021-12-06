package annees.annee2020.jour03;

import java.util.List;
import java.util.stream.Stream;

import commun.StreamHistory;
import commun.structure.AdventOfCodeException;

public class Annee2020Jour3Exercice1 extends Annee2020Jour3 {

	public static void main(String[] args) {
		new Annee2020Jour3Exercice1().lancer(true);
	}

	public Annee2020Jour3Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<List<Boolean>> map = inputToStreamObject(input);
		StreamHistory<List<Boolean>> streamHistory = new StreamHistory<>(0);
		var count = streamHistory.stream(map).filter(ligne -> ligne.current().get((ligne.getIndex() * 3) % ligne.current().size()).booleanValue()).count();
		return String.valueOf(count);
	}

}
