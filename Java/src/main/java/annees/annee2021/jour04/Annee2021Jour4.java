package annees.annee2021.jour04;

import java.util.List;
import java.util.function.BiFunction;

import org.apache.commons.lang3.StringUtils;

import commun.structure.AdventOfCodeException;
import commun.structure.ExerciceInputBlocToObject;

public abstract class Annee2021Jour4 extends ExerciceInputBlocToObject<PlancheBingo> {

	protected Annee2021Jour4(int exercice) {
		super(2021, 4, exercice);
	}

	protected String plancheToAnswer(int numero, PlancheBingo planche) {
		return String.valueOf(planche.totalNonGagnant() * numero);
	}

	protected String applyToGagnant(List<Integer> tirage, List<PlancheBingo> planches, BiFunction<Integer, PlancheBingo, String> function) throws AdventOfCodeException {
		for (int numero : tirage) {
			for (PlancheBingo plancheBingo : planches) {
				if (!plancheBingo.isGagnant()) {
					plancheBingo.validerNumero(numero);
					if (plancheBingo.isGagnant()) {
						var retour = function.apply(numero, plancheBingo);
						if (retour != null) {
							return retour;
						}
					}
				}
			}
		}
		throw new AdventOfCodeException("pas de planche gagnante trouvée.");
	}

	@Override
	protected PlancheBingo blocToObject(List<String> lines) {
		PlancheBingo p = new PlancheBingo();
		for (int i = 0; i < lines.size(); i++) {
			var blocs = lines.get(i).split(" ");
			int colonne = 0;
			for (String string : blocs) {
				if (StringUtils.isNotEmpty(string)) {
					p.getPlanche()[i][colonne] = new NumeroBingo(Integer.parseInt(string));
					colonne++;
				}
			}
		}
		return p;
	}

}
