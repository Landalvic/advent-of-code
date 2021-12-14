package annees.annee2021.jour10;

import java.util.Objects;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2021Jour10Exercice1 extends Annee2021Jour10 {

	public static void main(String[] args) {
		new Annee2021Jour10Exercice1().lancer(true);
	}

	public Annee2021Jour10Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.streamOfLines(input);
		return String.valueOf(stream
				.map(this::firstWrongCaractere)
				.filter(Objects::nonNull)
				.mapToInt(this::convertCaractereToPoint)
				.sum());
	}

	protected int convertCaractereToPoint(String caractere) {
		switch (caractere) {
			case ")":
				return 3;
			case "]":
				return 57;
			case "}":
				return 1197;
			case ">":
				return 25137;
			default:
				return 0;
		}
	}

}
