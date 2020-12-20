package annees.annee2019.jour13;

import commun.Case;
import commun.MapOld;
import commun.Position;

public class Bloc extends Case<Bloc> {

	private long valeur;

	public Bloc(MapOld<Bloc> map, Position position, long value) {
		super(map, position);
		this.valeur = value;
	}

	public long getValeur() {
		return valeur;
	}

	public void setValeur(long valeur) {
		this.valeur = valeur;
	}

	@Override
	public Bloc getThis() {
		return this;
	}

}
