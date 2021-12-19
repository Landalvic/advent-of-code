package annees.annee2021.jour16;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;
import commun.util.MathUtils;

public class Annee2021Jour16Exercice2 extends Annee2021Jour16 {

	public static void main(String[] args) {
		new Annee2021Jour16Exercice2().lancer(true);
	}

	public Annee2021Jour16Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.firstLineOfStreamBuilder(input);
		stream.map(c -> MathUtils.hexToBinary(c, 4));
		var paquet = new Paquet(stream);
		return "" + paquet.calculValeur();
	}

}
