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
			Position position;
			switch (direction) {
			case "R":
				position = new Position(lastPosition.getX() + nombre, lastPosition.getY());
				break;
			case "U":
				position = new Position(lastPosition.getX(), lastPosition.getY() + nombre);
				break;
			case "L":
				position = new Position(lastPosition.getX() - nombre, lastPosition.getY());
				break;
			default:
				position = new Position(lastPosition.getX(), lastPosition.getY() - nombre);
				break;
			}
			newWire = new Wire(lastPosition, position, lastDistance);
			lastPosition = newWire.getPositionArrivee();
			lastDistance += newWire.longueur();
			wires.add(newWire);
		}
		return wires;
	}

}
