package annees.annee2018.jour17;

public class Zone {

	private boolean argile;
	private Zone zoneHaut;
	private Zone zoneGauche;
	private Zone zoneDroite;
	private Zone zoneBas;
	private boolean eau;
	private boolean eauStagnante;

	public Zone() {
		super();
		argile = false;
		eau = false;
		eauStagnante = false;
	}

	public void deplacementBasEau() {
		if (!isArgile()) {
			eau = true;
			if (zoneBas != null) {
				if (!zoneBas.isArgile() && !zoneBas.isEau()) {
					zoneBas.deplacementBasEau();
				} else if (!zoneBas.isEau() || zoneBas.isEauStagnante()) {
					boolean bloque = !deplacementLateralEau(true) & !deplacementLateralEau(false);
					if (bloque) {
						eauStagnante(true);
						eauStagnante(false);
						zoneHaut.deplacementBasEau();
					}
				}
			}
		}
	}

	public void eauStagnante(boolean gauche) {
		if (!isArgile()) {
			eauStagnante = true;
			if (gauche) {
				zoneGauche.eauStagnante(gauche);
			} else {
				zoneDroite.eauStagnante(gauche);
			}
		}
	}

	public boolean deplacementLateralEau(boolean gauche) {
		if (isArgile()) {
			return false;
		} else {
			eau = true;
			if (!zoneBas.isArgile() && !zoneBas.isEauStagnante()) {
				zoneBas.deplacementBasEau();
				return true;
			} else {
				if (gauche) {
					return zoneGauche.deplacementLateralEau(gauche);
				} else {
					return zoneDroite.deplacementLateralEau(gauche);
				}
			}
		}
	}

	public boolean isEauStagnante() {
		return eauStagnante;
	}

	public void setEauStagnante(boolean eauStagnante) {
		this.eauStagnante = eauStagnante;
	}

	public boolean isEau() {
		return eau;
	}

	public void setEau(boolean eau) {
		this.eau = eau;
	}

	public Zone getZoneHaut() {
		return zoneHaut;
	}

	public void setZoneHaut(Zone zoneHaut) {
		this.zoneHaut = zoneHaut;
	}

	public Zone getZoneGauche() {
		return zoneGauche;
	}

	public void setZoneGauche(Zone zoneGauche) {
		this.zoneGauche = zoneGauche;
	}

	public Zone getZoneDroite() {
		return zoneDroite;
	}

	public void setZoneDroite(Zone zoneDroite) {
		this.zoneDroite = zoneDroite;
	}

	public Zone getZoneBas() {
		return zoneBas;
	}

	public void setZoneBas(Zone zoneBas) {
		this.zoneBas = zoneBas;
	}

	public boolean isArgile() {
		return argile;
	}

	public void setArgile(boolean argile) {
		this.argile = argile;
	}

	@Override
	public String toString() {
		if (eauStagnante) {
			return "~";
		} else if (eau) {
			return "|";
		} else if (argile) {
			return "#";
		} else {
			return ".";
		}
	}

}
