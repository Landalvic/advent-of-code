package annees.annee2015.jour5;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Annee2015Jour5Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour5Exercice1();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour5/data.txt");
		int total = 0;
		for (String string : liste) {
			int nbrVoyelle = 0;
			boolean doubleLettre = false;
			boolean condition3 = true;
			for (int i = 0; i < string.length(); i++) {
				if (StringUtils.equals("" + string.charAt(i), "a") || StringUtils.equals("" + string.charAt(i), "e")
						|| StringUtils.equals("" + string.charAt(i), "i")
						|| StringUtils.equals("" + string.charAt(i), "o")
						|| StringUtils.equals("" + string.charAt(i), "u")) {
					nbrVoyelle++;
				}
				if (i >= 1) {
					char voyellePrec = string.charAt(i - 1);
					String chaine = "" + voyellePrec + string.charAt(i);
					if (voyellePrec == string.charAt(i)) {
						doubleLettre = true;
					}
					if (StringUtils.equals(chaine, "ab") || StringUtils.equals(chaine, "cd")
							|| StringUtils.equals(chaine, "pq") || StringUtils.equals(chaine, "xy")) {
						condition3 = false;
					}
				}
			}
			if (nbrVoyelle >= 3 && doubleLettre && condition3) {
				total++;
			}
		}
		System.out.println(total);
	}

}
