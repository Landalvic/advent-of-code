package annees.annee2015.jour2;

import java.util.List;

import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour2Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour2Exercice2();
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

			int max = Math.max(Math.max(longueur, largeur), hauteur);
			int enveloppe = 2 * (longueur + largeur + hauteur - max);
			int arc = longueur * largeur * hauteur;

			total += enveloppe + arc;
		}
		System.out.println(total);
	}

}
