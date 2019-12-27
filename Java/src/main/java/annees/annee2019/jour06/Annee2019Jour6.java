package annees.annee2019.jour06;

import java.util.HashMap;
import java.util.Map;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public abstract class Annee2019Jour6 extends Exercice {

	protected Map<String, Orbite> inputToOrbites(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		Map<String, Orbite> orbites = new HashMap<>();
		lignes.forEach(ligne -> {
			var blocs = ligne.split("\\)");
			orbites.computeIfAbsent(blocs[0], Orbite::new)
					.ajouterEnfant(orbites.computeIfAbsent(blocs[1], Orbite::new));
		});
		return orbites;
	}

}
