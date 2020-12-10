package annees.annee2020.jour07;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import commun.Hierarchie;
import commun.Hierarchies;
import commun.structure.ExerciceInputToObject;
import commun.util.FileUtils;

public abstract class Annee2020Jour7 extends ExerciceInputToObject<Hierarchie> {

	protected Pattern pattern;
	protected Hierarchies hierarchies;

	@Override
	protected void init() {
		pattern = Pattern.compile("^(.*) bags contain (.*).$");
		hierarchies = new Hierarchies();
	}

	@Override
	protected Hierarchie ligneToObject(String ligne) {
		var blocs = FileUtils.trouverPattern(ligne, pattern, 2);
		Hierarchie sac = hierarchies.trouverOuAjouter(blocs[0]);
		if (!StringUtils.equals("no other bags", blocs[1].trim())) {
			var sblocs = blocs[1].split(",", -1);
			for (String string : sblocs) {
				if (!string.isEmpty()) {
					var newS = string.replace("bags", "").trim();
					var newT = newS.substring(2).replace("bags", "").replace("bag", "").trim();
					var newNbr = Integer.parseInt(String.valueOf(newS.charAt(0)));
					Hierarchie sacEnfant = hierarchies.trouverOuAjouter(newT);
					sac.ajouterEnfant(sacEnfant, newNbr);
				}
			}
		}
		return sac;
	}

}
