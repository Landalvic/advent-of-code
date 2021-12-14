package annees.annee2021.jour02;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^(.*) (.*)$")
public class Commande {

	@PatternAttribute(1)
	private String direction;
	@PatternAttribute(2)
	private Integer nombre;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Commande [direction=" + direction + ", nombre=" + nombre + "]";
	}

}
