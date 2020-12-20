package annees.annee2019.jour03;

import java.util.ArrayList;
import java.util.List;

import commun.Position;
import commun.structure.ExerciceInputToObject;

public abstract class Annee2019Jour3 extends ExerciceInputToObject<List<Wire>> {

	public Annee2019Jour3(int exercice) {
		super(2019, 3, exercice);
	}

	@Override
	protected void init() {}

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
