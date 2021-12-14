package annees.annee2021.jour11;

import commun.Case;
import commun.MapCases;
import commun.Position;

public class Pieuvre extends Case<Pieuvre> {

	private int nombre;
	private boolean clignotement;

	public Pieuvre(MapCases<Pieuvre> map, Position position, int nombre) {
		super(map, position);
		this.nombre = nombre;
		clignotement = false;
	}

	public boolean reinit() {
		if (clignotement) {
			clignotement = false;
			nombre = 0;
			return true;
		} else {
			return false;
		}
	}

	public void clignoter() {
		if (nombre > 9 && !clignotement) {
			clignotement = true;
			getCasesAdjacentesDiag().stream().forEach(c -> {
				c.augmenterNombre();
				c.clignoter();
			});
		}
	}

	public void augmenterNombre() {
		nombre++;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public boolean isClignotement() {
		return clignotement;
	}

	public void setClignotement(boolean clignotement) {
		this.clignotement = clignotement;
	}

	@Override
	public Pieuvre getThis() {
		return this;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
