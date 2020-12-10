package annees.annee2019.jour16;

import java.util.Arrays;
import java.util.List;

import org.ejml.simple.SimpleMatrix;

import commun.structure.AdventOfCodeException;
import commun.structure.Exercice;
import commun.util.FileUtils;

public class Annee2019Jour16Exercice4 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour16Exercice4().lancer("src/main/resources/annee2019/jour16/data.txt");
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
		sousLigne = new StringBuilder(sousLigne.substring(decalage));
		double[] entiers = new double[(sousLigne.length())];
		for (int i = 0; i < sousLigne.length(); i++) {
			int c = Integer.parseInt("" + sousLigne.charAt(i));
			entiers[i] = c;
		}

		double[][] matrice = new double[sousLigne.length()][sousLigne.length()];
		int changementPhase1 = decalage;
		for (int i = 0; i < matrice.length; i++) {
			changementPhase1++;
			for (int j = 0; j < matrice.length; j++) {
				int test = phase.get((((i + decalage + 1) / changementPhase1)) % phase.size());
				matrice[i][j] = test;
			}
		}
		SimpleMatrix matrix = new SimpleMatrix(matrice);

		double[][] entiersMatrice = new double[1][entiers.length];
		entiersMatrice[0] = entiers;
		SimpleMatrix entiersMatrix = new SimpleMatrix(entiersMatrice);

		for (int k = 0; k < 100; k++) {
			entiersMatrix = matrix.mult(entiersMatrix);
			System.out.println(k);
		}
		System.out.println(entiersMatrix);
		String fin = "";
		for (int i = 0; i < 8; i++) {
			fin += entiers[i];
		}
		return fin;
	}

}
