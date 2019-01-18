package annees.annee2015.jour6;

import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Annee2015Jour6Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour6Exercice2();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour6/data.txt");
		Pattern turnOnPattern = Pattern.compile("turn on (.*) through .*");
		Pattern turnOffPattern = Pattern.compile("turn off (.*) through .*");
		Pattern togglePattern = Pattern.compile("toggle (.*) through .*");
		Pattern finPattern = Pattern.compile(".* through (.*)");
		int[][] lumieres = new int[1000][1000];
		for (String string : liste) {
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
						lumieres[i][j] = lumieres[i][j] + 1;
					}
				}
				break;
			case ETEINDRE:
				for (int i = positionXDebut; i <= positionXFin; i++) {
					for (int j = positionYDebut; j <= positionYFin; j++) {
						if (lumieres[i][j] > 0) {
							lumieres[i][j] = lumieres[i][j] - 1;
						}
					}
				}
				break;
			case BASCULER:
				for (int i = positionXDebut; i <= positionXFin; i++) {
					for (int j = positionYDebut; j <= positionYFin; j++) {
						lumieres[i][j] = lumieres[i][j] + 2;
					}
				}
				break;
			}
		}
		int total = 0;
		for (int i = 0; i < lumieres.length; i++) {
			for (int j = 0; j < lumieres[0].length; j++) {
				total += lumieres[i][j];
			}
		}
		System.out.println(total);

	}

}
