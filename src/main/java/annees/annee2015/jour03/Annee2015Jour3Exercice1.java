package annees.annee2015.jour03;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Annee2015Jour3Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour3Exercice1();
	}

	@Override
	public void run() {
		StringBuilder arbre = FileUtils.lireLigne("./annee2015/jour3/data.txt");
		List<Maison> maisons = new ArrayList<>();
		Maison ancienneMaison = new Maison(0, 0);
		maisons.add(ancienneMaison);
		for (int i = 0; i < arbre.length(); i++) {
			if (StringUtils.equals("" + arbre.charAt(i), "<")) {
				ancienneMaison = addMaison(maisons, ancienneMaison.getPositionX() - 1, ancienneMaison.getPositionY());
			} else if (StringUtils.equals("" + arbre.charAt(i), ">")) {
				ancienneMaison = addMaison(maisons, ancienneMaison.getPositionX() + 1, ancienneMaison.getPositionY());
			} else if (StringUtils.equals("" + arbre.charAt(i), "^")) {
				ancienneMaison = addMaison(maisons, ancienneMaison.getPositionX(), ancienneMaison.getPositionY() - 1);
			} else if (StringUtils.equals("" + arbre.charAt(i), "v")) {
				ancienneMaison = addMaison(maisons, ancienneMaison.getPositionX(), ancienneMaison.getPositionY() + 1);
			}
		}
		System.out.println(maisons.size());
	}

	private Maison addMaison(List<Maison> maisons, int positionX, int positionY) {
		for (Maison maison : maisons) {
			if (maison.getPositionX() == positionX && maison.getPositionY() == positionY) {
				maison.setNbrCadeaux(maison.getNbrCadeaux() + 1);
				return maison;
			}
		}
		Maison maison = new Maison(positionX, positionY);
		maisons.add(maison);
		return maison;
	}

}
