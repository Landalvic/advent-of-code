package annees.annee2018.jour22;

import java.io.IOException;
import java.util.List;

import util.FileUtils;

public class Jour22Exercice1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		List<String> liste = FileUtils.lireFichier("./jour22/data.txt");

		int profondeur = Integer.valueOf(liste.get(0).split(" ")[1]);
		int positionXCible = Integer.valueOf(liste.get(1).split(" ")[1].split(",")[0]);
		int positionYCible = Integer.valueOf(liste.get(1).split(" ")[1].split(",")[1]);
		Region[][] map = new Region[positionXCible + 1][positionYCible + 1];

		for (int i = 0; i <= positionXCible; i++) {
			for (int j = 0; j <= positionYCible; j++) {
				int indiceGeologique;
				if (i == 0 && j == 0) {
					indiceGeologique = 0;
				} else if (i == positionXCible && j == positionYCible) {
					indiceGeologique = 0;
				} else if (i == 0) {
					indiceGeologique = j * 48271;
				} else if (j == 0) {
					indiceGeologique = i * 16807;
				} else {
					indiceGeologique = map[i - 1][j].getNiveauErosion() * map[i][j - 1].getNiveauErosion();
				}
				map[i][j] = new Region(i, j, indiceGeologique, (indiceGeologique + profondeur) % 20183);
			}
		}

		int totalRisque = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				totalRisque += map[i][j].getNiveauRisque();
			}
		}
		System.out.println(totalRisque);
	}

}
