package annees.annee2019.jour24;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour24Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour24Exercice1().lancer("src/main/resources/annee2019/jour24/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		Case[][] map = new Case[lignes.size()][lignes.get(0).length()];
		for (int j = 0; j < lignes.size(); j++) {
			String string = lignes.get(j);
			for (int i = 0; i < string.length(); i++) {
				String car = "" + string.charAt(i);
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
		Set<Long> infections = new HashSet<Long>();
		long calcul = 0;
		while (true) {
			for (Case[] cases : map) {
				for (Case cases2 : cases) {
					cases2.setInsectePrec(cases2.isInsecte());
				}
			}
			for (Case[] cases : map) {
				for (Case cases2 : cases) {
					cases2.propagation();
				}
			}
			calcul = 0;
			long doublement = 1;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j].isInsecte()) {
						calcul += doublement;
					}
					doublement *= 2;
				}
			}
			if (!infections.add(calcul)) {
				System.out.println("test");
				break;
			}
		}
		return "" + calcul;
	}

}
