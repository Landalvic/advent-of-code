package annees.annee2021.jour10;

import java.math.BigInteger;

import commun.StreamBuilder;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;
import commun.util.TexteUtils;

public class Annee2021Jour10Exercice2 extends Annee2021Jour10 {

	public static void main(String[] args) {
		new Annee2021Jour10Exercice2().lancer(true);
	}

	public Annee2021Jour10Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.streamOfLines(input);
		var tab = stream
				.filter(ligne -> firstWrongCaractere(ligne) == null)
				.mapToLong(this::transformPoints)
				.sorted()
				.toArray();
		return String.valueOf(tab[(tab.length / 2)]);
	}

	protected long transformPoints(String ligne) {
		StreamBuilder builder = new StreamBuilder(ligne);
		return builder
				.forEach(caractere -> {
					if (verifierCaractereFermant(caractere) && verifierCaractereFusion(builder, caractere, builder.getIndex())) {
						builder.delete(builder.getIndex() - 1, builder.getIndex() + 1);
						builder.addIndex(-2);
					}
				})
				.reverse()
				.map(TexteUtils::correspondanceOpposee)
				.reduce(BigInteger.valueOf(0), (acc, obj) -> acc
						.multiply(BigInteger.valueOf(5))
						.add(BigInteger.valueOf(convertCaractereToPoint(obj))))
				.longValue();
	}

	protected int convertCaractereToPoint(String caractere) {
		switch (caractere) {
			case ")":
				return 1;
			case "]":
				return 2;
			case "}":
				return 3;
			case ">":
				return 4;
			default:
				return 0;
		}
	}

}
