package annees.annee2018.jour04;

import java.util.Collection;
import java.util.Comparator;

public class Annee2018Jour4Exercice2 extends Annee2018Jour4 {

	public static void main(String[] args) {
		new Annee2018Jour4Exercice2().lancer("src/main/resources/annee2018/jour04/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		Collection<Garde> gardes = inputToGardes(input);

		Garde gardeMauvais = gardes.stream().filter(garde -> garde.minuteLaPire() >= 0).max(new Comparator<Garde>() {
			@Override
			public int compare(Garde o1, Garde o2) {
				return Integer.compare(o1.getSommeil()[o1.minuteLaPire()], o2.getSommeil()[o2.minuteLaPire()]);
			}
		}).get();
		return String.valueOf(gardeMauvais.minuteLaPire() * gardeMauvais.getId());
	}

}
