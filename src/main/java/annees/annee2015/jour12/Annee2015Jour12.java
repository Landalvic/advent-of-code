package annees.annee2015.jour12;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import commun.Exercice;

public abstract class Annee2015Jour12 extends Exercice {

	public String calcul(StringBuilder string) throws Exception {
		int total = 0;
		for (int i = 0; i < string.length(); i++) {
			String strChar = String.valueOf(string.charAt(i));
			if (StringUtils.equals(strChar, "-") || NumberUtils.isDigits(strChar)) {
				StringBuilder builder = new StringBuilder(strChar);
				for (int j = i + 1; j < string.length(); j++, i++) {
					if (NumberUtils.isDigits(String.valueOf(string.charAt(j)))) {
						builder.append(string.charAt(j));
					} else {
						break;
					}
				}
				total += Integer.valueOf(builder.toString());
			}
		}
		return String.valueOf(total);
	}

}
