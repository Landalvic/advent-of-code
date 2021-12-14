package annees.annee2021.jour12;

import commun.Chemin;
import commun.Hierarchie;
import commun.Hierarchies;
import commun.structure.AdventOfCodeException;

public class Annee2021Jour12Exercice1 extends Annee2021Jour12 {

	public static void main(String[] args) {
		new Annee2021Jour12Exercice1().lancer(true);
	}

	public Annee2021Jour12Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Hierarchies<Grotte> hierarchies = inputTobags(input);
		Hierarchie<Grotte> start = hierarchies.trouver("start");
		Hierarchie<Grotte> end = hierarchies.trouver("end");
		return String.valueOf(start.listeChemins(end, this::verificationPetiteGrotte).size());
	}

	protected boolean verificationPetiteGrotte(Chemin<Hierarchie<Grotte>, InfosChemin> chemin, Hierarchie<Grotte> grotte) {
		return grotte.getInfos().isGrande() || !chemin.contains(grotte);
	}

}
