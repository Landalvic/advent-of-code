package annees.annee2015.jour09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2015Jour9 extends Exercice {

	protected static final Pattern lieuDepartPattern = Pattern.compile("(.*) to .*");
	protected static final Pattern lieuArrivePattern = Pattern.compile(".* to (.*) = .*");
	protected static final Pattern distancePattern = Pattern.compile(".* = (.*)");

	public IntStream runCommun(String input) throws AdventOfCodeException {
		Stream<String> stream = FileUtils.streamOfLines(input);
		Map<String, Lieu> lieux = new HashMap<>();
		stream.forEach(string -> {
			String lieuDepart = FileUtils.trouverPattern(string, lieuDepartPattern);
			String lieuArrive = FileUtils.trouverPattern(string, lieuArrivePattern);
			int distance = FileUtils.trouverPatternInt(string, distancePattern);
			Lieu lDepart = lieux.getOrDefault(lieuDepart, new Lieu(lieuDepart));
			Lieu lArrive = lieux.getOrDefault(lieuArrive, new Lieu(lieuArrive));
			lDepart.getDistance().put(lArrive, distance);
			lArrive.getDistance().put(lDepart, distance);
			lieux.put(lieuDepart, lDepart);
			lieux.put(lieuArrive, lArrive);
		});

		List<Chemin> chemins = new ArrayList<>();
		for (Lieu lieu : lieux.values()) {
			chemins.addAll(lieu.parcourir(new Chemin(new ArrayList<>(), 0), lieux.values().size()));
		}
		return chemins.stream().mapToInt(chemin -> chemin.getDistance());

	}

}
