package annees.annee2020.jour02;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2020Jour2Exercice1 extends Annee2020Jour2 {

	public static void main(String[] args) {
		new Annee2020Jour2Exercice1().lancer(2020, 2, 1, true);
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
			for (int i = 0; i < mdp.length(); i++) {
				if (StringUtils.equals(String.valueOf(mdp.charAt(i)), lettre)) {
					count++;
				}
			}
			if (count >= nbr && count <= nbr2) {
				total++;
			}
		}
		return String.valueOf(total);
	}

}
