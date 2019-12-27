package annees.annee2019.jour17;

import java.util.ArrayList;
import java.util.List;

import annees.annee2019.IntCode;
import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour17Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour17Exercice1().lancer("src/main/resources/annee2019/jour17/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		var code = new IntCode(ligne);
		List<List<Case>> map = new ArrayList<List<Case>>();
		List<Case> ligneEnCours = new ArrayList<Case>();
		map.add(ligneEnCours);
		int x = 0;
		int y = 0;
		while (!code.isFini()) {
			Long retour = code.lancerFirstOutput();
			Case c = new Case(x, y);
			if (retour == null) {
				break;
			} else if (retour.intValue() == 35) {
				c.setEchafaudage(true);
				ajouterCase(map, ligneEnCours, c);
				x++;
			} else if (retour.intValue() == 46) {
				ajouterCase(map, ligneEnCours, c);
				x++;
			} else if (retour.intValue() == 10) {
				y++;
				x = 0;
				ligneEnCours = new ArrayList<Case>();
				map.add(ligneEnCours);
			}
		}
		int total = 0;
		for (var lignei : map) {
			for (Case case1 : lignei) {
				total += case1.nbrAlignement();
			}
		}
		return "" + total;
	}

	private void ajouterCase(List<List<Case>> map, List<Case> ligneEnCours, Case c) {
		ligneEnCours.add(c);
		if (c.getPositionX() >= 1) {
			c.setOuest(ligneEnCours.get(ligneEnCours.size() - 2));
		}
		if (c.getPositionY() >= 1) {
			if (c.getPositionX() < map.get(c.getPositionY() - 1).size()) {
				c.setNord(map.get(c.getPositionY() - 1).get(c.getPositionX()));
			}
		}
	}

}
