package annees.annee2019.jour06;

import commun.Hierarchies;
import commun.Infos;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2019Jour6 extends Exercice {

	protected Annee2019Jour6(int exercice) {
		super(2019, 6, exercice);
	}

	protected Hierarchies<Infos> inputToOrbites(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		Hierarchies<Infos> ensemble = new Hierarchies<>();
		lignes.forEach(ligne -> {
			var blocs = ligne.split("\\)");
			var parent = ensemble.trouverOuAjouter(new Infos(blocs[0]));
			parent.ajouterEnfant(ensemble.trouverOuAjouter(new Infos(blocs[1])));
		});
		return ensemble;
	}

}
