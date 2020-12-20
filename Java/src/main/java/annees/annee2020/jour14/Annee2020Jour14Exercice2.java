package annees.annee2020.jour14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;
import commun.util.MathUtils;
import commun.util.TexteUtils;

public class Annee2020Jour14Exercice2 extends Annee2020Jour14 {

	public static void main(String[] args) {
		new Annee2020Jour14Exercice2().lancer(true);
	}

	public Annee2020Jour14Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		String maskTotal = "";
		Map<Long, String> memoire = new HashMap<>();
		for (int i = 0; i < lignes.size(); i++) {
			String string = lignes.get(i);
			if (TexteUtils.findPattern(string, pattern)) {
				long[] tab = TexteUtils.trouverPatternLong(string, pattern, 2);
				List<Long> adresses = recupererAdresses(maskTotal, tab[0]);
				for (Long adresse : adresses) {
					memoire.put(adresse, String.valueOf(tab[1]));
				}
			} else {
				maskTotal = string.replace("mask = ", "");
			}
		}
		return String.valueOf(memoire.entrySet().stream().mapToLong(entry -> Long.parseLong(entry.getValue())).sum());
	}

	private List<Long> recupererAdresses(String maskTotal, long adress) {
		StringBuilder constitution = new StringBuilder();
		String newValue = Long.toBinaryString(adress);
		List<StringBuilder> constitutions = new ArrayList<>();
		constitutions.add(constitution);
		gererMaskAvantValeur(constitutions, maskTotal, newValue);
		gererMaskValeur(constitutions, maskTotal, newValue);
		return constitutions.stream().map(s -> MathUtils.binaryToLong(s.toString(), 2)).collect(Collectors.toList());
	}

	private void gererMaskAvantValeur(List<StringBuilder> constitutions, String maskTotal, String newValue) {
		for (int j = 0; j < maskTotal.length() - newValue.length(); j++) {
			String c = String.valueOf(maskTotal.charAt(j));
			if (StringUtils.equals("X", c)) {
				doublerPossibilites(constitutions);
			} else {
				for (StringBuilder stringBuilder : constitutions) {
					stringBuilder.append(c);
				}
			}
		}
	}

	private void gererMaskValeur(List<StringBuilder> constitutions, String maskTotal, String newValue) {
		for (int j = maskTotal.length() - newValue.length(); j < maskTotal.length(); j++) {
			String c = String.valueOf(maskTotal.charAt(j));
			if (StringUtils.equals("X", c)) {
				doublerPossibilites(constitutions);
			} else if (StringUtils.equals("0", c)) {
				for (StringBuilder stringBuilder : constitutions) {
					stringBuilder.append(String.valueOf(newValue.charAt(j - (maskTotal.length() - newValue.length()))));
				}
			} else {
				for (StringBuilder stringBuilder : constitutions) {
					stringBuilder.append(c);
				}
			}
		}
	}

	private void doublerPossibilites(List<StringBuilder> constitutions) {
		int sizeFixed = constitutions.size();
		for (int i = 0; i < sizeFixed; i++) {
			StringBuilder n = new StringBuilder(constitutions.get(i));
			n.append("1");
			constitutions.add(n);
			constitutions.get(i).append("0");
		}
	}

}
