package annees.annee2015.jour01;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour1Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour1Exercice1().lancer("src/main/resources/annee2015/jour01/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		String arbre = FileUtils.firstLine(input);
		return String.valueOf(arbre.codePoints().mapToObj(c -> String.valueOf((char) c)).mapToInt(s -> {
			if (StringUtils.equals(s, "(")) {
				return 1;
			} else if (StringUtils.equals(s, ")")) {
				return -1;
			} else {
				return 0;
			}
		}).sum());
	}

}
