package annees.annee2019.jour20;

public class Etape {

	private Case etape;
	private int profondeur;
	private Portail portail;

	public Etape(Case etape, int profondeur) {
		super();
		this.etape = etape;
		this.profondeur = profondeur;
	}

	public Etape(Case etape, int profondeur, Portail portail) {
		super();
		this.etape = etape;
		this.profondeur = profondeur;
		this.portail = portail;
	}

	public Portail getPortail() {
		return portail;
	}

	public void setPortail(Portail portail) {
		this.portail = portail;
	}

	public Case getEtape() {
		return etape;
	}

	public void setEtape(Case etape) {
		this.etape = etape;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	@Override
	public String toString() {
		return "Etape [profondeur=" + profondeur + ", portail=" + portail + "]";
	}

}
