package annee.annee2018.jour7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour7Exercice2 {

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

		int nbrSecondes = 0;
		Etape[] travailleurs = new Etape[5];
		do {
			for (int i = 0; i < travailleurs.length; i++) {
				if (travailleurs[i] != null) {
					travailleurs[i].setTemps(travailleurs[i].getTemps() - 1);
					if (travailleurs[i].getTemps() <= 0) {
						travailleurs[i].setFini(true);
						travailleurs[i] = null;
					}
				}
			}
			List<Etape> etapesPossibles = new ArrayList<>();
			for (Etape etape : etapes.values()) {
				if (!etape.resteConditions()) {
					etapesPossibles.add(etape);
				}
			}
			Collections.sort(etapesPossibles);
			for (int i = 0; i < travailleurs.length; i++) {
				if (travailleurs[i] == null && etapesPossibles.size() > 0) {
					travailleurs[i] = etapesPossibles.remove(0);
					etapes.remove(travailleurs[i].getId());
				}
			}

			nbrSecondes++;
		} while (!etapes.values().isEmpty() || !isChomage(travailleurs));

		System.out.println(nbrSecondes - 1);
	}

	private static boolean isChomage(Etape[] travailleurs) {
		for (Etape travailleur : travailleurs) {
			if (travailleur != null) {
				return false;
			}
		}
		return true;
	}

}
