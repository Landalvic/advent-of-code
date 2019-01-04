package annee.annee2018.jour5;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Jour5Exercice2 {

	public static void main(String[] args) {
		StringBuilder polymere = FileUtils.lireLigne("./jour5/data.txt");

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
		System.out.println(plusBas);
	}

}
