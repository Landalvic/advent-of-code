package annees.annee2021.jour08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import commun.structure.AdventOfCodeException;
import commun.util.TexteUtils;

public class Annee2021Jour8Exercice2 extends Annee2021Jour8 {

	public static void main(String[] args) {
		new Annee2021Jour8Exercice2().lancer(true);
	}

	public Annee2021Jour8Exercice2() {
		super(2);
	}

	@Override
	protected int transformCode(CodeDigits code) {
		List<Digit> digits = new ArrayList<>(10);
		Map<Integer, String> correspondance = new HashMap<>();
		for (var digit : code.getDigits()) {
			if (digit.length() == 4) {
				digits.add(new Digit(digit, 4));
				correspondance.put(4, digit);
			} else if (digit.length() == 2) {
				digits.add(new Digit(digit, 1));
				correspondance.put(1, digit);
			} else if (digit.length() == 7) {
				digits.add(new Digit(digit, 8));
				correspondance.put(8, digit);
			} else if (digit.length() == 3) {
				digits.add(new Digit(digit, 7));
				correspondance.put(7, digit);
			}
		}
		var liste1 = TexteUtils.stringToList(correspondance.get(1));
		var liste4 = TexteUtils.stringToList(correspondance.get(4));
		var liste8 = TexteUtils.stringToList(correspondance.get(8));
		for (var digit : code.getDigits()) {
			traiterDigit(digit, digits, liste1, liste4, liste8);
		}
		try {
			int total = 0;
			for (int i = 0; i < code.getOutput().length; i++) {
				total += findDigit(digits, code.getOutput()[i]) * Math.pow(10, (double) code.getOutput().length - 1 - i);
			}
			return total;
		} catch (AdventOfCodeException e) {
			return 0;
		}
	}

	protected void traiterDigit(String digit, List<Digit> digits, List<String> liste1, List<String> liste4, List<String> liste8) {
		var listeAComparer = TexteUtils.stringToList(digit);
		if (digit.length() == 5) {
			if (listeAComparer.containsAll(liste1)) {
				digits.add(new Digit(digit, 3));
			} else if (CollectionUtils.retainAll(liste4, listeAComparer).size() == 3) {
				digits.add(new Digit(digit, 5));
			} else if (CollectionUtils.retainAll(liste4, listeAComparer).size() == 2) {
				digits.add(new Digit(digit, 2));
			}
		} else if (digit.length() == 6) {
			var listeRestante = CollectionUtils.removeAll(liste8, listeAComparer);
			if (CollectionUtils.retainAll(listeRestante, liste1).size() == 1) {
				digits.add(new Digit(digit, 6));
			} else if (CollectionUtils.retainAll(listeRestante, liste4).size() == 1) {
				digits.add(new Digit(digit, 0));
			} else if (CollectionUtils.retainAll(listeRestante, liste4).isEmpty()) {
				digits.add(new Digit(digit, 9));
			}
		}
	}

	protected int findDigit(List<Digit> digits, String wires) throws AdventOfCodeException {
		for (Digit digit : digits) {
			var listeDigit = TexteUtils.stringToList(digit.getWires());
			var listeOutput = TexteUtils.stringToList(wires);
			if (CollectionUtils.isEqualCollection(listeDigit, listeOutput)) {
				return digit.getNombre();
			}
		}
		throw new AdventOfCodeException("wire non trouvé.");
	}

}
