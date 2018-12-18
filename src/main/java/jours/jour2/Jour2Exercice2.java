package jours.jour2;

import java.util.List;

import util.FileUtils;

public class Jour2Exercice2 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour2/data.txt");
		for (int i = 0; i < liste.size(); i++) {
			String string = liste.get(i);
			for (int j = i + 1; j < liste.size(); j++) {
				String stringCompare = liste.get(j);
				int nbrErreur = 0;
				StringBuilder creationReponse = new StringBuilder();
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
					System.out.println(creationReponse);
				}
			}
		}
	}

}
