package annees.annee2019.jour06;

import java.util.HashMap;
import java.util.Map;

import commun.Hierarchie;
import commun.Hierarchies;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour6 extends Exercice {

	protected Annee2019Jour6(int exercice) {
		super(2019, 6, exercice);
	}

	protected Map<String, Hierarchie> inputToOrbites(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		Map<String, Hierarchie> orbites = new HashMap<>();
		Hierarchies ensemble = new Hierarchies();
		lignes.forEach(ligne -> {
			var blocs = ligne.split("\\)");
			orbites.computeIfAbsent(blocs[0], s -> new Hierarchie(ensemble, blocs[0]))
					.ajouterEnfant(orbites.computeIfAbsent(blocs[1], s -> new Hierarchie(ensemble, blocs[1])));
		});
		return orbites;
	}

}
