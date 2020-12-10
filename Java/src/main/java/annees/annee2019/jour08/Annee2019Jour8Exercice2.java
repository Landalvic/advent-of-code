package annees.annee2019.jour08;

import java.util.List;

import commun.structure.AdventOfCodeException;

public class Annee2019Jour8Exercice2 extends Annee2019Jour8 {

	public static void main(String[] args) {
		new Annee2019Jour8Exercice2().lancer(2019, 8, 2, false);
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		int wide = 25;
		int tall = 6;
		List<List<List<Integer>>> pixels = inputToImage(input, wide, tall);
		int[][] image = creerImage(pixels, wide, tall);
		return afficherMessage(image);
	}

	private int[][] creerImage(List<List<List<Integer>>> pixels, int wide, int tall) {
		int[][] image = new int[tall][wide];
		for (int i = 0; i < tall; i++) {
			for (int k = 0; k < wide; k++) {
				for (int j = 0; j < pixels.size(); j++) {
					int pixel = pixels.get(j).get(i).get(k);
					if (pixel != 2) {
						image[i][k] = pixel;
						break;
					}
				}
			}
		}
		return image;
	}

	private String afficherMessage(int[][] image) {
		var message = new StringBuilder("\n\n");
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				if (image[i][j] == 0) {
					message.append(" ");
				} else {
					message.append("X");
				}
			}
			message.append("\n");
		}
		return message.toString();
	}

}
