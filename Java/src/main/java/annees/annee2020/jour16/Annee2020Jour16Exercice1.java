package annees.annee2020.jour16;

import commun.structure.AdventOfCodeException;

public class Annee2020Jour16Exercice1 extends Annee2020Jour16 {

	public static void main(String[] args) {
		new Annee2020Jour16Exercice1().lancer(true);
	}

	public Annee2020Jour16Exercice1() {
		super(1);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		chargerInput(input);
		return String.valueOf(autres.stream().mapToInt(ticket -> ticket.getChamps().stream().filter(champ -> infos.values().stream()
				.noneMatch(info -> (champ >= info.getMin1() && champ <= info.getMax1()) || (champ >= info.getMin2() && champ <= info.getMax2()))).mapToInt(i -> i).sum()).sum());
	}

}
