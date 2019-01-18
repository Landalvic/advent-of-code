package annees.annee2015.jour1;

import org.apache.commons.lang3.StringUtils;

import util.FileUtils;

public class Annee2015Jour1Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour1Exercice1();
	}

	@Override
	public void run() {
		StringBuilder arbre = FileUtils.lireLigne("./annee2015/jour1/data.txt");
		int etage = 0;
		for (int i = 0; i < arbre.length(); i++) {
			if (StringUtils.equals("" + arbre.charAt(i), "(")) {
				etage++;
			} else if (StringUtils.equals("" + arbre.charAt(i), ")")) {
				etage--;
			}
		}
		System.out.println("" + etage);
	}

}
