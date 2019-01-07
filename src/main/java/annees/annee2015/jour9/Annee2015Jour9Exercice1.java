package annees.annee2015.jour9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour9Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour9Exercice1();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour9/data.txt");
		Pattern lieuDepartPattern = Pattern.compile("(.*) to .*");
		Pattern lieuArrivePattern = Pattern.compile(".* to (.*) = .*");
		Pattern distancePattern = Pattern.compile(".* = (.*)");
		Map<String, Lieu> lieux = new HashMap<>();
		for (String string : liste) {
			String lieuDepart = FileUtils.trouverPattern(string, lieuDepartPattern);
			String lieuArrive = FileUtils.trouverPattern(string, lieuArrivePattern);
			int distance = FileUtils.trouverPatternInt(string, distancePattern);
			Lieu lDepart = lieux.getOrDefault(lieuDepart, new Lieu(lieuDepart));
			Lieu lArrive = lieux.getOrDefault(lieuArrive, new Lieu(lieuArrive));
			lDepart.getDistance().put(lArrive, distance);
			lArrive.getDistance().put(lDepart, distance);
			lieux.put(lieuDepart, lDepart);
			lieux.put(lieuArrive, lArrive);
		}

		List<Chemin> chemins = new ArrayList<>();
		for (Lieu lieu : lieux.values()) {
			chemins.addAll(lieu.parcourir(new Chemin(new ArrayList<>(), 0), lieux.values().size()));
		}
		int distanceMin = 999999999;
		for (Chemin chemin : chemins) {
			distanceMin = Math.min(chemin.getDistance(), distanceMin);
		}
		System.out.println(distanceMin);

	}

}
