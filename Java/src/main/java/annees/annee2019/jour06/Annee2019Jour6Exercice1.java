package annees.annee2019.jour06;

import java.util.HashMap;
import java.util.Map;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour6Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour6Exercice1().lancer("src/main/resources/annee2019/jour06/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		Map<String, Orbite> orbites = new HashMap<>();
		for (String stringO : lignes) {
			var blocs = stringO.split("\\)");
			orbites.computeIfAbsent(blocs[0], s -> new Orbite(s)).ajouterEnfant(orbites.computeIfAbsent(blocs[1], s -> new Orbite(s)));
		}
		var count = orbites.entrySet().stream().mapToInt(orbite -> orbite.getValue().calculerParents()).sum();
		return "" + count;
	}

}
