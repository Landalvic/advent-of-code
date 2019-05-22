package annees.annee2018.jour17;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import commun.Exercice;
import util.FileUtils;

public class Jour17Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Jour17Exercice2().lancer("src/main/resources/annee2018/jour17/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		List<String> liste = FileUtils.listOfLines(input);
		Pattern axe1Pattern = Pattern.compile(".*=(.*),.*");
		Pattern debutPattern = Pattern.compile(".*=(.*)\\.\\..*");
		Pattern finPattern = Pattern.compile(".*\\.\\.(.*)");
		List<LigneArgile> argiles = new ArrayList<>(liste.size());
		int minY = 9999;
		int minX = 9999;
		int maxX = 0;
		int maxY = 0;
		for (String string : liste) {
			int debut = FileUtils.trouverPatternInt(string, debutPattern);
			int fin = FileUtils.trouverPatternInt(string, finPattern);
			int axe1 = FileUtils.trouverPatternInt(string, axe1Pattern);
			LigneArgile argile;
			if (StringUtils.equalsIgnoreCase("" + string.charAt(0), "x")) {
				argile = new LigneArgile(axe1, axe1, debut, fin);
			} else {
				argile = new LigneArgile(debut, fin, axe1, axe1);
			}
			argiles.add(argile);
			if (maxX < argile.getEndX()) {
				maxX = argile.getEndX();
			}
			if (maxY < argile.getEndY()) {
				maxY = argile.getEndY();
			}
			if (minX > argile.getStartX()) {
				minX = argile.getStartX();
			}
			if (minY > argile.getStartY()) {
				minY = argile.getStartY();
			}
		}
		Zone[][] zone = new Zone[maxX - minX + 3][maxY + 1];
		for (int i = 0; i < zone.length; i++) {
			for (int j = 0; j < zone[0].length; j++) {
				zone[i][j] = new Zone();
			}
		}
		for (int i = 0; i < zone.length; i++) {
			for (int j = 0; j < zone[0].length; j++) {
				if (j > 0) {
					zone[i][j].setZoneHaut(zone[i][j - 1]);
				}
				if (j < zone[0].length - 1) {
					zone[i][j].setZoneBas(zone[i][j + 1]);
				}
				if (i > 0) {
					zone[i][j].setZoneGauche(zone[i - 1][j]);
				}
				if (i < zone.length - 1) {
					zone[i][j].setZoneDroite(zone[i + 1][j]);
				}
			}
		}
		for (LigneArgile argile : argiles) {
			for (int i = argile.getStartX(); i < argile.getEndX() + 1; i++) {
				for (int j = argile.getStartY(); j < argile.getEndY() + 1; j++) {
					zone[i - minX + 1][j].setArgile(true);
				}
			}
		}
		zone[500 - minX + 1][0].deplacementBasEau();
		int nbrEau = 0;
		for (int j = minY; j < zone[0].length; j++) {
			for (int i = 0; i < zone.length; i++) {
				if (zone[i][j].isEauStagnante()) {
					nbrEau++;
				}
			}
		}
		System.out.println(nbrEau);
		return "" + nbrEau;
	}

}
