package annees.annee2015.jour2;

import java.util.List;

import util.FileUtils;

public class Annee2015Jour2Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour2Exercice1();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour2/data.txt");
		int total = 0;
		for (String string : liste) {
			String[] dimensions = string.split("x");
			int longueur = Integer.valueOf(dimensions[0]);
			int largeur = Integer.valueOf(dimensions[1]);
			int hauteur = Integer.valueOf(dimensions[2]);

			int dim1 = longueur * largeur;
			int dim2 = hauteur * largeur;
			int dim3 = longueur * hauteur;

			int surplus = Math.min(Math.min(dim1, dim2), dim3);

			total += 2 * (dim1 + dim2 + dim3) + surplus;
		}
		System.out.println(total);
	}

}
