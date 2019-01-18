package annees.annee2018.jour05;

import org.apache.commons.lang3.StringUtils;

import commun.Exercice;
import util.FileUtils;

public class Annee2018Jour5Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2018Jour5Exercice2().lancer("src/main/resources/annee2018/jour05/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		String polymere = FileUtils.firstLine(input);

		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int plusBas = polymere.length();
		for (char character : alphabet) {
			StringBuilder newPolymere = new StringBuilder(polymere);
			for (int i = 0; i < newPolymere.length() - 1; i++) {
				if (StringUtils.equalsIgnoreCase("" + newPolymere.charAt(i), "" + character)) {
					newPolymere.deleteCharAt(i);
					i = i - 2;
					if (i < 0) {
						i = -1;
					}
				} else if (StringUtils.equalsIgnoreCase("" + newPolymere.charAt(i), "" + newPolymere.charAt(i + 1))
						&& !StringUtils.equals("" + newPolymere.charAt(i), "" + newPolymere.charAt(i + 1))) {
					newPolymere.deleteCharAt(i + 1);
					newPolymere.deleteCharAt(i);
					i = i - 2;
					if (i < 0) {
						i = -1;
					}
				}
			}
			if (plusBas > newPolymere.length()) {
				plusBas = newPolymere.length();
			}
		}
		return String.valueOf(plusBas);
	}

}
