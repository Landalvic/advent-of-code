package annees.annee2021.jour03;

import java.util.ArrayList;
import java.util.List;

import commun.Position;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;
import commun.util.MathUtils;

public class Annee2021Jour3Exercice1 extends Annee2021Jour3 {

	public static void main(String[] args) {
		new Annee2021Jour3Exercice1().lancer(true);
	}

	public Annee2021Jour3Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var firstLine = FileUtils.firstLine(input);
		var stream = FileUtils.streamOfCharacters(input);
		List<Position> gammas = new ArrayList<>(firstLine.length());
		List<Position> epsilons = new ArrayList<>(firstLine.length());
		for (int i = 0; i < firstLine.length(); i++) {
			gammas.add(new Position(0, 0));
			epsilons.add(new Position(0, 0));
		}
		stream.forEach(list -> {
			for (int j = 0; j < list.size(); j++) {
				updatePosition(list.get(j), gammas.get(j));
				updatePosition(list.get(j), epsilons.get(j));
			}
		});
		var gamma = calcul(gammas, "1", "0");
		var epsilon = calcul(gammas, "0", "1");
		return String.valueOf(gamma * epsilon);
	}

	private long calcul(List<Position> positions, String charPrincipal, String charAEnlever) {
		var result = new StringBuilder();
		positions.forEach(p -> result.append(p.getX() > p.getY() ? charPrincipal : charAEnlever));
		return MathUtils.binaryToLong(result.toString(), 2);
	}

}
