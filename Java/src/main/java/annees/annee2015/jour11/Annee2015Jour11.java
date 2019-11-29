package annees.annee2015.jour11;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;

public abstract class Annee2015Jour11 extends Exercice {

	public String runCommun(String input) throws AdventOfCodeException {
		do {
			input = increment(input);
		} while (!verifierConditions(input));
		return input;
	}

	private String increment(String string) {
		int indexZ = 0;
		for (int i = string.length() - 1; i >= 0; i--) {
			if (!StringUtils.equals(String.valueOf(string.charAt(i)), "z")) {
				indexZ = i;
				break;
			}
		}
		char increment = (char) (((int) string.charAt(indexZ)) + 1);
		StringBuilder builderA = new StringBuilder();
		for (int i = indexZ + 1; i < string.length(); i++) {
			builderA.append("a");
		}
		return string.substring(0, indexZ) + increment + builderA.toString();
	}

	private boolean verifierConditions(String string) {
		boolean condition1 = false;
		boolean condition2 = true;
		boolean condition3 = false;
		Character premierePaire = null;
		for (int i = 0; i < string.length(); i++) {
			if (i >= 2) {
				int lettre = (int) string.charAt(i);
				int lettrePrec = (int) string.charAt(i - 1);
				int lettrePrec2 = (int) string.charAt(i - 2);
				if (lettre == lettrePrec + 1 && lettrePrec == lettrePrec2 + 1) {
					condition1 = true;
				}
			}
			String strChar = String.valueOf(string.charAt(i));
			if (StringUtils.equals(strChar, "i") || StringUtils.equals(strChar, "l") || StringUtils.equals(strChar, "o")) {
				condition2 = false;
				break;
			}
			if (i >= 1 && string.charAt(i) == string.charAt(i - 1)) {
				if (premierePaire == null) {
					premierePaire = string.charAt(i);
				} else if (premierePaire.charValue() != string.charAt(i)) {
					condition3 = true;
				}
			}
		}
		return condition1 && condition2 && condition3;
	}

}
