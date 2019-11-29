package annees.annee2018.jour03;

import java.util.List;

import commun.AdventOfCodeException;

public class Annee2018Jour3Exercice2 extends Annee2018Jour3 {

	public static void main(String[] args) {
		new Annee2018Jour3Exercice2().lancer("src/main/resources/annee2018/jour03/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Demande> demandes = inputToDemandes(input);
		return String.valueOf(demandes.stream().filter(Demande::isSeul).findAny().orElseThrow().getId());
	}

}
