package annees.annee2019.jour16;

import java.util.Arrays;
import java.util.List;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour16Exercice3 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour16Exercice3().lancer("src/main/resources/annee2019/jour16/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var ligne = FileUtils.firstLine(input);
		int multiplier = 10000;
		StringBuilder sousLigne = new StringBuilder();
		for (int k = 0; k < multiplier; k++) {
			sousLigne.append(ligne);
		}
		List<Integer> phase = Arrays.asList(0, 1, 0, -1);
		int decalage = Integer.parseInt(ligne.substring(0, 7));
		sousLigne = new StringBuilder(sousLigne.substring(decalage, sousLigne.length()));
		int[] entiers = new int[(sousLigne.length())];
		for (int i = 0; i < sousLigne.length(); i++) {
			int c = Integer.parseInt("" + sousLigne.charAt(i));
			entiers[i] = c;
		}

		for (int k = 0; k < 100; k++) {
			int[] newInput = new int[entiers.length];
			int changementPhase = decalage;
			int numero = 0;
			int somme = 0;
			for (int j = 0; j < entiers.length; j++) {
				somme += entiers[j];
			}
			while (numero < entiers.length) {
				changementPhase++;
				numero++;
				String tot = ("" + somme);
				newInput[numero - 1] = Integer.parseInt("" + tot.charAt(tot.length() - 1));
				somme -= entiers[numero - 1];
			}
			entiers = newInput;
			System.out.println(k);
		}

		String fin = "";
		for (int i = 0; i < 8; i++) {
			fin += entiers[i];
		}
		return fin;
	}

}
