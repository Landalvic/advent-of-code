package annees.annee2018.jour11;

public class Jour11Exercice2 {

	public static void main(String[] args) {

		int entreePuzzle = 7315;

		int[][] tableau = new int[300][300];
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				tableau[i][j] = calcul(i, j, entreePuzzle);
			}
		}

		int plusPuissant = -4;
		int positionX = 0;
		int positionY = 0;
		int taillePuissante = 0;
		for (int taille = 1; taille < 300; taille++) {
			int[][] tableauResultat = new int[301 - taille][301 - taille];
			for (int i = 0; i < tableauResultat.length; i++) {
				for (int j = 0; j < tableauResultat.length; j++) {
					int total = 0;
					for (int k = 0; k < taille; k++) {
						for (int l = 0; l < taille; l++) {
							total += tableau[i + k][j + l];
						}
					}
					tableauResultat[i][j] = total;
				}
			}

			for (int i = 0; i < tableauResultat.length; i++) {
				for (int j = 0; j < tableauResultat.length; j++) {
					if (plusPuissant < tableauResultat[i][j]) {
						plusPuissant = tableauResultat[i][j];
						positionX = i;
						positionY = j;
						taillePuissante = taille;
					}
				}
			}
		}

		System.out.println(positionX + "," + positionY + "," + taillePuissante);

	}

	private static int calcul(int i, int j, int entreePuzzle) {
		int id = i + 10;
		int niveauDePuissance = id * j;
		int augmentation = niveauDePuissance + entreePuzzle;
		int definition = augmentation * id;
		String def = "" + definition;
		int centaine = Integer.valueOf("" + def.charAt(def.length() - 3));
		return centaine - 5;
	}

}
