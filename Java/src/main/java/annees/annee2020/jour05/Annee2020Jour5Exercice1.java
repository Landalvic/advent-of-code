package annees.annee2020.jour05;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2020Jour5Exercice1 extends Annee2020Jour5 {

	public static void main(String[] args) {
		new Annee2020Jour5Exercice1().lancer(2020, 5, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		List<Integer> lMax = new ArrayList<>();
		List<Integer> lMaxS = new ArrayList<>();
		for (String string : liste) {
			int min = 0;
			int max = 128;
			int minS = 0;
			int maxS = 8;
			for (int i = 0; i < string.length(); i++) {
				String c = String.valueOf(string.charAt(i));
				if (StringUtils.equals(c, "F")) {
					max -= (max - min) / 2;
				} else if (StringUtils.equals(c, "B")) {
					min += (max - min) / 2;
				} else if (StringUtils.equals(c, "L")) {
					maxS -= (maxS - minS) / 2;
				} else if (StringUtils.equals(c, "R")) {
					minS += (maxS - minS) / 2;
				}
			}
			lMax.add(max);
			lMaxS.add(maxS);
		}
		int total = 0;
		for (int j = 0; j < lMax.size(); j++) {
			int nbr = (lMax.get(j) - 1) * 8 + (lMaxS.get(j) - 1);
			if (total < nbr) {
				total = nbr;
			}
		}
		return String.valueOf(total);
	}

}
