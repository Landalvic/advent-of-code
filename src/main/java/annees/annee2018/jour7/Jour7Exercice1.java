package annees.annee2018.jour7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour7Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour7/data.txt");
		Pattern avantPattern = Pattern.compile("Step (.*) must be.*");
		Pattern apresPattern = Pattern.compile(".*before step (.*) can begin.*");
		HashMap<String, Etape> etapes = new HashMap<>();
		for (String string : liste) {
			String avant = FileUtils.trouverPattern(string, avantPattern);
			String apres = FileUtils.trouverPattern(string, apresPattern);
			etapes.putIfAbsent(avant, new Etape(avant));
			etapes.putIfAbsent(apres, new Etape(apres));
			Etape etapeAvant = etapes.get(avant);
			Etape etapeApres = etapes.get(apres);
			etapeApres.getConditions().add(etapeAvant);
		}
		StringBuilder ordre = new StringBuilder();

		while (!etapes.values().isEmpty()) {
			List<Etape> etapesPossibles = new ArrayList<>();
			for (Etape etape : etapes.values()) {
				if (!etape.resteConditions()) {
					etapesPossibles.add(etape);
				}
			}
			Collections.sort(etapesPossibles);
			etapesPossibles.get(0).setFini(true);
			ordre.append(etapesPossibles.get(0).getId());
			etapes.remove(etapesPossibles.get(0).getId());
		}

		System.out.println(ordre);
	}

}
