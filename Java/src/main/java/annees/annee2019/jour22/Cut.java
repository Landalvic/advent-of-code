package annees.annee2019.jour22;

public class Cut implements Operation {

	private int cut;

	public Cut(int cut) {
		super();
		this.cut = cut;
	}

	public int getCut() {
		return cut;
	}

	public void setCut(int cut) {
		this.cut = cut;
	}

	@Override
	public int calcul(int taille, int monNombre) {
		return (monNombre + cut + taille) % taille;
	}

}
