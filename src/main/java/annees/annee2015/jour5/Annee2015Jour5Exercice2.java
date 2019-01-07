package annees.annee2015.jour5;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour5Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour5Exercice2();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour5/data.txt");
		int total = 0;
		for (String string : liste) {
			boolean doubleLettre = false;
			boolean conditionPair = false;
			for (int i = 0; i < string.length(); i++) {
				if (i >= 1 && !conditionPair) {
					char voyellePrec1 = string.charAt(i - 1);
					String chaine = "" + voyellePrec1 + string.charAt(i);
					for (int j = 0; j < string.length() - 1; j++) {
						String chaine2 = "" + string.charAt(j) + string.charAt(j + 1);
						if (StringUtils.equals(chaine, chaine2) && i != j && i != (j + 1) && i != (j + 2)) {
							conditionPair = true;
						}
					}
				}
				if (i >= 2) {
					char voyellePrec2 = string.charAt(i - 2);
					if (voyellePrec2 == string.charAt(i)) {
						doubleLettre = true;
					}
				}
			}
			if (conditionPair && doubleLettre) {
				total++;
			}
		}
		System.out.println(total);
	}

}
