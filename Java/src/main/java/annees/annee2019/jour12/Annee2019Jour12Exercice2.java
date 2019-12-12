package annees.annee2019.jour12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour12Exercice2 extends Exercice {

	protected static final Pattern pattern = Pattern.compile("<x=(.*), y=(.*), z=(.*)>");

	public static void main(String[] args) {
		new Annee2019Jour12Exercice2().lancer("src/main/resources/annee2019/jour12/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.streamOfLines(input);
		var lunes = lignes.map(ligne -> {
			var matcher = FileUtils.trouverPatternInt(ligne, pattern, 3);
			return new Lune(matcher[0], matcher[1], matcher[2]);
		}).collect(Collectors.toList());
		int i = 0;
		Set<Integer> list = new HashSet<>();
		boolean fin = false;
		while (!fin) {
			i++;
			for (var lune : lunes) {
				lune.calculerVitesse(lunes);
			}
			for (var lune : lunes) {
				lune.deplacer();
			}
			fin = true;
			for (var lune : lunes) {
				if (!lune.fin()) {
					fin = false;
					break;
				}
			}
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (var lune : lunes) {
			var freq = countFrequencies(decom(lune.getCycleX().size()));
			for (var entry : freq.entrySet()) {
				if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
					map.put(entry.getKey(), entry.getValue());
				}
			}
			freq = countFrequencies(decom(lune.getCycleY().size()));
			for (var entry : freq.entrySet()) {
				if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
					map.put(entry.getKey(), entry.getValue());
				}
			}
			freq = countFrequencies(decom(lune.getCycleZ().size()));
			for (var entry : freq.entrySet()) {
				if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
					map.put(entry.getKey(), entry.getValue());
				}
			}
		}
		long sum = 1;
		for (var entry : map.entrySet()) {
			sum *= Math.pow(entry.getKey(), entry.getValue());
		}
		return "" + sum;
	}

	public static Map<Integer, Integer> countFrequencies(List<Integer> list) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (Integer i : list) {
			Integer j = hm.get(i);
			hm.put(i, (j == null) ? 1 : j + 1);
		}
		return hm;
	}

	public List<Integer> decom(int n) {
		List<Integer> liste = new ArrayList<>();
		if (n < 2) {
			return liste;
		}
		for (var i = 2; i <= n; i++) {
			while (n % i == 0) {
				liste.add(i);
				n /= i;
			}
		}
		return liste;
	};

}
