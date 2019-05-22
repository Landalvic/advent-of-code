package annees.annee2018.jour02;

import java.util.List;

import commun.Exercice;
import util.FileUtils;

public class Annee2018Jour2Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2018Jour2Exercice2().lancer("src/main/resources/annee2018/jour02/data.txt");
	}

	@Override
	public String run(String input) throws Exception {
		List<String> liste = FileUtils.listOfLines(input);
		StringBuilder creationReponse = new StringBuilder();
		fin: for (int i = 0; i < liste.size(); i++) {
			String string = liste.get(i);
			for (int j = i + 1; j < liste.size(); j++) {
				String stringCompare = liste.get(j);
				int nbrErreur = 0;
				creationReponse = new StringBuilder();
				for (int k = 0; k < string.length(); k++) {
					if (string.charAt(k) != stringCompare.charAt(k)) {
						nbrErreur++;
						if (nbrErreur > 1) {
							break;
						}
					} else {
						creationReponse.append(string.charAt(k));
					}
				}
				if (nbrErreur <= 1) {
					break fin;
				}
			}
		}
		return creationReponse.toString();
	}

}
