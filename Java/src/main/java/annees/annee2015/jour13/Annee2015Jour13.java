package annees.annee2015.jour13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import commun.Exercice;
import util.FileUtils;

public abstract class Annee2015Jour13 extends Exercice {

	private static final Pattern personnePattern = Pattern.compile("(.*) would .*");
	private static final Pattern voisinPattern = Pattern.compile(".* happiness units by sitting next to (.*).");
	private static final Pattern nombrePattern = Pattern
			.compile(".*(?:gain|lose) (.*) happiness units by sitting next to .*");
	protected Map<String, Personne> invites = new HashMap<>();

	public void inputToInvites(String input) throws Exception {
		Stream<String> stream = FileUtils.streamOfLines(input);
		stream.forEach(string -> {
			boolean gain = string.contains(" gain ");
			String personne = FileUtils.trouverPattern(string, personnePattern);
			String voisin = FileUtils.trouverPattern(string, voisinPattern);
			int nombre = FileUtils.trouverPatternInt(string, nombrePattern);

			Personne p = invites.getOrDefault(personne, new Personne(personne));
			Personne pV = invites.getOrDefault(voisin, new Personne(voisin));
			p.getAmities().put(pV, gain ? nombre : -nombre);
			invites.put(personne, p);
			invites.put(voisin, pV);
		});
	}

	public String bonheurMax() {
		int bonheur = invites
				.values()
				.stream()
				.map(lieu -> lieu.placer(new Formation(new ArrayList<>(), 0), invites.values().size()))
				.flatMap(List::stream)
				.mapToInt(formation -> formation.getBonheur())
				.max()
				.getAsInt();
		return String.valueOf(bonheur);
	}

}
