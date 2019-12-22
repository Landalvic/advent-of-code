package annees.annee2019.jour14;

import java.util.List;

public class Reaction {

	private List<Produit> besoins;
	private Produit resultat;

	public Reaction(List<Produit> besoins, Produit resultat) {
		super();
		this.besoins = besoins;
		this.resultat = resultat;
	}

	public List<Produit> getBesoins() {
		return besoins;
	}

	public void setBesoins(List<Produit> besoins) {
		this.besoins = besoins;
	}

	public Produit getResultat() {
		return resultat;
	}

	public void setResultat(Produit resultat) {
		this.resultat = resultat;
	}

	@Override
	public String toString() {
		return "Reaction [besoins=" + besoins + ", resultat=" + resultat + "]";
	}

}
