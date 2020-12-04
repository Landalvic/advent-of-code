package annees.annee2019.jour13;

import commun.Case;
import commun.Map;
import commun.Position;

public class Bloc extends Case {

	private long valeur;

	public Bloc(Map<Bloc> map, Position position, long value) {
		super(map, position);
		this.valeur = value;
	}

	public long getValeur() {
		return valeur;
	}

	public void setValeur(long valeur) {
		this.valeur = valeur;
	}

}
