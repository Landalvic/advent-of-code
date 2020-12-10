package annees.annee2020.jour07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour7Exercice1 extends Annee2020Jour7 {

	public static void main(String[] args) {
		new Annee2020Jour7Exercice1().lancer(2020, 7, 1, true);
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
		Set<Sac> result = new HashSet<Sac>();
		result.add(notre);
		List<Sac> sacsQuiP = new ArrayList<Sac>();
		sacsQuiP.add(notre);
		int tailleResult = result.size();
		do {
			tailleResult = result.size();
			sacsQuiP = new ArrayList<Sac>();
			for (Sac sac : sacs) {
				for (Sac sac2 : result) {
					if (sac.getSacs().contains(sac2)) {
						sacsQuiP.add(sac);
						break;
					}
				}
			}
			result.addAll(sacsQuiP);
		} while (tailleResult != result.size());
		return String.valueOf(result.size());
	}

}
