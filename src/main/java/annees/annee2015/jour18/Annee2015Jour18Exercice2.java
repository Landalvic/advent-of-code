package annees.annee2015.jour18;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Annee2015Jour18Exercice2 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour18Exercice2();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour18/data.txt");

		Lumiere[][] lumieres = new Lumiere[100][100];
		for (int i = 0; i < liste.size(); i++) {
			String string = liste.get(i);
			for (int j = 0; j < string.length(); j++) {
				lumieres[i][j] = new Lumiere(StringUtils.equals("" + string.charAt(j), "#"));
			}
		}
		lumieres[0][0].setBloque(true);
		lumieres[0][lumieres[0].length - 1].setBloque(true);
		lumieres[lumieres.length - 1][0].setBloque(true);
		lumieres[lumieres.length - 1][lumieres[0].length - 1].setBloque(true);

		for (int i = 0; i < lumieres.length; i++) {
			for (int j = 0; j < lumieres[0].length; j++) {
				for (int k = -1; k <= 1; k++) {
					for (int l = -1; l <= 1; l++) {
						if (i + k >= 0 && j + l >= 0 && i + k < lumieres.length && j + l < lumieres[0].length) {
							if (k != 0 || l != 0) {
								lumieres[i][j].getVoisins().add(lumieres[i + k][j + l]);
							}
						}
					}
				}
			}
		}

		for (int etape = 0; etape < 100; etape++) {
			for (int i = 0; i < lumieres.length; i++) {
				for (int j = 0; j < lumieres[0].length; j++) {
					lumieres[i][j].etapeSuivante();
				}
			}
			for (int i = 0; i < lumieres.length; i++) {
				for (int j = 0; j < lumieres[0].length; j++) {
					lumieres[i][j].setAllume(lumieres[i][j].isProchaineEtape());
				}
			}
		}

		int nbrAllume = 0;
		for (int i = 0; i < lumieres.length; i++) {
			for (int j = 0; j < lumieres[0].length; j++) {
				if (lumieres[i][j].isAllume()) {
					nbrAllume++;
				}
			}
		}
		System.out.println(nbrAllume);

	}

}
