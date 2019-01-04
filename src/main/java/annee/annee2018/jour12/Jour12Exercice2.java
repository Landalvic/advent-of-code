package annee.annee2018.jour12;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Jour12Exercice2 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour12/data.txt");
		String initialState = "...." + liste.remove(0).substring(15) + "....";
		int firstIndex = initialState.indexOf("#");
		initialState = initialState.substring(firstIndex - 4, initialState.lastIndexOf("#") + 5);
		int index0 = 8 - firstIndex;
		liste.remove(0);
		Pattern patternPattern = Pattern.compile("(.*) => .*");
		Pattern resultatPattern = Pattern.compile(".* => (.*)");
		HashMap<String, String> patterns = new HashMap<>();
		for (String string : liste) {
			String pattern = FileUtils.trouverPattern(string, patternPattern);
			String resultat = FileUtils.trouverPattern(string, resultatPattern);
			patterns.put(pattern, resultat);
		}

		long indexArret = 0;
		for (int i = 0; i < 1000; i++) {
			StringBuilder newState = new StringBuilder();
			for (int j = 2; j < initialState.length() - 2; j++) {
				String morceau = initialState.substring(j - 2, j + 3);
				newState.append(patterns.get(morceau));
			}
			String initialState2 = "...." + newState.toString() + "....";
			firstIndex = initialState2.indexOf("#");
			initialState2 = initialState2.substring(firstIndex - 4, initialState2.lastIndexOf("#") + 5);
			if (StringUtils.equals(initialState2, initialState)) {
				indexArret = i;
				break;
			} else {
				initialState = initialState2;
			}
			index0 += 6 - firstIndex;
		}

		long total = 0;
		long nbrPots = 0;
		for (int i = 0; i < initialState.length(); i++) {
			if (StringUtils.equals("" + initialState.charAt(i), "#")) {
				total += i - index0;
				nbrPots++;
			}
		}
		System.out.println(total + (nbrPots * (50000000000L - indexArret)));
	}

}
