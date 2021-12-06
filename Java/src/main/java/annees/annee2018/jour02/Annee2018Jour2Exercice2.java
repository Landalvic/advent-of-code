package annees.annee2018.jour02;

import commun.StreamSearch;
import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2018Jour2Exercice2 extends Annee2018Jour2 {

	public static void main(String[] args) {
		new Annee2018Jour2Exercice2().lancer(true);
	}

	public Annee2018Jour2Exercice2() {
		super(2);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var stream = FileUtils.streamOfLines(input);
		StreamSearch<String, String> streamSearch = new StreamSearch<>();
		return streamSearch.findCondition(stream, string -> {
			for (var string2 : string.getListe()) {
				StringBuilder creationReponse = calculerNbrErreur(string.current(), string2);
				if (creationReponse != null) {
					return creationReponse.toString();
				}
			}
			return null;
		});
	}

	private StringBuilder calculerNbrErreur(String string1, String string2) {
		int nbrErreur = 0;
		StringBuilder creationReponse = new StringBuilder();
		for (int k = 0; k < string1.length(); k++) {
			if (string1.charAt(k) != string2.charAt(k)) {
				nbrErreur++;
				if (nbrErreur > 1) {
					return null;
				}
			} else {
				creationReponse.append(string1.charAt(k));
			}
		}
		return creationReponse;
	}

}
