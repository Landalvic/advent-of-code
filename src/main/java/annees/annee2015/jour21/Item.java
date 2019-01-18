package annees.annee2015.jour21;

public class Item {

	private String nom;
	private int cout;
	private int dommages;
	private int armure;
	private int ordre;

	public Item(String nom, int cout, int dommages, int armure, int ordre) {
		super();
		this.nom = nom;
		this.cout = cout;
		this.dommages = dommages;
		this.armure = armure;
		this.ordre = ordre;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getDommages() {
		return dommages;
	}

	public void setDommages(int dommages) {
		this.dommages = dommages;
	}

	public int getArmure() {
		return armure;
	}

	public void setArmure(int armure) {
		this.armure = armure;
	}

	@Override
	public String toString() {
		return "Item [nom=" + nom + ", cout=" + cout + ", dommages=" + dommages + ", armure=" + armure + "]";
	}

}
