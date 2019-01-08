package annees.annee2015.jour14;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import commun.Exercice;
import util.FileUtils;

public class Annee2015Jour14Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2015Jour14Exercice2();
	}

	@Override
	public void run() {
		List<String> liste = FileUtils.lireFichier("./annee2015/jour14/data.txt");
		Pattern rennePattern = Pattern.compile("(.*) can fly .*");
		Pattern vitessePattern = Pattern.compile(".* can fly (.*) km/s for .*");
		Pattern endurancePattern = Pattern.compile(".* for (.*) seconds, but then must rest for .*");
		Pattern reposPattern = Pattern.compile(".* rest for (.*) second.*");

		List<Renne> rennes = new ArrayList<>();

		for (String string : liste) {
			String renne = FileUtils.trouverPattern(string, rennePattern);
			int vitesse = FileUtils.trouverPatternInt(string, vitessePattern);
			int endurance = FileUtils.trouverPatternInt(string, endurancePattern);
			int repos = FileUtils.trouverPatternInt(string, reposPattern);
			rennes.add(new Renne(renne, vitesse, endurance, repos));
		}

		for (int i = 0; i < 2503; i++) {
			for (Renne renne : rennes) {
				renne.courir1s();
			}

			int distanceMax = 0;
			for (Renne renne : rennes) {
				distanceMax = Math.max(distanceMax, renne.getDistance());
			}
			for (Renne renne : rennes) {
				if (renne.getDistance() == distanceMax) {
					renne.setPoints(renne.getPoints() + 1);
				}
			}
		}

		int pointsMax = 0;
		for (Renne renne : rennes) {
			pointsMax = Math.max(pointsMax, renne.getPoints());
		}
		System.out.println(pointsMax);

	}

}
