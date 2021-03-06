package annees.annee2019.jour11;

import commun.Case;
import commun.MapOld;
import commun.Position;

public class Peinture extends Case<Peinture> {

	private int couleur;

	public Peinture(MapOld<Peinture> peintures, Position position, int couleur) {
		super(peintures, new Position(position));
		this.couleur = couleur;
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	@Override
	public String afficher() {
		return couleur == 0 ? " " : "X";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Peinture other = (Peinture) obj;
		if (getPosition() == null) {
			if (other.getPosition() != null) {
				return false;
			}
		} else if (!getPosition().equals(other.getPosition())) {
			return false;
		}
		return true;
	}

	@Override
	public Peinture getThis() {
		return this;
	}

}
