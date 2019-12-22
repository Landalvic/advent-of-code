package annees.annee2019.jour19;

import java.util.ArrayList;
import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour19Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour19Exercice2().lancer("src/main/resources/annee2019/jour19/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		List<Long> inputs = new ArrayList<Long>();
		long x = 0;
		long y = 0;
		long minX = 0;
		long maxX = 0;
		boolean avant = true;
		List<Ligne> lignes = new ArrayList<Ligne>();
		while (true) {
			inputs.add(x);
			inputs.add(y);
			code.init();
			Long retour = code.lancer(inputs);
			if (retour == 0) {
				if (avant) {
					x++;
					minX++;
				} else {
					x = minX;
					y++;
					avant = true;
				}
			} else {
				if (avant) {
					avant = false;
					lignes.add(new Ligne(x, y, 1));
				}
				var l = lignes.get(lignes.size() - 1);
				if (x < maxX) {
					l.addNombre(maxX - x);
					x = maxX;
				} else if (maxX < x) {
					l.addNombre();
					maxX = x;
				}
				while (lignes.size() > 1 && l.getX() > lignes.get(lignes.size() - 2).getX()) {
					for (int i = 0; i < lignes.size() - 1; i++) {
						if (!lignes.get(i).baisserLongueur()) {
							lignes.remove(i);
							i--;
						}
					}
				}
				if (l.getNbr() >= 100 && lignes.size() >= 100) {
					break;
				}
				x++;
			}
		}
		return "" + ((lignes.get(0).getX() * 10000) + lignes.get(0).getY());
	}

}
