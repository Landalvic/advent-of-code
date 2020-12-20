package commun.calculatrice;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.util.TexteUtils;

public class ListeBlocs implements Bloc {

	private List<Bloc> blocs;

	public ListeBlocs(String input, List<Operateur> operateurs) {
		super();
		blocs = new ArrayList<>();
		trouverProchainBloc(input, operateurs);
	}

	@Override
	public double valeur() {
		int indexMaxPriority = -1;
		Operateur opMax;
		do {
			opMax = null;
			for (int i = 0; i < blocs.size(); i++) {
				if (blocs.get(i) instanceof Operateur) {
					Operateur op = (Operateur) blocs.get(i);
					if (opMax == null || op.getPriority() > opMax.getPriority()) {
						opMax = op;
						indexMaxPriority = i;
					}
				}
			}
			if (opMax != null) {
				blocs.add(indexMaxPriority - 1, new Valeur(String.valueOf(opMax.calcul(blocs.get(indexMaxPriority - 1).valeur(), blocs.get(indexMaxPriority + 1).valeur()))));
				blocs.remove(indexMaxPriority);
				blocs.remove(indexMaxPriority);
				blocs.remove(indexMaxPriority);
			}
		} while (opMax != null);
		return blocs.get(0).valeur();
	}

	private String trouverProchainBloc(String input, List<Operateur> operateurs) {
		if (input.isEmpty()) {
			return null;
		}
		String c = String.valueOf(input.charAt(0));
		if (StringUtils.equals("(", c)) {
			String liste = TexteUtils.trouverEntreParenthese(input);
			blocs.add(new ListeBlocs(liste, operateurs));
			return trouverProchainBloc(input.substring(liste.length() + 2), operateurs);
		}
		for (Operateur operateur : operateurs) {
			if (StringUtils.equals(operateur.getCode(), c.substring(0, operateur.getCode().length()))) {
				blocs.add(operateur);
				return trouverProchainBloc(input.substring(operateur.getCode().length()), operateurs);
			}
		}
		int minProchainOperateur = Integer.MAX_VALUE;
		for (Operateur operateur : operateurs) {
			int index = input.indexOf(operateur.getCode());
			if (index > -1) {
				minProchainOperateur = Math.min(minProchainOperateur, index);
			}
		}
		if (minProchainOperateur == Integer.MAX_VALUE) {
			blocs.add(new Valeur(input));
			return null;
		} else {
			blocs.add(new Valeur(input.substring(0, minProchainOperateur)));
			return trouverProchainBloc(input.substring(minProchainOperateur), operateurs);
		}
	}

	@Override
	public String toString() {
		return "ListeBlocs [blocs=" + blocs + "]";
	}

}
