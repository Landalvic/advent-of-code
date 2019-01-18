package annees.annee2015.jour18;

import java.util.ArrayList;
import java.util.List;

public class Lumiere {

	private boolean allume;
	private boolean prochaineEtape;
	private boolean bloque;
	private List<Lumiere> voisins;

	public Lumiere(boolean allume) {
		super();
		this.allume = allume;
		prochaineEtape = allume;
		voisins = new ArrayList<>();
		bloque = false;
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
		if (bloque) {
			allume = true;
			prochaineEtape = true;
		}
	}

	public void etapeSuivante() {
		if (!bloque) {
			int nbrVoisinsAllumes = 0;
			for (Lumiere voisin : voisins) {
				if (voisin.allume) {
					nbrVoisinsAllumes++;
				}
			}
			if (allume) {
				if (nbrVoisinsAllumes == 2 || nbrVoisinsAllumes == 3) {
					prochaineEtape = true;
				} else {
					prochaineEtape = false;
				}
			} else {
				if (nbrVoisinsAllumes == 3) {
					prochaineEtape = true;
				} else {
					prochaineEtape = false;
				}
			}
		}
	}

	public boolean isProchaineEtape() {
		return prochaineEtape;
	}

	public void setProchaineEtape(boolean prochaineEtape) {
		this.prochaineEtape = prochaineEtape;
	}

	public boolean isAllume() {
		return allume;
	}

	public void setAllume(boolean allume) {
		this.allume = allume;
	}

	public List<Lumiere> getVoisins() {
		return voisins;
	}

	public void setVoisins(List<Lumiere> voisins) {
		this.voisins = voisins;
	}

}
