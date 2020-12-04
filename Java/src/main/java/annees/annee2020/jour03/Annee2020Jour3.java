package annees.annee2020.jour03;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public abstract class Annee2020Jour3 extends Exercice {

	protected boolean[][] genererMap(String input) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		boolean map[][] = new boolean[liste.size()][liste.get(0).length()];
		for (int i = 0; i < map.length; i++) {
			String string = liste.get(i);
			for (int j = 0; j < string.length(); j++) {
				if (StringUtils.equals(String.valueOf(string.charAt(j)), ".")) {
					map[i][j] = false;
				} else {
					map[i][j] = true;
				}
			}
		}
		return map;
	}

}
