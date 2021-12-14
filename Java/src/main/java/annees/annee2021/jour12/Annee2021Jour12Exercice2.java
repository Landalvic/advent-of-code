package annees.annee2021.jour12;

import org.apache.commons.lang3.StringUtils;

import commun.Chemin;
import commun.Hierarchie;
import commun.Hierarchies;
import commun.structure.AdventOfCodeException;

public class Annee2021Jour12Exercice2 extends Annee2021Jour12 {

	public static void main(String[] args) {
		new Annee2021Jour12Exercice2().lancer(true);
	}

	public Annee2021Jour12Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Hierarchies<Grotte> hierarchies = inputTobags(input);
		Hierarchie<Grotte> start = hierarchies.trouver("start");
		Hierarchie<Grotte> end = hierarchies.trouver("end");
		return String.valueOf(start.listeChemins(end, this::verification, InfosChemin::new).size());
	}

	protected boolean verification(Chemin<Hierarchie<Grotte>, InfosChemin> chemin, Hierarchie<Grotte> grotte) {
		return grotte.getInfos().isGrande() || verificationPetiteGrotte(chemin, grotte);
	}

	protected boolean verificationPetiteGrotte(Chemin<Hierarchie<Grotte>, InfosChemin> chemin, Hierarchie<Grotte> grotte) {
		if (StringUtils.equals("start", grotte.getInfos().getId())) {
			return false;
		}
		if (chemin.getInfos().isContientDouble()) {
			return !chemin.contains(grotte);
		}
		if (chemin.contains(grotte)) {
			chemin.getInfos().setContientDouble(true);
		}
		return true;
	}

}
