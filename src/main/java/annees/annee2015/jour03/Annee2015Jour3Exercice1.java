package annees.annee2015.jour03;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Annee2015Jour3Exercice1 extends Annee2015Jour3 {

	public static void main(String[] args) {
		new Annee2015Jour3Exercice1().lancer("src/main/resources/annee2015/jour03/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		String arbre = FileUtils.firstLine(input);
		List<Maison> maisons = new ArrayList<>();
		Maison ancienneMaison = new Maison(0, 0);
		maisons.add(ancienneMaison);
		for (int i = 0; i < arbre.length(); i++) {
			if (StringUtils.equals("" + arbre.charAt(i), "<")) {
				ancienneMaison = addMaison(maisons, ancienneMaison.getPositionX() - 1, ancienneMaison.getPositionY());
			} else if (StringUtils.equals("" + arbre.charAt(i), ">")) {
				ancienneMaison = addMaison(maisons, ancienneMaison.getPositionX() + 1, ancienneMaison.getPositionY());
			} else if (StringUtils.equals("" + arbre.charAt(i), "^")) {
				ancienneMaison = addMaison(maisons, ancienneMaison.getPositionX(), ancienneMaison.getPositionY() - 1);
			} else if (StringUtils.equals("" + arbre.charAt(i), "v")) {
				ancienneMaison = addMaison(maisons, ancienneMaison.getPositionX(), ancienneMaison.getPositionY() + 1);
			}
		}
		return String.valueOf(maisons.size());
	}

}
