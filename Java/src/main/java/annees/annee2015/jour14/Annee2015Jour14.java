package annees.annee2015.jour14;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import commun.Exercice;
import util.FileUtils;

public abstract class Annee2015Jour14 extends Exercice {

	protected static final Pattern rennePattern = Pattern.compile("(.*) can fly .*");
	protected static final Pattern vitessePattern = Pattern.compile(".* can fly (.*) km/s for .*");
	protected static final Pattern endurancePattern = Pattern.compile(".* for (.*) seconds, but then must rest for .*");
	protected static final Pattern reposPattern = Pattern.compile(".* rest for (.*) second.*");

	public List<Renne> inputToRennes(String input) {
		Stream<String> stream = FileUtils.streamOfLines(input);
		return stream.map(string -> {
			String renne = FileUtils.trouverPattern(string, rennePattern);
			int vitesse = FileUtils.trouverPatternInt(string, vitessePattern);
			int endurance = FileUtils.trouverPatternInt(string, endurancePattern);
			int repos = FileUtils.trouverPatternInt(string, reposPattern);
			return new Renne(renne, vitesse, endurance, repos);
		}).collect(Collectors.toList());
	}

}
