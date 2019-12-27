package annees.annee2019.jour24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour24Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour24Exercice2().lancer("src/main/resources/annee2019/jour24/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		Case[][] map = new Case[lignes.size()][lignes.get(0).length()];
		List<Grille> grilles = new ArrayList<Grille>();
		Grille grilleCentrale = new Grille();
		grilles.add(grilleCentrale);
		for (int j = 0; j < lignes.size(); j++) {
			String string = lignes.get(j);
			for (int i = 0; i < string.length(); i++) {
				String car = "" + string.charAt(i);
				if (StringUtils.equals(car, "?")) {
				} else {
					Case c = new Case(i, j);
					map[j][i] = c;
					if (StringUtils.equals(car, "#")) {
						c.setInsecte(true);
					}
					if (i > 0) {
						c.setOuest(map[j][i - 1]);
					}
					if (j > 0) {
						c.setNord(map[j - 1][i]);
					}
				}
			}
		}
		grilleCentrale.setMap(map);
		grilles.add(grilleCentrale.ajouterGrilleCentrale());
		grilles.add(grilleCentrale.ajouterGrilleExterieur());
		long calcul = 0;
		for (int k = 0; k < 200; k++) {
			calcul = 0;
			for (int i = 0; i < grilles.size(); i++) {
				var newGrille = grilles.get(i).ajouterGrille();
				if (newGrille != null) {
					grilles.add(newGrille);
				}
			}
			Collections.sort(grilles);
			for (Grille grille : grilles) {
				grille.visualiserMap();
			}
			System.out.println("--------");
			for (Grille grille : grilles) {
				for (Case[] cases : grille.getMap()) {
					for (Case cases2 : cases) {
						if (!cases2.isGrille()) {
							cases2.setInsectePrec(cases2.isInsecte());
						}
					}
				}
			}
			for (Grille grille : grilles) {
				for (Case[] cases : grille.getMap()) {
					for (Case cases2 : cases) {
						if (!cases2.isGrille()) {
							cases2.propagation();
						}
					}
				}
			}
			for (Grille grille : grilles) {
				for (int i = 0; i < grille.getMap().length; i++) {
					for (int j = 0; j < grille.getMap()[i].length; j++) {
						if (!grille.getMap()[i][j].isGrille() && grille.getMap()[i][j].isInsecte()) {
							calcul++;
						}
					}
				}
			}
			System.out.println(calcul);
		}
		return "" + calcul;
	}

}
