package annees.annee2019.jour14;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour14Exercice1 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour14Exercice1().lancer("src/main/resources/annee2019/jour14/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var lignes = FileUtils.listOfLines(input);
		List<Reaction> reactions = new ArrayList<>();
		for (String string : lignes) {
			var compose = string.split("=>");
			var besoins = compose[0].split(",");
			List<Produit> produits = new ArrayList<Produit>();
			for (String string2 : besoins) {
				var element = string2.trim().split(" ");
				produits.add(new Produit(element));
			}
			reactions.add(new Reaction(produits, new Produit(compose[1].trim().split(" "))));
		}
		List<Produit> quantites = new ArrayList<Produit>();

		long quantiteDepart = calculer(reactions, quantites, "FUEL");
		long ores = 1000000000000L;
		int multiplicateur = (int) (ores * 0.95 / quantiteDepart);
		for (Produit produit : quantites) {
			produit.setNbr(produit.getNbr() * multiplicateur);
		}
		long nbrOre = quantiteDepart * multiplicateur;
		long fois = multiplicateur;
		while (nbrOre < ores) {
			nbrOre += (long) calculer(reactions, quantites, "FUEL");
			fois++;
		}

		return "" + fois;
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
