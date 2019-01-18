package annees.annee2018.jour04;

import java.util.Collection;
import java.util.Comparator;

public class Annee2018Jour4Exercice1 extends Annee2018Jour4 {

	public static void main(String[] args) {
		new Annee2018Jour4Exercice1().lancer("src/main/resources/annee2018/jour04/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		Collection<Garde> gardes = inputToGardes(input);

		Garde gardeMauvais = gardes.stream().max(new Comparator<Garde>() {
			@Override
			public int compare(Garde o1, Garde o2) {
				return Integer.compare(o1.totalSommeil(), o2.totalSommeil());
			}
		}).get();
		return String.valueOf(gardeMauvais.getId() * gardeMauvais.minuteLaPire());
	}

}
