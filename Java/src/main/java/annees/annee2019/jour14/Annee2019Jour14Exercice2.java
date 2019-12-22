package annees.annee2019.jour14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour14Exercice2 extends Exercice {

	protected static final Pattern pattern = Pattern.compile("<x=(.*), y=(.*), z=(.*)>");

	public static void main(String[] args) {
		new Annee2019Jour14Exercice2().lancer("src/main/resources/annee2019/jour14/data.txt");
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
		Map<String, Produit> quantites = new HashMap<>();
		int tailleE = 400000;
		long quantiteDepart = 0;
		for (int i = 1; i <= tailleE; i++) {
			quantiteDepart += calculer(reactions, quantites, "FUEL");
			if (i % (tailleE / 10) == 0) {
				System.out.println("10000 fait");
			}
		}
		System.out.println("echantillon fait");
		long ores = 1000000000000L;

		int multiplicateur = (int) ((ores / quantiteDepart) * 0.95);
		long nbrOre = quantiteDepart * multiplicateur;
		long fois = multiplicateur * tailleE;
		while (nbrOre < ores) {
			long r = (long) calculer(reactions, quantites, "FUEL");
			nbrOre += r;
			fois++;
		}
		// long fuel = approche(reactions, ores, quantiteDepart, quantites);

		return "" + (fois - 1);
	}

	private int calculer(List<Reaction> reactions, Map<String, Produit> quantites, String besoin) {
		Reaction b = chercherResultat(reactions, besoin);
		AtomicInteger nbrOre = new AtomicInteger();
		for (var produit : b.getBesoins()) {
			if (StringUtils.equals(produit.getKey(), "ORE")) {
				nbrOre.addAndGet(produit.getNbr());
			} else {
				Produit quant = chercherQuantite(quantites, produit.getKey());
				if (quant == null) {
					quant = new Produit(produit.getKey(), 0);
					quantites.put(quant.getKey(), quant);
				}
				while (true) {
					if (quant.getNbr() >= produit.getNbr()) {
						quant.setNbr(quant.getNbr() - produit.getNbr());
						break;
					} else {
						nbrOre.addAndGet(calculer(reactions, quantites, produit.getKey()));
					}
				}
			}
		}
		Produit quant = chercherQuantite(quantites, b.getResultat().getKey());
		if (quant == null) {
			quant = new Produit(b.getResultat().getKey(), 0);
			quantites.put(quant.getKey(), quant);
		}
		quant.setNbr(quant.getNbr() + b.getResultat().getNbr());
		return nbrOre.get();
	}

	private Produit chercherQuantite(Map<String, Produit> quantites, String key) {
		return quantites.get(key);
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
