package annees.annee2019.jour12;

import java.util.stream.Collectors;

import commun.structure.AdventOfCodeException;
import commun.util.MathUtils;

public class Annee2019Jour12Exercice2 extends Annee2019Jour12 {

	public static void main(String[] args) {
		new Annee2019Jour12Exercice2().lancer(2019, 12, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lunes = inputToLunes(input);
		while (!lunes.stream().allMatch(Lune::fin)) {
			tour(lunes);
		}
		var diviseurs = lunes.stream()
				.map(lune -> MathUtils.mapDiviseursDenominateurCommun(lune.getCycleX().size(), lune.getCycleY().size(), lune.getCycleZ().size()))
				.collect(Collectors.toList());
		var diviseurs2 = MathUtils.mapDiviseursDenominateurCommun(diviseurs);
		return String.valueOf(MathUtils.denominateurCommun(diviseurs2));
	}

}
