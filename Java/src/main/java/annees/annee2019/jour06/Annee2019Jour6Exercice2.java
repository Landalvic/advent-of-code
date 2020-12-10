package annees.annee2019.jour06;

import java.util.List;
import java.util.Map;

import commun.Hierarchie;
import commun.structure.AdventOfCodeException;

public class Annee2019Jour6Exercice2 extends Annee2019Jour6 {

	public static void main(String[] args) {
		new Annee2019Jour6Exercice2().lancer(2019, 6, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Map<String, Orbite> orbites = inputToOrbites(input);
		var you = orbites.get("YOU");
		var destination = orbites.get("SAN");
		List<Hierarchie> bonChemin = you.chemin(destination);
		return String.valueOf(bonChemin.size() - 3);
	}

}
