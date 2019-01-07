package annees.annee2018.jour25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.FileUtils;

public class Jour25Exercice1 {

	public static void main(String[] args) {
		List<String> liste = FileUtils.lireFichier("./jour25/data.txt");
		List<PointFixe> points = new ArrayList<>();
		for (String string : liste) {
			String[] positions = string.split(",");
			PointFixe point = new PointFixe(Integer.valueOf(positions[0]), Integer.valueOf(positions[1]),
					Integer.valueOf(positions[2]), Integer.valueOf(positions[3]));
			points.add(point);
		}

		boolean changement = false;
		do {
			changement = false;
			for (PointFixe point : points) {
				for (PointFixe point2 : points) {
					if (point.distance(point2) <= 3 && point.getConstellation() != point2.getConstellation()) {
						Constellation c = new Constellation(point.getConstellation(), point2.getConstellation());
						for (PointFixe pointFixe : c.getPoints()) {
							pointFixe.setConstellation(c);
						}
						changement = true;
					}
				}
			}

		} while (changement);

		Set<Constellation> constellations = new HashSet<>();
		for (PointFixe point : points) {
			constellations.add(point.getConstellation());
		}
		System.out.println(constellations.size());

	}

}
