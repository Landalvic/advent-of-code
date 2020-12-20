package annees.annee2020.jour14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;
import commun.util.MathUtils;
import commun.util.TexteUtils;

public class Annee2020Jour14Exercice1 extends Annee2020Jour14 {

	public static void main(String[] args) {
		new Annee2020Jour14Exercice1().lancer(true);
	}

	public Annee2020Jour14Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		String maskTotal = "";
		Map<Integer, String> memoire = new HashMap<>();
		for (int i = 0; i < lignes.size(); i++) {
			String string = lignes.get(i);
			if (TexteUtils.findPattern(string, pattern)) {
				enregistrerValue(memoire, string, maskTotal);
			} else {
				maskTotal = string.replace("mask = ", "");
			}
		}
		return String.valueOf(memoire.entrySet().stream().mapToLong(entry -> MathUtils.binaryToLong(entry.getValue(), 2)).sum());
	}

	private void enregistrerValue(Map<Integer, String> memoire, String string, String maskTotal) {
		int[] tab = TexteUtils.trouverPatternInt(string, pattern, 2);
		String newValue = Integer.toBinaryString(tab[1]);
		StringBuilder constitution = new StringBuilder();
		gererMaskAvantValeur(constitution, maskTotal, newValue);
		gererMaskValeur(constitution, maskTotal, newValue);
		memoire.put(tab[0], constitution.toString());
	}

	private void gererMaskAvantValeur(StringBuilder constitution, String maskTotal, String newValue) {
		for (int j = 0; j < maskTotal.length() - newValue.length(); j++) {
			String c = String.valueOf(maskTotal.charAt(j));
			if (StringUtils.equals("X", c)) {
				constitution.append("0");
			} else {
				constitution.append(c);
			}
		}
	}

	private void gererMaskValeur(StringBuilder constitution, String maskTotal, String newValue) {
		for (int j = maskTotal.length() - newValue.length(); j < maskTotal.length(); j++) {
			String c = String.valueOf(maskTotal.charAt(j));
			if (StringUtils.equals("X", c)) {
				constitution.append(String.valueOf(newValue.charAt(j - (maskTotal.length() - newValue.length()))));
			} else {
				constitution.append(c);
			}
		}
	}

}
