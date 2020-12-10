package annees.annee2015.jour06;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public abstract class Annee2015Jour6 extends Exercice {

	protected static final Pattern turnOnPattern = Pattern.compile("turn on (.*) through .*");
	protected static final Pattern turnOffPattern = Pattern.compile("turn off (.*) through .*");
	protected static final Pattern togglePattern = Pattern.compile("toggle (.*) through .*");
	protected static final Pattern finPattern = Pattern.compile(".* through (.*)");
	protected int[][] lumieres = new int[1000][1000];

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<String> liste = FileUtils.streamOfLines(input);
		liste.forEach(string -> allumerLumiere(string));
		int total = 0;
		for (int i = 0; i < lumieres.length; i++) {
			for (int j = 0; j < lumieres[0].length; j++) {
				total += lumieres[i][j];
			}
		}
		return String.valueOf(total);
	}

	private void allumerLumiere(String string) {
		String[] positionFin = FileUtils.trouverPattern(string, finPattern).split(",");
		String debut = FileUtils.trouverPattern(string, turnOnPattern);
		Action action = Action.ALLUMER;
		if (debut == null) {
			debut = FileUtils.trouverPattern(string, turnOffPattern);
			action = Action.ETEINDRE;
			if (debut == null) {
				debut = FileUtils.trouverPattern(string, togglePattern);
				action = Action.BASCULER;
			}
		}
		String[] positionDebut = debut.split(",");
		int positionXDebut = Integer.valueOf(positionDebut[0]);
		int positionYDebut = Integer.valueOf(positionDebut[1]);
		int positionXFin = Integer.valueOf(positionFin[0]);
		int positionYFin = Integer.valueOf(positionFin[1]);
		switch (action) {
		case ALLUMER:
			for (int i = positionXDebut; i <= positionXFin; i++) {
				for (int j = positionYDebut; j <= positionYFin; j++) {
					lumieres[i][j] = allumer(lumieres[i][j]);
				}
			}
			break;
		case ETEINDRE:
			for (int i = positionXDebut; i <= positionXFin; i++) {
				for (int j = positionYDebut; j <= positionYFin; j++) {
					lumieres[i][j] = eteindre(lumieres[i][j]);
				}
			}
			break;
		case BASCULER:
			for (int i = positionXDebut; i <= positionXFin; i++) {
				for (int j = positionYDebut; j <= positionYFin; j++) {
					lumieres[i][j] = basculer(lumieres[i][j]);
				}
			}
			break;
		}
	}

	protected abstract int allumer(int lumiere);

	protected abstract int eteindre(int lumiere);

	protected abstract int basculer(int lumiere);

}
