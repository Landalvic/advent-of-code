package annees.annee2019.jour08;

import java.util.ArrayList;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public abstract class Annee2019Jour8 extends Exercice {

	protected List<List<List<Integer>>> inputToImage(String input, int wide, int tall) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		List<List<List<Integer>>> pixels = new ArrayList<>();
		int i = 0;
		while (i < ligne.length()) {
			List<List<Integer>> couche = new ArrayList<>();
			for (int j = 0; j < tall; j++) {
				List<Integer> couche2 = new ArrayList<>();
				for (int k = 0; k < wide; k++) {
					couche2.add(Integer.parseInt("" + ligne.charAt(i)));
					i++;
				}
				couche.add(couche2);
			}
			pixels.add(couche);
		}
		return pixels;
	}

}
