package annees.annee2021.jour08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commun.util.ListUtils;
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
		Map<Integer, String> correspondance2 = new HashMap<>();
		for (var digit : code.getDigits()) {
			if (digit.length() == 4) {
				digits.add(new Digit(digit, 4));
				correspondance2.put(4, digit);
			} else if (digit.length() == 2) {
				digits.add(new Digit(digit, 1));
				correspondance2.put(1, digit);
			} else if (digit.length() == 7) {
				digits.add(new Digit(digit, 8));
				correspondance2.put(8, digit);
			} else if (digit.length() == 3) {
				digits.add(new Digit(digit, 7));
				correspondance2.put(7, digit);
			}
		}
		var liste1 = TexteUtils.stringToList(correspondance2.get(1));
		var liste4 = TexteUtils.stringToList(correspondance2.get(4));
		var liste8 = TexteUtils.stringToList(correspondance2.get(8));
		for (var digit : code.getDigits()) {
			var listeAComparer = TexteUtils.stringToList(digit);
			if (digit.length() == 5) {
				if (listeAComparer.containsAll(liste1)) {
					digits.add(new Digit(digit, 3));
					correspondance2.put(3, digit);
				} else if (ListUtils.retainAllNewListe(liste4, listeAComparer).size() == 3) {
					digits.add(new Digit(digit, 5));
					correspondance2.put(5, digit);
				} else if (ListUtils.retainAllNewListe(liste4, listeAComparer).size() == 2) {
					digits.add(new Digit(digit, 2));
					correspondance2.put(2, digit);
				}
			} else if (digit.length() == 6) {
				var listeRestante = ListUtils.removeAllNewListe(liste8, listeAComparer);
				if (ListUtils.retainAllNewListe(listeRestante, liste1).size() == 1) {
					digits.add(new Digit(digit, 6));
					correspondance2.put(6, digit);
				} else if (ListUtils.retainAllNewListe(listeRestante, liste4).size() == 1) {
					digits.add(new Digit(digit, 0));
					correspondance2.put(0, digit);
				} else if (ListUtils.retainAllNewListe(listeRestante, liste4).isEmpty()) {
					digits.add(new Digit(digit, 9));
					correspondance2.put(9, digit);
				}
			}
		}
		return findDigit(digits, code.getOutput()[0]) * 1000 + findDigit(digits, code.getOutput()[1]) * 100 + findDigit(digits, code.getOutput()[2]) * 10
				+ findDigit(digits, code.getOutput()[3]);
	}

	protected int findDigit(List<Digit> digits, String wires) {
		for (Digit digit : digits) {
			var listeDigit = TexteUtils.stringToList(digit.getWires());
			var listeOutput = TexteUtils.stringToList(wires);
			if (listeDigit.containsAll(listeOutput) && listeOutput.containsAll(listeDigit)) {
				return digit.getNombre();
			}
		}
		return -1;
	}

}
