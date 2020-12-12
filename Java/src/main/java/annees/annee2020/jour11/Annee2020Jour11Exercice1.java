package annees.annee2020.jour11;

import java.util.List;

import commun.Case;
import commun.Map;
import commun.Position;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2020Jour11Exercice1 extends Annee2020Jour11 {

	public static void main(String[] args) {
		new Annee2020Jour11Exercice1().lancer(2020, 11, 1, true);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> lignes = FileUtils.listOfLines(input);
		map = new Map<>(lignes.get(0).length(), lignes.size());
		for (int i = 0; i < lignes.size(); i++) {
			String ligne = lignes.get(i);
			for (int j = 0; j < ligne.length(); j++) {
				String c = String.valueOf(ligne.charAt(j));
				switch (c) {
				case "L":
					map.setCase(new Siege(map, new Position(j, i), false));
					break;
				case "#":
					map.setCase(new Siege(map, new Position(j, i), true));
					break;
				case ".":
					map.setCase(new Siege(map, new Position(j, i), null));
					break;
				default:
					break;
				}
			}
		}
		boolean test = true;
		while (test) {
			for (List<Siege> sieges : map.getCases()) {
				for (Siege siege : sieges) {
					gererSiege(siege);
				}
			}
			test = false;
			for (List<Siege> sieges : map.getCases()) {
				for (Siege siege : sieges) {
					if (siege.getOccupe() != null && siege.getFuturePlace() != null
							&& !siege.getFuturePlace().equals(siege.getOccupe())) {
						siege.setOccupe(siege.getFuturePlace());
						test = true;
					}
				}
			}
		}
		int count = 0;
		for (List<Siege> sieges : map.getCases()) {
			for (Siege siege : sieges) {
				if (siege.getOccupe() != null && siege.getOccupe()) {
					count++;
				}
			}
		}
		return String.valueOf(count);
	}

	private void gererSiege(Siege siege) {
		var adj = siege.getCasesAdjacentesDiag();
		var testAll = true;
		int occupe = 0;
		int nonOccupe = 0;
		for (Case a : adj) {
			Siege siegeA = (Siege) a;
			if (siegeA.getOccupe() != null && siegeA.getOccupe().booleanValue()) {
				testAll = false;
				occupe++;
			}
		}
		if (testAll) {
			siege.setFuturePlace(true);
		} else if (occupe >= 4) {
			siege.setFuturePlace(false);
		} else {
			siege.setFuturePlace(null);
		}
	}

}
