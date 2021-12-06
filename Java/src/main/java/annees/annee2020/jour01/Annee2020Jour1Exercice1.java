package annees.annee2020.jour01;

import commun.Position;
import commun.StreamSearch;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour1Exercice1 extends Annee2020Jour1 {

	public static void main(String[] args) {
		new Annee2020Jour1Exercice1().lancer(true);
	}

	public Annee2020Jour1Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.streamOfInt(input);
		StreamSearch<Integer, Position> streamHistory = new StreamSearch<>();
		var position = streamHistory.findCondition(stream.boxed(), i -> {
			for (var previous : i.getListe()) {
				if (previous + i.current() == 2020) {
					return new Position(i.current(), previous);
				}
			}
			return null;
		});
		return String.valueOf((long) (position.getX() * position.getY()));
	}

}
