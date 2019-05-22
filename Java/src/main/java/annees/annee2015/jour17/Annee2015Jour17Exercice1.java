package annees.annee2015.jour17;

import java.util.ArrayList;
import java.util.List;

import util.FileUtils;

public class Annee2015Jour17Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour17Exercice1();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour17/data.txt");
		int lait = 150;

		List<Integer> bouteilles = new ArrayList<>();
		for (String string : liste) {
			bouteilles.add(Integer.valueOf(string));
		}

		List<Integer> indexPris = new ArrayList<>();
		int somme = 0;
		int comptage = 0;
		for (int i = 0; i < bouteilles.size(); i++) {
			if (somme + bouteilles.get(i) == lait) {
				comptage++;
			} else if (i != bouteilles.size() - 1 && somme + bouteilles.get(i) < lait) {
				somme += bouteilles.get(i);
				indexPris.add(i);
			}
			if (i == bouteilles.size() - 1 && indexPris.size() > 0) {
				i = indexPris.remove(indexPris.size() - 1);
				somme -= bouteilles.get(i);
			}
		}
		System.out.println(comptage);

	}

}
