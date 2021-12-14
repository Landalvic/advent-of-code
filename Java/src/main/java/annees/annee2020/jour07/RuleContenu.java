package annees.annee2020.jour07;

import commun.annotation.PatternAttribute;
import commun.annotation.PatternClass;

@PatternClass("^(\\d) (.*) (bags|bag)$")
public class RuleContenu {

	@PatternAttribute(1)
	private Integer nombre;
	@PatternAttribute(2)
	private String bag;

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	public String getBag() {
		return bag;
	}

	public void setBag(String bag) {
		this.bag = bag;
	}

	@Override
	public String toString() {
		return "RuleContenu [nombre=" + nombre + ", bag=" + bag + "]";
	}

}
