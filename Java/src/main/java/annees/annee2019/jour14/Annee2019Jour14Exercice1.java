package annees.annee2019.jour14;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;

public class Annee2019Jour14Exercice1 extends Annee2019Jour14 {

	public static void main(String[] args) {
		new Annee2019Jour14Exercice1().lancer(2019, 14, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Reaction> reactions = inputToReactions(input);
		List<Produit> quantites = new ArrayList<>();

		long quantiteDepart = calculer(reactions, quantites, "FUEL");
		return "" + quantiteDepart;
	}

	private int calculer(List<Reaction> reactions, List<Produit> quantites, String besoin) {
		Reaction b = chercherResultat(reactions, besoin);
		int nbrOre = 0;
		for (Produit produit : b.getBesoins()) {
			if (StringUtils.equals(produit.getKey(), "ORE")) {
				nbrOre += produit.getNbr();
			} else {
				Produit quant = chercherQuantite(quantites, produit.getKey());
				if (quant == null) {
					quant = new Produit(produit.getKey(), 0);
					quantites.add(quant);
				}
				while (true) {
					if (quant.getNbr() >= produit.getNbr()) {
						quant.setNbr(quant.getNbr() - produit.getNbr());
						break;
					} else {
						nbrOre += calculer(reactions, quantites, produit.getKey());
					}
				}
			}
		}
		Produit quant = chercherQuantite(quantites, b.getResultat().getKey());
		if (quant == null) {
			quant = new Produit(b.getResultat().getKey(), 0);
			quantites.add(quant);
		}
		quant.setNbr(quant.getNbr() + b.getResultat().getNbr());
		return nbrOre;
	}

	private Produit chercherQuantite(List<Produit> quantites, String key) {
		for (Produit reaction : quantites) {
			if (StringUtils.equals(reaction.getKey(), key)) {
				return reaction;
			}
		}
		return null;
	}

	private Reaction chercherResultat(List<Reaction> reactions, String key) {
		for (Reaction reaction : reactions) {
			if (StringUtils.equals(reaction.getResultat().getKey(), key)) {
				return reaction;
			}
		}
		return null;
	}

}
