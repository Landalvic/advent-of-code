package annees.annee2020.jour06;

import java.util.stream.Stream;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour6Exercice2 extends Annee2020Jour6 {

	public static void main(String[] args) {
		new Annee2020Jour6Exercice2().lancer(2020, 6, 2, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Stream<Groupe> textes = inputToStreamObjectNotNull(input);
		return String.valueOf(textes.mapToInt(liste -> {
			liste.getInfosPersonnes().stream()
					.forEach(personne -> liste.getInfosPersonnes().get(0).retainAll(personne));
			return liste.getInfosPersonnes().get(0).size();
		}).sum());
	}

}
