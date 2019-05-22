package annees.annee2015.jour15;

public class Ingredient {

	private String nom;
	private int capacite;
	private int durabilite;
	private int gout;
	private int texture;
	private int calories;

	public Ingredient(String nom, int capacite, int durabilite, int gout, int texture, int calories) {
		super();
		this.nom = nom;
		this.capacite = capacite;
		this.durabilite = durabilite;
		this.gout = gout;
		this.texture = texture;
		this.calories = calories;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getDurabilite() {
		return durabilite;
	}

	public void setDurabilite(int durabilite) {
		this.durabilite = durabilite;
	}

	public int getGout() {
		return gout;
	}

	public void setGout(int gout) {
		this.gout = gout;
	}

	public int getTexture() {
		return texture;
	}

	public void setTexture(int texture) {
		this.texture = texture;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Ingredient [nom=" + nom + ", capacite=" + capacite + ", durabilite=" + durabilite + ", gout=" + gout
				+ ", texture=" + texture + ", calories=" + calories + "]";
	}

}
