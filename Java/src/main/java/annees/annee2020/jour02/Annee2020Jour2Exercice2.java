package annees.annee2020.jour02;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2020Jour2Exercice2 extends Annee2020Jour2 {

	public static void main(String[] args) {
		new Annee2020Jour2Exercice2().lancer(2020, 2, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		int total = 0;
		for (String string : liste) {
			String[] blocs = FileUtils.trouverPattern(string, pattern, 4);
			var nbr = Integer.parseInt(blocs[0]);
			var nbr2 = Integer.parseInt(blocs[1]);
			String lettre = blocs[2];
			String mdp = blocs[3];
			int count = 0;
			if (StringUtils.equals(String.valueOf(mdp.charAt(nbr - 1)), lettre)) {
				count++;
			}
			if (StringUtils.equals(String.valueOf(mdp.charAt(nbr2 - 1)), lettre)) {
				count++;
			}
			if (count == 1) {
				total++;
			}
		}
		return String.valueOf(total);
	}

}
