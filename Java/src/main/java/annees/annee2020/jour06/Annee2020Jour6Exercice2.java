package annees.annee2020.jour06;

import java.util.List;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour6Exercice2 extends Annee2020Jour6 {

	public static void main(String[] args) {
		new Annee2020Jour6Exercice2().lancer(true);
	}

	public Annee2020Jour6Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<Groupe> textes = inputToListObject(input);
		return String.valueOf(textes.stream().mapToInt(liste -> {
			liste.getInfosPersonnes().stream()
					.forEach(personne -> liste.getInfosPersonnes().get(0).retainAll(personne));
			return liste.getInfosPersonnes().get(0).size();
		}).sum());
	}

}
