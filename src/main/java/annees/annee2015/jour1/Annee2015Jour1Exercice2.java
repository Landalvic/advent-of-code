package annees.annee2015.jour1;

import org.apache.commons.lang3.StringUtils;

import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour1Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour1Exercice2();
	}

	@Override
	public void run() {
		StringBuilder arbre = FileUtils.lireLigne("./annee2015/jour1/data.txt");
		int etage = 0;
		int position = 0;
		for (int i = 0; i < arbre.length(); i++) {
			if (StringUtils.equals("" + arbre.charAt(i), "(")) {
				etage++;
			} else if (StringUtils.equals("" + arbre.charAt(i), ")")) {
				etage--;
			}
			if (etage == -1) {
				position = i + 1;
				break;
			}
		}
		System.out.println(position);
	}

}
