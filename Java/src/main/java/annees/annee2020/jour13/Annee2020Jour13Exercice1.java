package annees.annee2020.jour13;

import java.util.List;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;
import commun.util.MathUtils;

public class Annee2020Jour13Exercice1 extends Annee2020Jour13 {

	public static void main(String[] args) {
		new Annee2020Jour13Exercice1().lancer(true);
	}

	public Annee2020Jour13Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		int id = Integer.parseInt(lignes.get(0));
		int increment = id;
		List<Bus> bus = inputToBus(input);
		while (true) {
			for (Bus b : bus) {
				if (MathUtils.listeDiviseurs(increment).contains(b.getId())) {
					return String.valueOf((increment - id) * b.getId());
				}
			}
			increment++;
		}
	}

}
