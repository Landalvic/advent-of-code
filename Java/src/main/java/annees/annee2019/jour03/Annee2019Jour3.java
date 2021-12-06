package annees.annee2019.jour03;

import java.util.ArrayList;
import java.util.List;

import commun.Position;
import commun.structure.ExerciceInputToObject;

public abstract class Annee2019Jour3 extends ExerciceInputToObject<List<Wire>> {

	protected Annee2019Jour3(int exercice) {
		super(2019, 3, exercice);
	}

	@Override
	protected List<Wire> ligneToObject(String ligne) {
		var blocs = ligne.split(",");
		List<Wire> wires = new ArrayList<>(blocs.length);
		var lastPosition = new Position(0, 0);
		double lastDistance = 0;
		for (String wire : blocs) {
			String direction = String.valueOf(wire.charAt(0));
			int nombre = Integer.parseInt(wire.substring(1));
			Wire newWire = null;
			Position position = null;
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
				case "D":
					position = new Position(lastPosition.getX(), lastPosition.getY() - nombre);
					break;
				default:
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
