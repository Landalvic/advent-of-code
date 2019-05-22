package annees.annee2015.jour19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Annee2015Jour19Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour19Exercice2();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour19/data-remplacement.txt");
		StringBuilder molecule = FileUtils.lireLigne("./annee2015/jour19/data-molecule.txt");

		Pattern departPattern = Pattern.compile("(.*) => .*");
		Pattern arriveePattern = Pattern.compile(".* => (.*)");
		Map<String, List<String>> replacements = new TreeMap<>();

		for (String string : liste) {
			String arrivee = FileUtils.trouverPattern(string, departPattern);
			String depart = FileUtils.trouverPattern(string, arriveePattern);
			List<String> arrivees = replacements.getOrDefault(depart, new ArrayList<>());
			arrivees.add(arrivee);
			replacements.put(depart, arrivees);
		}

		Set<String> moleculesDistinctes = new TreeSet<>();
		int nbrEtape = 0;
		moleculesDistinctes.add(molecule.toString());
		while (!fini(moleculesDistinctes)) {
			nbrEtape++;
			Set<String> newMolecules = new TreeSet<>();
			Iterator<String> iterateur = moleculesDistinctes.iterator();
			while (iterateur.hasNext()) {
				String mol = (String) iterateur.next();
				for (Entry<String, List<String>> entry : replacements.entrySet()) {
					int index = mol.indexOf(entry.getKey());
					if (index >= 0) {
						newMolecules.add(mol.substring(0, index) + entry.getValue().get(0)
								+ mol.substring(index + entry.getKey().length()));
						if (newMolecules.size() > 100) {
							break;
						}
					}
				}
			}
			moleculesDistinctes = newMolecules;
		}
		System.out.println(moleculesDistinctes);
		System.out.println(nbrEtape);

	}

	private boolean fini(Set<String> moleculesDistinctes) {
		for (String string : moleculesDistinctes) {
			if (StringUtils.equals(string, "e")) {
				return true;
			}
		}
		return false;
	}

}
