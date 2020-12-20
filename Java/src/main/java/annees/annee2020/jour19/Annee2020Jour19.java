package annees.annee2020.jour19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;
import commun.util.TexteUtils;

public abstract class Annee2020Jour19 extends Exercice {

	protected Pattern patternRule = Pattern.compile("^(.*): \"(.*)\"$");
	protected Pattern patternRuleRelated = Pattern.compile("^(.*):(.*)$");
	protected List<String> messages;
	protected Map<Integer, Rule> rules;

	public Annee2020Jour19(int exercice) {
		super(2020, 19, exercice);
	}

	@Override
	protected void init() {
		messages = new ArrayList<>();
		rules = new HashMap<>();
	}

	protected void chargerInput(String input) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		for (int i = 0; i < lignes.size(); i++) {
			String ligne = lignes.get(i);
			if (TexteUtils.findPattern(ligne, patternRule)) {
				var blocs = TexteUtils.trouverPattern(ligne, patternRule, 2);
				Rule rule = new Rule();
				rule.setId(Integer.parseInt(blocs[0]));
				rule.setValue(blocs[1]);
				rules.put(rule.getId(), rule);
			} else if (TexteUtils.findPattern(ligne, patternRuleRelated)) {
				var blocs = TexteUtils.trouverPattern(ligne, patternRuleRelated, 2);
				Rule rule = new Rule();
				rule.setId(Integer.parseInt(blocs[0]));
				var sblocs = blocs[1].split("\\|");
				for (String string : sblocs) {
					List<Integer> ids = new ArrayList<>();
					var ssBlocs = string.split(" ");
					for (String string2 : ssBlocs) {
						if (!string2.isEmpty()) {
							ids.add(Integer.parseInt(string2));
						}
					}
					rule.getIdRules().add(ids);
				}
				rules.put(rule.getId(), rule);
			} else if (!ligne.isEmpty()) {
				messages.add(ligne);
			}
		}
	}

}
