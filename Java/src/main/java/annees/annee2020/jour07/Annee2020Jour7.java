package annees.annee2020.jour07;

import org.apache.commons.lang3.StringUtils;

import commun.Hierarchie;
import commun.Hierarchies;
import commun.Infos;
import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;
import commun.util.TexteUtils;

public abstract class Annee2020Jour7 extends Exercice {

	protected Annee2020Jour7(int exercice) {
		super(2020, 7, exercice);
	}

	protected Hierarchies<Infos> inputTobags(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		Hierarchies<Infos> hierarchies = new Hierarchies<>();
		lignes.forEach(ligne -> {
			var rule = TexteUtils.transformerPattern(ligne, Rule.class);
			Hierarchie<Infos> sac = hierarchies.trouverOuAjouter(new Infos(rule.getConteneur()));
			if (!StringUtils.equals("no other bags", rule.getContenu().trim())) {
				var sblocs = rule.getContenu().split(",", -1);
				for (String string : sblocs) {
					if (!string.isEmpty()) {
						var ruleContenu = TexteUtils.transformerPattern(string.trim(), RuleContenu.class);
						Hierarchie<Infos> sacEnfant = hierarchies.trouverOuAjouter(new Infos(ruleContenu.getBag()));
						sac.ajouterEnfant(sacEnfant, ruleContenu.getNombre());
					}
				}
			}
		});
		return hierarchies;
	}

}
