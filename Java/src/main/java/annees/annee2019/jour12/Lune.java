package annees.annee2019.jour12;

import java.util.List;

import commun.Cycle;
import commun.Position;

public class Lune {

	private Position position;
	private Position velocite;
	private Cycle<Double> cycleX = new Cycle<>();
	private Cycle<Double> cycleY = new Cycle<>();
	private Cycle<Double> cycleZ = new Cycle<>();

	public Lune(Position position) {
		super();
		this.position = position;
		this.velocite = new Position();
		cycleX.add(position.getX());
		cycleY.add(position.getY());
		cycleZ.add(position.getZ());
	}

	public void calculerVitesse(List<Lune> lunes) {
		for (Lune lune : lunes) {
			if (lune != this) {
				if (lune.position.getX() > position.getX()) {
					velocite.addX(1);
				} else if (lune.position.getX() < position.getX()) {
					velocite.addX(-1);
				}
				if (lune.position.getY() > position.getY()) {
					velocite.addY(1);
				} else if (lune.position.getY() < position.getY()) {
					velocite.addY(-1);
				}
				if (lune.position.getZ() > position.getZ()) {
					velocite.addZ(1);
				} else if (lune.position.getZ() < position.getZ()) {
					velocite.addZ(-1);
				}
			}
		}
	}

	public void deplacer() {
		position.ajouter(velocite);
		cycleX.add(position.getX());
		cycleY.add(position.getY());
		cycleZ.add(position.getZ());
	}

	public boolean fin() {
		return cycleX.isCycleFini() && cycleY.isCycleFini() && cycleZ.isCycleFini();
	}

	public int calculerEnergie() {
		return (int) (position.distanceFromCenter() * velocite.distanceFromCenter());
	}

	public Cycle<Double> getCycleX() {
		return cycleX;
	}

	public void setCycleX(Cycle<Double> cycleX) {
		this.cycleX = cycleX;
	}

	public Cycle<Double> getCycleY() {
		return cycleY;
	}

	public void setCycleY(Cycle<Double> cycleY) {
		this.cycleY = cycleY;
	}

	public Cycle<Double> getCycleZ() {
		return cycleZ;
	}

	public void setCycleZ(Cycle<Double> cycleZ) {
		this.cycleZ = cycleZ;
	}

}
