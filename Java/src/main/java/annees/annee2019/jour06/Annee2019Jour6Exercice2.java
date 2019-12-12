package annees.annee2019.jour06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour6Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour6Exercice2().lancer("src/main/resources/annee2019/jour06/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		Map<String, Orbite> orbites = new HashMap<>();
		for (String stringO : lignes) {
			var blocs = stringO.split("\\)");
			orbites.computeIfAbsent(blocs[0], s -> new Orbite(s)).ajouterEnfant(orbites.computeIfAbsent(blocs[1], s -> new Orbite(s)));
		}
		var you = orbites.get("YOU");
		List<List<Orbite>> chemins = new ArrayList<>();
		chemins.add(Arrays.asList(you));
		List<Orbite> bonChemin = null;
		a: while (true) {
			for (int i = 0; i < chemins.size(); i++) {
				var chemin = chemins.remove(i);
				var last = chemin.get(chemin.size() - 1);
				for (Orbite o : last.getParents()) {
					if (!chemin.contains(o)) {
						List<Orbite> newChemin = new ArrayList<>(chemin);
						newChemin.add(o);
						chemins.add(newChemin);
						if (StringUtils.equals(o.getCode(), "SAN")) {
							bonChemin = newChemin;
							break a;
						}
					}
				}
				for (Orbite o : last.getEnfants()) {
					if (!chemin.contains(o)) {
						List<Orbite> newChemin = new ArrayList<>(chemin);
						newChemin.add(o);
						chemins.add(newChemin);
						if (StringUtils.equals(o.getCode(), "SAN")) {
							bonChemin = newChemin;
							break a;
						}
					}
				}
			}
		}
		return "" + (bonChemin.size() - 3);
	}

}
