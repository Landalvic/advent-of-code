package annee.annee2018.jour2;

import java.util.HashMap;
import java.util.List;

import util.FileUtils;

public class Jour2Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour2/data.txt");
		int total2Fois = 0;
		int total3Fois = 0;
		for (String string : liste) {
			HashMap<Character, Integer> comptage = new HashMap<>();
			for (int i = 0; i < string.length(); i++) {
				Character character = string.charAt(i);
				comptage.put(character, comptage.getOrDefault(character, 0) + 1);
			}
			boolean si2Fois = false;
			boolean si3Fois = false;
			for (Integer value : comptage.values()) {
				if (value == 2) {
					si2Fois = true;
				} else if (value == 3) {
					si3Fois = true;
				}
			}
			if (si2Fois) {
				total2Fois++;
			}
			if (si3Fois) {
				total3Fois++;
			}
		}
		System.out.println(total2Fois * total3Fois);
	}

}
