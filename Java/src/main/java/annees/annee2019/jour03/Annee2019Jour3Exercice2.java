package annees.annee2019.jour03;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import commun.AdventOfCodeException;
import commun.Exercice;
import util.FileUtils;

public class Annee2019Jour3Exercice2 extends Exercice {

	public static void main(String[] args) {
		new Annee2019Jour3Exercice2().lancer("src/main/resources/annee2019/jour03/data.txt");
	}

	@Override
	public String run(String input) throws AdventOfCodeException {
		var liste = FileUtils.listOfLines(input);
		List<Wire> wires = new LinkedList<>();
		boolean firstPassage = false;
		for (String string : liste) {
			firstPassage = !firstPassage;
			Wire lastWire = new Wire(0, 0, 0, 0, false, 0);
			var blocs = string.split(",");
			for (String wire : blocs) {
				String direction = "" + wire.charAt(0);
				int nombre = Integer.parseInt(wire.substring(1));
				Wire newWire = null;
				if (StringUtils.equals(direction, "R")) {
					newWire = new Wire(lastWire.getxArrivee(), lastWire.getyArrivee(), lastWire.getxArrivee() + nombre, lastWire.getyArrivee(), true,
							lastWire.getDistance());
				} else if (StringUtils.equals(direction, "U")) {
					newWire = new Wire(lastWire.getxArrivee(), lastWire.getyArrivee(), lastWire.getxArrivee(), lastWire.getyArrivee() + nombre, false,
							lastWire.getDistance());
				} else if (StringUtils.equals(direction, "L")) {
					newWire = new Wire(lastWire.getxArrivee(), lastWire.getyArrivee(), lastWire.getxArrivee() - nombre, lastWire.getyArrivee(), true,
							lastWire.getDistance());
				} else if (StringUtils.equals(direction, "D")) {
					newWire = new Wire(lastWire.getxArrivee(), lastWire.getyArrivee(), lastWire.getxArrivee(), lastWire.getyArrivee() - nombre, false,
							lastWire.getDistance());
				}
				if (firstPassage) {
					wires.add(newWire);
				} else {
					boolean trouve = false;
					for (Wire w : wires) {
						w.collision(newWire);
					}
				}
				lastWire = newWire;
			}
		}

		for (Wire wire3 : wires) {
			if (wire3.collision) {
				System.out.println(wire3.getDistanceCollision1() + wire3.getDistanceCollision2());
			}
		}
		var plusProcheWire = wires
				.stream().filter(wire -> wire.isCollision()).min((wire1, wire2) -> Integer
						.compare(wire1.getDistanceCollision1() + wire1.getDistanceCollision2(), wire2.getDistanceCollision1() + wire2.getDistanceCollision2()))
				.get();

		return "" + (plusProcheWire.getDistanceCollision1() + plusProcheWire.getDistanceCollision2());
	}

}
