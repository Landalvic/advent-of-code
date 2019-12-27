package annees.annee2019.jour03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import commun.AdventOfCodeException;
import commun.Exercice;
import commun.Position;
import util.FileUtils;

public abstract class Annee2019Jour3 extends Exercice {

	protected List<List<Wire>> inputToWires(String input) throws AdventOfCodeException {
		var stream = FileUtils.streamOfLines(input);
		return stream.map(this::stringToWires).collect(Collectors.toList());
	}

	private List<Wire> stringToWires(String ligne) {
		var blocs = ligne.split(",");
		List<Wire> wires = new ArrayList<>(blocs.length);
		var lastPosition = new Position(0, 0);
		double lastDistance = 0;
		for (String wire : blocs) {
			String direction = String.valueOf(wire.charAt(0));
			int nombre = Integer.parseInt(wire.substring(1));
			Wire newWire = null;
			switch (direction) {
			case "R":
				newWire = new Wire(lastPosition, new Position(lastPosition.getX() + nombre, lastPosition.getY()),
						lastDistance);
				break;
			case "U":
				newWire = new Wire(lastPosition, new Position(lastPosition.getX(), lastPosition.getY() + nombre),
						lastDistance);
				break;
			case "L":
				newWire = new Wire(lastPosition, new Position(lastPosition.getX() - nombre, lastPosition.getY()),
						lastDistance);
				break;
			default:
				newWire = new Wire(lastPosition, new Position(lastPosition.getX(), lastPosition.getY() - nombre),
						lastDistance);
				break;
			}
			lastPosition = newWire.getPositionArrivee();
			lastDistance += newWire.longueur();
			wires.add(newWire);
		}
		return wires;
	}

}
