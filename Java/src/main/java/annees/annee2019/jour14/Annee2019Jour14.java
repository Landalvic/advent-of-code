package annees.annee2019.jour14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public abstract class Annee2019Jour14 extends Exercice {

	protected List<Reaction> inputToReactions(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		return lignes.map(string -> {
			var compose = string.split("=>");
			var besoins = compose[0].split(",");
			List<Produit> produits = new ArrayList<>(besoins.length);
			for (String string2 : besoins) {
				produits.add(new Produit(string2.trim().split(" ")));
			}
			return new Reaction(produits, new Produit(compose[1].trim().split(" ")));
		}).collect(Collectors.toList());
	}

}
