package annees.annee2020.jour15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2020Jour15 extends Exercice {

	public Annee2020Jour15(int exercice) {
		super(2020, 15, exercice);
	}

	@Override
	protected void init() {}

	public String runCommun(String input, int total) throws AdventOfCodeException {
		String ligne = FileUtils.firstLine(input);
		List<Integer> lignes = Stream.of(ligne.split(",", -1)).map(Integer::parseInt).collect(Collectors.toList());
		Map<Integer, Nombre> dejaVus = new HashMap<>();
		Nombre last = new Nombre(0, 0);
		AtomicBoolean dejaVu = new AtomicBoolean(dejaVus.containsKey(last.getValue()));
		for (int i = 0; i < lignes.size(); i++) {
			var n = new Nombre(lignes.get(i), i + 1);
			dejaVus.put(n.getValue(), n);
			dejaVu.set(dejaVus.containsKey(last.getValue()));
			last = n;
		}
		for (int i = lignes.size(); i < total; i++) {
			if (dejaVu.get()) {
				var lastN = dejaVus.get(last.getValue());
				int lastTour = lastN.getLastTour();
				lastN.setLastTour(i);
				last = ajouterSiNouveau(dejaVus, dejaVu, i - lastTour, i + 1);
			} else {
				last = ajouterSiNouveau(dejaVus, dejaVu, 0, i);
			}
		}
		return String.valueOf(last.getValue());
	}

	private Nombre ajouterSiNouveau(Map<Integer, Nombre> dejaVus, AtomicBoolean dejaVu, int value, int lastTour) {
		var n = new Nombre(value, lastTour);
		dejaVu.set(dejaVus.containsKey(n.getValue()));
		if (!dejaVu.get()) {
			dejaVus.put(n.getValue(), n);
		}
		return n;
	}

}
