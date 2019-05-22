package annees.annee2015.jour21;

public class Joueur {

	private int pv;
	private int degats;
	private int armure;

	public Joueur(int pv, int degats, int armure) {
		super();
		this.pv = pv;
		this.degats = degats;
		this.armure = armure;
	}

	public void attaquer(Joueur joueur) {
		int degats = getDegats() - joueur.getArmure();
		if (degats <= 0) {
			degats = 1;
		}
		joueur.setPv(joueur.getPv() - degats);
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public int getArmure() {
		return armure;
	}

	public void setArmure(int armure) {
		this.armure = armure;
	}

	@Override
	public String toString() {
		return "Joueur [pv=" + pv + ", degats=" + degats + ", armure=" + armure + "]";
	}

}
