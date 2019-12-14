package annees.annee2019.jour14;

public class Produit {

	private String key;
	private int nbr;

	public Produit(String[] blocs) {
		super();
		nbr = Integer.parseInt(blocs[0]);
		key = blocs[1];
	}

	public Produit(String key, int nbr) {
		super();
		this.key = key;
		this.nbr = nbr;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	@Override
	public String toString() {
		return "Produit [key=" + key + ", nbr=" + nbr + "]";
	}

}
