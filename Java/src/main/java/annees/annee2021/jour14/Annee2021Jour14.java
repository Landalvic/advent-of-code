package annees.annee2021.jour14;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.StreamBuilder;
import commun.structure.AdventOfCodeException;
import commun.structure.ExerciceInputToObject;
import commun.util.FileUtils;
import commun.util.TexteUtils;

public abstract class Annee2021Jour14 extends ExerciceInputToObject<Regle> {

	protected Annee2021Jour14(int exercice) {
		super(2021, 14, exercice);
	}

	@Override
	protected Regle ligneToObject(String ligne) {
		return TexteUtils.transformerPattern(ligne, Regle.class);
	}

	public String runCommun(String input, int nombreEtapes) throws AdventOfCodeException {
		var polymere = FileUtils.firstLineOfStreamBuilder(input);
		var regles = inputToListObjectNotNull(input);
		mettreAJourFormule(regles);
		HashMap<String, Long> lettres = new HashMap<>();
		polymere.forEach(caractere -> lettres.put(caractere, lettres.computeIfAbsent(caractere, r -> 0L) + 1));
		HashMap<Regle, Long> formule = remplirFormuleDepart(polymere, regles);
		for (int i = 0; i < nombreEtapes; i++) {
			formule.entrySet().forEach(entry -> lettres.put(entry.getKey().getInsertion(), lettres.computeIfAbsent(entry.getKey().getInsertion(), r -> 0L) + entry.getValue()));
			HashMap<Regle, Long> newFormule = new HashMap<>();
			formule.entrySet().forEach(entry -> {
				for (Regle regle : entry.getKey().getRegles()) {
					newFormule.put(regle, entry.getValue() + newFormule.computeIfAbsent(regle, r -> 0L));
				}
			});
			formule = newFormule;
		}
		var max = lettres.values().stream().mapToLong(c -> c).max().orElseThrow();
		var min = lettres.values().stream().mapToLong(c -> c).min().orElseThrow();
		return String.valueOf(max - min);
	}

	protected void mettreAJourFormule(List<Regle> regles) {
		for (Regle regle : regles) {
			var sousRegle1 = regles.stream()
					.filter(r -> StringUtils.equals(r.getPaire(), regle.getPaire().charAt(0) + regle.getInsertion())).findAny().orElse(null);
			if (sousRegle1 != null) {
				regle.getRegles().add(sousRegle1);
			}
			var sousRegle2 = regles.stream()
					.filter(r -> StringUtils.equals(r.getPaire(), regle.getInsertion() + regle.getPaire().charAt(1))).findAny().orElse(null);
			if (sousRegle2 != null) {
				regle.getRegles().add(sousRegle2);
			}
		}
	}

	protected HashMap<Regle, Long> remplirFormuleDepart(StreamBuilder polymere, List<Regle> regles) {
		HashMap<Regle, Long> formuleDepart = new HashMap<>();
		polymere.forEach(caractere -> {
			if (polymere.getIndex() != polymere.size() - 1) {
				var regle = regles.stream()
						.filter(r -> StringUtils.equals(r.getPaire(), caractere + polymere.charAt(polymere.getIndex() + 1))).findAny().orElse(null);
				formuleDepart.put(regle, formuleDepart.computeIfAbsent(regle, r -> 0L) + 1);
			}
		});
		return formuleDepart;
	}

}
