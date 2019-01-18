package annees.annee2018.jour04;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import commun.Exercice;
import util.FileUtils;

public abstract class Annee2018Jour4 extends Exercice {

	protected static final Pattern datePattern = Pattern.compile("\\[(.*)\\].*");
	protected static final Pattern minutePattern = Pattern.compile(".*:(.*)\\].*");
	protected static final Pattern idGardePattern = Pattern.compile(".* #(.*) begins.*");

	public Annee2018Jour4() {
		super();
	}

	protected Collection<Garde> inputToGardes(String input) {
		Stream<String> liste = FileUtils.streamOfLines(input);
		List<Ligne> lignes = liste.map(string -> toLigne(string)).collect(toList());

		Collections.sort(lignes);
		HashMap<Integer, Garde> gardes = new HashMap<>();
		Garde gardeEnCours = null;
		Integer minuteDebutDodo = null;
		for (Ligne ligne : lignes) {
			if (ligne.getIdGarde() != null) {
				gardeEnCours = gardes.get(ligne.getIdGarde());
				if (gardeEnCours == null) {
					gardeEnCours = new Garde(ligne.getIdGarde());
					gardes.put(ligne.getIdGarde(), gardeEnCours);
				}
			} else if (minuteDebutDodo == null) {
				minuteDebutDodo = ligne.getMinute();
			} else {
				gardeEnCours.dormir(minuteDebutDodo, ligne.getMinute());
				minuteDebutDodo = null;
			}
		}
		return gardes.values();
	}

	protected Ligne toLigne(String string) {
		String date = FileUtils.trouverPattern(string, datePattern);
		int minute = FileUtils.trouverPatternInt(string, minutePattern);
		Integer idGarde = FileUtils.trouverPatternInt(string, idGardePattern);
		return new Ligne(date, minute, string, idGarde);
	}

}
