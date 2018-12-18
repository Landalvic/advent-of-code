package jours.jour12;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Jour12Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour12/data.txt");
		String initialState = "....." + liste.remove(0).substring(15) + ".....";
		int index0 = 5;
		liste.remove(0);
		Pattern patternPattern = Pattern.compile("(.*) => .*");
		Pattern resultatPattern = Pattern.compile(".* => (.*)");
		HashMap<String, String> patterns = new HashMap<>();
		for (String string : liste) {
			String pattern = FileUtils.trouverPattern(string, patternPattern);
			String resultat = FileUtils.trouverPattern(string, resultatPattern);
			patterns.put(pattern, resultat);
		}

		for (int i = 0; i < 122; i++) {
			StringBuilder newState = new StringBuilder();
			for (int j = 2; j < initialState.length() - 2; j++) {
				String morceau = initialState.substring(j - 2, j + 3);
				newState.append(patterns.get(morceau));
			}
			initialState = "....." + newState.toString() + ".....";
			index0 += 3;
		}

		int total = 0;
		for (int i = 0; i < initialState.length(); i++) {
			if (StringUtils.equals("" + initialState.charAt(i), "#")) {
				total += i - index0;
			}
		}
		System.out.println(total);
	}

}
