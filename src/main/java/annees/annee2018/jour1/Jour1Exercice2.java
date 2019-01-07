package annees.annee2018.jour1;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import util.FileUtils;

public class Jour1Exercice2 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour1/data.txt");
		Set<Integer> frequenceDejaVues = new TreeSet<>();
		int total = 0;
		boolean fin = true;
		while (fin) {
			for (String string : liste) {
				total += Integer.valueOf(string);
				if (frequenceDejaVues.contains(total)) {
					System.out.println(total);
					fin = false;
					break;
				} else {
					frequenceDejaVues.add(total);
				}
			}
		}
	}

}
