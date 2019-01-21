package annees.annee2015.jour08;

import java.util.List;

import util.FileUtils;

public class Annee2015Jour8Exercice1 implements Runnable {

	public static void main(String[] args) {
		new Annee2015Jour8Exercice1();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour8/data.txt");

		int total = 0;
		for (String string : liste) {
			String epuration = string.replace("\\\\", "a");
			epuration = epuration.replace("\\\"", "a");
			epuration = epuration.replace("\"", "");
			int nbrHex = epuration.split("\\\\x").length - 1;
			int longueurEpuree = epuration.length() - (nbrHex * 3);
			total += string.length() - longueurEpuree;
		}
		System.out.println(total);

	}

}
