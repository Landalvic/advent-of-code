package annees.annee2015.jour07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public abstract class Annee2015Jour7 extends Exercice {

	protected static final Pattern operationPattern = Pattern.compile("(.*) -> .*");
	protected static final Pattern wireArriveePattern = Pattern.compile(".* -> (.*)");

	public String runCommun(String input, Integer b) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		Map<String, Integer> map = new HashMap<>();

		int decalage = 0;
		while (liste.size() > 0) {
			String string = liste.get(decalage);
			String wireArrivee = FileUtils.trouverPattern(string, wireArriveePattern);
			String operation = FileUtils.trouverPattern(string, operationPattern);
			boolean affecte = true;
			boolean problemeAffectation = false;
			for (Operation o : Operation.values()) {
				String[] bloc = operation.split(o.getPattern());
				if (bloc.length == 2) {
					if ((StringUtils.isNotEmpty(bloc[0]) && getValeur(map, bloc[0]) == null)
							|| StringUtils.isNotEmpty(bloc[1]) && getValeur(map, bloc[1]) == null) {
						problemeAffectation = true;
						break;
					}
					affecte = false;
					switch (o) {
					case AND:
						map.put(wireArrivee, getValeur(map, bloc[0]) & getValeur(map, bloc[1]));
						break;
					case OR:
						map.put(wireArrivee, getValeur(map, bloc[0]) | getValeur(map, bloc[1]));
						break;
					case LSHIFT:
						map.put(wireArrivee, getValeur(map, bloc[0]) << getValeur(map, bloc[1]));
						break;
					case RSHIFT:
						map.put(wireArrivee, getValeur(map, bloc[0]) >> getValeur(map, bloc[1]));
						break;
					case NOT:
						map.put(wireArrivee, 65535 ^ getValeur(map, bloc[1]));
						break;
					default:
						break;
					}
					break;
				}
			}
			if (!problemeAffectation && affecte) {
				if (b != null && StringUtils.equals(wireArrivee, "b")) {
					map.put(wireArrivee, b);
				} else if (getValeur(map, operation) == null) {
					problemeAffectation = true;
				} else {
					map.put(wireArrivee, getValeur(map, operation));
				}
			}
			if (!problemeAffectation) {
				liste.remove(decalage);
				decalage = 0;
			} else {
				decalage++;
			}
		}
		return map.get("a").toString();
	}

	private Integer getValeur(Map<String, Integer> map, String valeur) {
		if (NumberUtils.isDigits(valeur)) {
			return Integer.valueOf(valeur);
		} else {
			return map.getOrDefault(valeur, null);
		}
	}

}
