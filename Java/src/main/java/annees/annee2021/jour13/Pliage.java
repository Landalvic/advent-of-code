package annees.annee2021.jour13;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import commun.Position;
import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^fold along (.*)=(.*)$")
public class Pliage extends Input {

	@PatternAttribute(1)
	private String axe;
	@PatternAttribute(2)
	private Integer nombre;

	public String getAxe() {
		return axe;
	}

	public void setAxe(String axe) {
		this.axe = axe;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	@Override
	public Set<Position> run(Set<Position> positions) {
		Set<Position> newPositions = new HashSet<>();
		boolean axeX = StringUtils.equals(axe, "x");
		for (Position position : positions) {
			double posAxe = axeX ? position.getX() : position.getY();
			if (posAxe != nombre) {
				if (posAxe > nombre) {
					posAxe = 2 * nombre - posAxe;
				}
				newPositions.add(new Position(axeX ? posAxe : position.getX(), axeX ? position.getY() : posAxe));
			}
		}
		return newPositions;
	}

}
