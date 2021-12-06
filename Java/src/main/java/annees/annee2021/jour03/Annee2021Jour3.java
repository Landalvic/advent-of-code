package annees.annee2021.jour03;

import org.apache.commons.lang3.StringUtils;

import commun.Position;
import commun.structure.Exercice;

public abstract class Annee2021Jour3 extends Exercice {

	protected Annee2021Jour3(int exercice) {
		super(2021, 3, exercice);
	}

	protected void updatePosition(String character, Position position) {
		if (StringUtils.equals(character, "1")) {
			position.addX(1);
		} else {
			position.addY(1);
		}
	}

}
