package annees.annee2019.jour06;

import java.util.List;

import commun.Hierarchie;
import commun.Hierarchies;
import commun.Infos;
import commun.structure.AdventOfCodeException;

public class Annee2019Jour6Exercice2 extends Annee2019Jour6 {

	public static void main(String[] args) {
		new Annee2019Jour6Exercice2().lancer(true);
	}

	public Annee2019Jour6Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Hierarchies<Infos> orbites = inputToOrbites(input);
		var you = orbites.trouver("YOU");
		var destination = orbites.trouver("SAN");
		List<Hierarchie<Infos>> bonChemin = you.chemin(destination);
		return String.valueOf(bonChemin.size() - 3);
	}

}
