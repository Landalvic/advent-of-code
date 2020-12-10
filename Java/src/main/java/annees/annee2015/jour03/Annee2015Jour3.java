package annees.annee2015.jour03;

import java.util.List;

import commun.structure.Exercice;

public abstract class Annee2015Jour3 extends Exercice {

	protected Maison addMaison(List<Maison> maisons, int positionX, int positionY) {
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
