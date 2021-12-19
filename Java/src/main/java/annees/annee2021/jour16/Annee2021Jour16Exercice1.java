package annees.annee2021.jour16;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;
import commun.util.MathUtils;

public class Annee2021Jour16Exercice1 extends Annee2021Jour16 {

	public static void main(String[] args) {
		new Annee2021Jour16Exercice1().lancer(true);
	}

	public Annee2021Jour16Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.firstLineOfStreamBuilder(input);
		stream.map(c -> MathUtils.hexToBinary(c, 4));
		var paquet = new Paquet(stream);
		return "" + calculerVersionRecursif(paquet);
	}

	private long calculerVersionRecursif(Paquet paquet) {
		long version = paquet.version();
		for (var sousPaquet : paquet.listeSousPaquets()) {
			version += calculerVersionRecursif(sousPaquet);
		}
		return version;
	}

}
