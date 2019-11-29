package annees.annee2018.jour04;

import java.util.Collection;

import commun.AdventOfCodeException;

public class Annee2018Jour4Exercice2 extends Annee2018Jour4 {

	public static void main(String[] args) {
		new Annee2018Jour4Exercice2().lancer("src/main/resources/annee2018/jour04/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		Collection<Garde> gardes = inputToGardes(input);
		Garde gardeMauvais = gardes
				.stream()
				.filter(garde -> garde.minuteLaPire() >= 0)
				.max((Garde o1, Garde o2) -> Integer.compare(o1.getSommeil()[o1.minuteLaPire()], o2.getSommeil()[o2.minuteLaPire()]))
				.orElseThrow();
		return String.valueOf(gardeMauvais.minuteLaPire() * gardeMauvais.getId());
	}

}
