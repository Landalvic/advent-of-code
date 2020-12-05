package annees.annee2020.jour05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import util.FileUtils;

public class Annee2020Jour5Exercice2 extends Annee2020Jour5 {

	public static void main(String[] args) {
		new Annee2020Jour5Exercice2().lancer(2020, 5, 2, false);
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
		Set<Integer> sieges = new HashSet<>();
		for (int i = 0; i < lMax.size(); i++) {
			sieges.add((lMax.get(i) - 1) * 8 + (lMaxS.get(i) - 1));
		}
		for (int i = 1; i < 128 * 8 - 1; i++) {
			if (sieges.contains(i - 1) && sieges.contains(i + 1) && !sieges.contains(i)) {
				return String.valueOf(i);
			}
		}
		return String.valueOf("");
	}

}
