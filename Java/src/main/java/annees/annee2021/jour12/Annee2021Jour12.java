package annees.annee2021.jour12;

import commun.Hierarchies;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2021Jour12 extends Exercice {

	protected Annee2021Jour12(int exercice) {
		super(2021, 12, exercice);
	}

	protected Hierarchies<Grotte> inputTobags(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		Hierarchies<Grotte> hierarchies = new Hierarchies<>();
		lignes.forEach(ligne -> {
			var blocs = ligne.split("-");
			var parent = hierarchies.trouverOuAjouter(new Grotte(blocs[0]));
			parent.ajouterEnfant(hierarchies.trouverOuAjouter(new Grotte(blocs[1])));
		});
		return hierarchies;
	}

}
