package annees.annee2015.jour01;

import org.apache.commons.lang3.StringUtils;

import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour1Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour1Exercice1().lancer("src/main/resources/annee2015/jour01/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		String arbre = FileUtils.firstLine(input);
		int etage = 0;
		for (int i = 0; i < arbre.length(); i++) {
			if (StringUtils.equals(String.valueOf(arbre.charAt(i)), "(")) {
				etage++;
			} else if (StringUtils.equals(String.valueOf(arbre.charAt(i)), ")")) {
				etage--;
			}
		}
		return String.valueOf(etage);
	}

}
