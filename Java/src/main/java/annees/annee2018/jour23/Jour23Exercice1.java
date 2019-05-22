package annees.annee2018.jour23;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import util.FileUtils;

public class Jour23Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour23/data.txt");
		Pattern positionPattern = Pattern.compile("pos=<(.*)>.*");
		Pattern rayonPattern = Pattern.compile(".*>, r=(.*)");
		List<Nanobot> nanobots = new ArrayList<>(liste.size());
		Nanobot nanobotPlusPuissant = new Nanobot(0, 0, 0, 0);
		for (String string : liste) {
			String[] position = FileUtils.trouverPattern(string, positionPattern).split(",");
			int rayon = FileUtils.trouverPatternInt(string, rayonPattern);
			Nanobot nanobot = new Nanobot(Integer.valueOf(position[0]), Integer.valueOf(position[1]),
					Integer.valueOf(position[2]), rayon);
			nanobots.add(nanobot);
			if (nanobotPlusPuissant.getPuissanceSignal() < nanobot.getPuissanceSignal()) {
				nanobotPlusPuissant = nanobot;
			}
		}

		int nbrNanobotsAPortee = 0;
		for (Nanobot nanobot : nanobots) {
			if (nanobotPlusPuissant.aPortee(nanobot)) {
				nbrNanobotsAPortee++;
			}
		}
		System.out.println(nbrNanobotsAPortee);
	}

}
