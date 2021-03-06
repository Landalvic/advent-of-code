package annees.annee2015.jour03;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2015Jour3Exercice2 extends Annee2015Jour3 {

	public static void main(String[] args) {
		new Annee2015Jour3Exercice2().lancer("src/main/resources/annee2015/jour03/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		String arbre = FileUtils.firstLine(input);
		List<Maison> maisons = new ArrayList<>();
		Maison ancienneMaison = new Maison(0, 0);
		Maison ancienneMaison2 = ancienneMaison;
		maisons.add(ancienneMaison);
		for (int i = 0; i < arbre.length(); i++) {
			Maison aRetenir = null;
			Maison aUtiliser = null;
			if (i % 2 == 0) {
				aUtiliser = ancienneMaison;
			} else {
				aUtiliser = ancienneMaison2;
			}
			if (StringUtils.equals("" + arbre.charAt(i), "<")) {
				aRetenir = addMaison(maisons, aUtiliser.getPositionX() - 1, aUtiliser.getPositionY());
			} else if (StringUtils.equals("" + arbre.charAt(i), ">")) {
				aRetenir = addMaison(maisons, aUtiliser.getPositionX() + 1, aUtiliser.getPositionY());
			} else if (StringUtils.equals("" + arbre.charAt(i), "^")) {
				aRetenir = addMaison(maisons, aUtiliser.getPositionX(), aUtiliser.getPositionY() - 1);
			} else if (StringUtils.equals("" + arbre.charAt(i), "v")) {
				aRetenir = addMaison(maisons, aUtiliser.getPositionX(), aUtiliser.getPositionY() + 1);
			}
			if (i % 2 == 0) {
				ancienneMaison = aRetenir;
			} else {
				ancienneMaison2 = aRetenir;
			}
		}
		return String.valueOf(maisons.size());
	}

}
