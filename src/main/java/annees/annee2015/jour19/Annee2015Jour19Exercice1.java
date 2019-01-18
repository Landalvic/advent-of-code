package annees.annee2015.jour19;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Annee2015Jour19Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour19Exercice1();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour19/data-remplacement.txt");
		StringBuilder molecule = FileUtils.lireLigne("./annee2015/jour19/data-molecule.txt");

		Pattern departPattern = Pattern.compile("(.*) => .*");
		Pattern arriveePattern = Pattern.compile(".* => (.*)");
		Map<String, List<String>> replacements = new TreeMap<>();

		for (String string : liste) {
			String depart = FileUtils.trouverPattern(string, departPattern);
			String arrivee = FileUtils.trouverPattern(string, arriveePattern);
			List<String> arrivees = replacements.getOrDefault(depart, new ArrayList<>());
			arrivees.add(arrivee);
			replacements.put(depart, arrivees);
		}

		Set<String> moleculesDistinctes = new TreeSet<>();
		for (int i = 0; i < molecule.length(); i++) {
			String m = "" + molecule.charAt(i);
			int decalage = 1;
			if (i < molecule.length() - 1) {
				String m2 = "" + molecule.charAt(i + 1);
				if (StringUtils.isAllLowerCase(m2)) {
					m = m + m2;
					decalage++;
				}
			}
			for (Entry<String, List<String>> entry : replacements.entrySet()) {
				if (StringUtils.equals(entry.getKey(), m)) {
					for (String arrivee : entry.getValue()) {
						moleculesDistinctes.add(molecule.substring(0, i) + arrivee + molecule.substring(i + decalage));
					}
				}
			}
		}

		System.out.println(moleculesDistinctes.size());

	}

}
