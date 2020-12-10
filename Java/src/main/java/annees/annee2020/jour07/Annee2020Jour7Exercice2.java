package annees.annee2020.jour07;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour7Exercice2 extends Annee2020Jour7 {

	public static void main(String[] args) {
		new Annee2020Jour7Exercice2().lancer(2020, 7, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Sac> sacs = inputToListObject(input);
		for (int i = 0; i < sacs.size(); i++) {
			sacs.get(i).trouverConteneur(sacs);
		}
		Sac notre = null;
		for (Sac sac : sacs) {
			if (StringUtils.equals(sac.getType(), "shiny gold")) {
				notre = sac;
				break;
			}
		}
		return String.valueOf(gererSac(notre, 1));
	}

	private int gererSac(Sac sac, int multiplicateur) {
		int total = sac.getNombres().stream().mapToInt(i -> i).sum() * multiplicateur;
		for (int j = 0; j < sac.getSacs().size(); j++) {
			total += gererSac(sac.getSacs().get(j), sac.getNombres().get(j) * multiplicateur);
		}
		return total;
	}

}
