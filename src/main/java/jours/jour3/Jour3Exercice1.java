package jours.jour3;

import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour3Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour3/data.txt");
		Pattern distanceGauchePattern = Pattern.compile(".* @ (.*),.*");
		Pattern distanceHautPattern = Pattern.compile(".*,(.*): .*");
		Pattern largeurPattern = Pattern.compile(".*: (.*)x.*");
		Pattern hauteurPattern = Pattern.compile(".*x(.*)");
		int[][] tissu = new int[1000][1000];
		for (String string : liste) {
			int distanceGauche = FileUtils.trouverPatternInt(string, distanceGauchePattern);
			int distanceHaut = FileUtils.trouverPatternInt(string, distanceHautPattern);
			int largeur = FileUtils.trouverPatternInt(string, largeurPattern);
			int hauteur = FileUtils.trouverPatternInt(string, hauteurPattern);
			for (int i = 0; i < largeur; i++) {
				for (int j = 0; j < hauteur; j++) {
					tissu[i + distanceGauche][j + distanceHaut]++;
				}
			}
		}
		int total = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (tissu[i][j] >= 2) {
					total++;
				}
			}
		}
		System.out.println(total);
	}

}
