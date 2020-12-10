package annees.annee2018.jour02;

import java.util.List;

import commun.structure.AdventOfCodeException;
import commun.util.FileUtils;

public class Annee2018Jour2Exercice2 extends Annee2018Jour2 {

	public static void main(String[] args) {
		new Annee2018Jour2Exercice2().lancer(2018, 2, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		List<String> liste = FileUtils.listOfLines(input);
		for (int i = 0; i < liste.size(); i++) {
			String string = liste.get(i);
			for (int j = i + 1; j < liste.size(); j++) {
				String stringCompare = liste.get(j);
				StringBuilder creationReponse = calculerNbrErreur(string, stringCompare);
				if (creationReponse != null) {
					return creationReponse.toString();
				}
			}
		}
		return "";
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
